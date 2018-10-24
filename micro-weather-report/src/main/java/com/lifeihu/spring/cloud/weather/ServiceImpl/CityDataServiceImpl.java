package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.lifeihu.spring.cloud.weather.Service.CityDataService;
import com.lifeihu.spring.cloud.weather.utils.XmlBuilder;
import com.lifeihu.spring.cloud.weather.vo.City;
import com.lifeihu.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取问件
        Resource resource = new ClassPathResource("static\\citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }

        br.close();
        //转化对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
        return cityList.getCityList();

    }
}
