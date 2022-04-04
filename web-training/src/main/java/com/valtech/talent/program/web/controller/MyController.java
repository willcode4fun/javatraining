package com.valtech.talent.program.web.controller;

import com.valtech.talent.program.web.model.TrainingObject;
import com.valtech.talent.program.ws.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("basepath")
public class MyController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping("test/{entier}")
    public TrainingObject test (@PathVariable("entier") String integerAsString){

        Integer entier = checkInteger(integerAsString);
        String converted = conversionService.convert(entier);

        return new TrainingObject(entier, converted);
    }

    private Integer checkInteger(String integerAsString) {
        try{
            return Integer.valueOf(integerAsString);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id parameter is not an integer");
        }
    }

}
