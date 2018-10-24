package com.lifeihu.spring.cloud.weather.controller;

import com.lifeihu.spring.cloud.weather.Service.CityDataService;
import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.Service.WeatherReprotService;
import com.lifeihu.spring.cloud.weather.vo.Weather;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by e-lifeihu on 2018/10/22.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReprotService weatherReprotService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportDataByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        Weather weather = weatherReprotService.getDataByCityId(cityId);
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.listCity());
        model.addAttribute("report",weatherReprotService.getDataByCityId(cityId));
        return  new ModelAndView("weather/report","reportModel",model);

    }

}
