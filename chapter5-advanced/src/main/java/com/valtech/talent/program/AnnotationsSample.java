package com.valtech.talent.program;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static com.valtech.talent.program.AnnotationsSample.PermissionLevel.*;

public class AnnotationsSample {

    enum PermissionLevel {
        VISITOR(0), USER(2), ADMIN(4);

        private int level;

        PermissionLevel(int level){
            this.level = level;
        }

        public boolean allows(PermissionLevel permission){
            return this.level >= permission.level;
        }
    }




    @Target({ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ManagePermissions {
        PermissionLevel value() default PermissionLevel.VISITOR;
    }


    public interface CriticalService {
        void performAdminAction();
        void performUserAction();
        void performVisitorAction();
    }


    public static class CriticalServiceImpl implements CriticalService {

        @ManagePermissions(ADMIN)
        public void performAdminAction() {
            System.out.println("ADMIN action");
        }

        @ManagePermissions(USER)
        public void performUserAction() {
            System.out.println("USER action");
        }

        @ManagePermissions(VISITOR)
        public void performVisitorAction() {
            System.out.println("VISITOR action");
        }
    }


    public static class CriticalServiceProxy implements CriticalService {

        private CriticalService realService = new CriticalServiceImpl();
        private PermissionLevel contextPermissionLevel = USER;



        public void performAdminAction() {
            try {
                Method performAdminAction = realService.getClass().getDeclaredMethod("performAdminAction", null);
                checkMethodPermissions(performAdminAction, contextPermissionLevel);
                realService.performAdminAction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void performUserAction() {
            System.out.println("USER action");
        }

        public void performVisitorAction() {
            System.out.println("VISITOR action");
        }
    }




    public static void checkMethodPermissions(Method method, PermissionLevel contextPermission){
        ManagePermissions annotation = method.getAnnotation(ManagePermissions.class);

        if(!contextPermission.allows(annotation.value())){
            throw new ForbidenActionException();
        }
    }

    public static void main(String[] args) {
        CriticalService service = new CriticalServiceProxy();

        service.performVisitorAction();
        service.performUserAction();
        service.performAdminAction();
    }
}
