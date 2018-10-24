package com.lifeihu.spring.cloud.weather.controller;

import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by e-lifeihu on 2018/10/22.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;



    //@RequestMapping(value = "/cityId/{cityId}",method = RequestMethod.GET)
    //@ResponseBody
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId){
        WeatherResponse dataByCity = weatherDataService.getDataByCityId(cityId);
        return dataByCity;
    }


    //@RequestMapping(value = "/city/{cityName}",method = RequestMethod.GET)
    //@ResponseBody
    @GetMapping("/city/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName){
        WeatherResponse dataByCity = weatherDataService.getDataByCityName(cityName);
        return dataByCity;
    }
}
