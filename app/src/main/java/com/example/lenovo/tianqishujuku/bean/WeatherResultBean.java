package com.example.lenovo.tianqishujuku.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yinm_pc on 2017/4/23.
 */

public class WeatherResultBean {
    private List<HeWeather5> HeWeather5 = new ArrayList<>();

    public List<HeWeather5> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5> heWeather5) {
        HeWeather5 = heWeather5;
    }

    @Override
    public String toString() {
        return "WeatherResultBean{" +
                "list=" + HeWeather5 +
                '}';
    }
}
