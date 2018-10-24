package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.utils.StringUtils;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;

/**
 * Created by e-lifeihu on 2018/10/23.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    //利用HttpClient获取天气信息
    @Autowired

    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityID) {
        String uri= WEATHER_URI + "citykey=" +  cityID;
        WeatherResponse resp = doGetWeatherData(uri);
        return resp;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri= WEATHER_URI + "city=" +  cityName;
        WeatherResponse resp = doGetWeatherData(uri);
        return resp;
    }

    /**
     * 获取天气信息方法
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeatherData(String uri) {

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        String strBody = null;

        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;

        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }


    /*private WeatherResponse doGetWeatherData(String uri) {

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String strBody = null;

        if (response.getStatusCodeValue() == 200) {
            try {
                strBody = StringUtils.conventFromGzip(response.getBody());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;

        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }*/

}
