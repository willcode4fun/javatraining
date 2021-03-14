package com.valtech.talent.program;

public class ExceptionsSample {


    public class ActionImpossibleException extends Exception {
        public ActionImpossibleException(String message){
            super(message);
        }
    }

    public void doSomething(int amount) throws ActionImpossibleException {
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be positive");
        }

        if(amount > 1000){
            throw new ActionImpossibleException("amount over limit");
        }
    }


    public static void main(String[] args) {
        ExceptionsSample exceptionsSample = new ExceptionsSample();

        System.out.println(4 / 0);

        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at com.valtech.talent.program.ExceptionsSample.main(ExceptionsSample.java:5)

        try {
            System.out.println(4 / 0);
        } catch (Exception ex) {
            // handle exception here
            ex.printStackTrace();
        }

        try {
            exceptionsSample.doSomething(20000);
        } catch (ArithmeticException | ActionImpossibleException ex) {
            // handle exception here
            ex.printStackTrace();

            throw new RuntimeException(ex);
        } finally {
            // free resources
        }
    }
}
