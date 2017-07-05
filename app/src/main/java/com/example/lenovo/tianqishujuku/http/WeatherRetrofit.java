package com.example.lenovo.tianqishujuku.http;

import android.util.Log;

import com.example.lenovo.tianqishujuku.API;
import com.example.lenovo.tianqishujuku.bean.WeatherResultBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/6/8.
 */

public class WeatherRetrofit {

    private static WeatherAPI weatherAPI;
    private static WeatherRetrofit weatherRetrofit;

    public static synchronized WeatherRetrofit createRetrofit() {
        if (weatherRetrofit==null){
            weatherRetrofit=new WeatherRetrofit();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API.ROOT_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            weatherAPI = retrofit.create(WeatherAPI.class);
        }
       return weatherRetrofit;
    }

    public void getWeatherAPI(String city) {
        Call<WeatherResultBean> call = weatherAPI.getWeather(city,API.APP_KEY);

        call.enqueue(new Callback<WeatherResultBean>() {
            @Override
            public void onResponse(Call<WeatherResultBean> call, Response<WeatherResultBean> response) {
                Log.e("onResponse",response.body().toString());
            }

            @Override
            public void onFailure(Call<WeatherResultBean> call, Throwable t) {

            }
        });
    }
}
