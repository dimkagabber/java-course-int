package com.tieto.training;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherEndPoint {

    @RequestMapping("/weather")
    public String doGetPerson(@RequestParam String city){
        return "tst";
    }

}
