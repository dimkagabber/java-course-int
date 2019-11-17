package com.tieto.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private PersonSevice personSevice;

    @RequestMapping("/hello")
    public StringBuilder doGetHello(@RequestParam(required = false) String personId){
        StringBuilder sb = new StringBuilder();
        String infoString = personSevice.getPerson(personId).getFirstName();
        if(infoString == null) {
            infoString = "";
        }
       sb.append("<h2 style=\"color: rgba(252, 156, 249, 1);\">")
        .append("Hello ")
        .append(infoString)
       .append("</h2>");
        return sb;
    }
}
