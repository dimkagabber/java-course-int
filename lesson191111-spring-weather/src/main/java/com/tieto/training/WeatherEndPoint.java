package com.tieto.training;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherEndPoint {

    @RequestMapping("/weather")
    public String getWeather(@RequestParam String city){
        return city + " is having a great day";
    }

}
