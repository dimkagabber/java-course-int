package com.tieto.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonSevice personSevice;

    @RequestMapping("/person")
    public ResponseEntity<PersonDTO> doGetPerson(@RequestParam(required = false) String personId){
        if(personId == null) {
            return ResponseEntity.badRequest().build();
        }
        PersonDTO personDTO = PersonDTO.builder().build().map(personSevice.getPerson(personId));
        if(personDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personDTO);

    }
}
