package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.Service.WeatherReprotService;
import com.lifeihu.spring.cloud.weather.vo.Weather;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
@Service
public class WeatherReprotServiceImpl implements WeatherReprotService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse data = weatherDataService.getDataByCityId(cityId);
        if(data != null ){
            return data.getData();
        }
        return null;
    }
}
