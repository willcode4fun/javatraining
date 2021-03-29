package com.valtech.talent.program.libraries;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.StringWriter;
import java.util.List;

@Slf4j
public class ThymeleafSample {

    public static final String TEMPLATE_PATH = "chapter6-libraries/src/main/resources/templates/vtp.html";

    @AllArgsConstructor
    @Getter
    public static class Driver {
        private String name;
        private String type;
    }

    private static List<Driver> loadData(){
        return Lists.newArrayList(
                new Driver("Mario","M"),
                new Driver("Waluigi","M"),
                new Driver("Toad","S"),
                new Driver("Yoshi","M"),
                new Driver("Wario","L")
                );
    }

    public static void main(String[] args) {

        TemplateEngine templateEngine = new TemplateEngine();

        FileTemplateResolver templateResolver = new FileTemplateResolver();


        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("name", "Valtech Talent Program");
        context.setVariable("drivers", loadData());

        StringWriter stringWriter = new StringWriter();
        templateEngine.process(TEMPLATE_PATH, context, stringWriter);

        log.info("Résultat : {}", stringWriter.toString());

    }
}
