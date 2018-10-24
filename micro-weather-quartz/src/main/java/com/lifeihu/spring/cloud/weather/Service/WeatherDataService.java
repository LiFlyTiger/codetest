package com.lifeihu.spring.cloud.weather.Service;

import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;

/**
 * Created by e-lifeihu on 2018/10/23.
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气信息
     * @param cityID
     * @return
     */
    WeatherResponse getDataByCityId(String cityID);

    /**
     * 根据城市名称查询天气信息
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);


    /**
     * 根据城市ID来同步天气
     * @param cityID
     */
    void syncDateByCityId(String cityID);
}
