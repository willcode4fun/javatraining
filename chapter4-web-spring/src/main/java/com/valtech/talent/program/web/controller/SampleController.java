package com.valtech.talent.program.web.controller;

import com.valtech.talent.program.web.model.SampleGreeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@RestController
@RequestMapping("samplegreeting")
public class SampleController {

    @GetMapping("{id}")
    public SampleGreeting read(@PathVariable String id) {

        if(id ==  null || id.trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id parameter is empty");
        }

        return new SampleGreeting("Hello", id);
    }

    @RequestMapping(path = "/sample", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> saveEmployee(@RequestParam String name, @RequestPart MultipartFile document) {
        SampleGreeting sample = new SampleGreeting(name, document.getOriginalFilename());
        return ResponseEntity.ok().build();
    }
}
