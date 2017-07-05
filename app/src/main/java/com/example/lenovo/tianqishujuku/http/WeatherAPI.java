package com.example.lenovo.tianqishujuku.http;

import com.example.lenovo.tianqishujuku.API;
import com.example.lenovo.tianqishujuku.bean.WeatherResultBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2017/6/8.
 */

public interface WeatherAPI {
    @FormUrlEncoded
    @POST(API.WEATHER_RETORFIT)
    Call<WeatherResultBean> getWeather(
            @Field("city") String city
            ,@Field("key") String key);


}
