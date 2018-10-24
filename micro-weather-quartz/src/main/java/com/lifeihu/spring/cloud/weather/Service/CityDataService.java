package com.lifeihu.spring.cloud.weather.Service;

import com.lifeihu.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
public interface CityDataService {

    //获取城市的列表
    List<City> listCity() throws Exception;
}
