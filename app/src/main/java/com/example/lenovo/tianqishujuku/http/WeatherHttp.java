package com.example.lenovo.tianqishujuku.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.tianqishujuku.API;
import com.example.lenovo.tianqishujuku.bean.CityBean;
import com.example.lenovo.tianqishujuku.bean.WeatherResultBean;
import com.example.lenovo.tianqishujuku.callback.HttpCallBack;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yinm_pc on 2017/4/23.
 */

public class WeatherHttp {
    private static RequestQueue request;
    private static WeatherHttp weatherHttp;
    private Gson gson = new Gson();

    public static WeatherHttp getInstance(Context context) {
        if (weatherHttp == null) {
            weatherHttp = new WeatherHttp();
            //获得请求队列
            request = Volley.newRequestQueue(context);
        }
        return weatherHttp;
    }

    /**
     * 获得城市列表 接口
     */
    public void getCity(final HttpCallBack httpCallBack) {
        //应答监听
        Response.Listener<String> response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<ArrayList<CityBean>>() {
                }.getType();
                ArrayList<CityBean> userList = gson.fromJson(response, listType);

                for (CityBean c :
                        userList) {
                    Log.e("onResponse", c.toString());
                }
                httpCallBack.ok(userList);
            }
        };
        //错误监听
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.getMessage(), error);
                httpCallBack.err("请求错误");
            }
        };

        //字符串请求 返回结果为String类型数据
        StringRequest stringRequest = new StringRequest(
                API.CITY_API//请求地址
                , response//应答监听 当接收到服务器应答后 回调此监听中的onResponse方法
                , error);//错误监听 当请求失败时 回调此监听中的onErrorResponse 方法

        //将请求对象添加到请求队列中
        request.add(stringRequest);

    }


    public void getWeather(final String city,final HttpCallBack httpCallBack) {
        //应答监听
        Response.Listener<String> response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("onResponse", response);
                WeatherResultBean status = gson.fromJson(response, WeatherResultBean.class);

                status.toString();
                ArrayList<WeatherResultBean> list = new ArrayList<>();
                list.add(status);
                httpCallBack.ok(list);
            }
        };
        //错误监听
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.getMessage(), error);
                httpCallBack.err("请求错误");
            }
        };
        //字符串请求 返回结果为String类型数据
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST
                , API.WEATHER//请求地址
                , response//应答监听 当接收到服务器应答后 回调此监听中的onResponse方法
                , error) {
            //重写getParams 在此方法中返回 请求参数
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("key", API.APP_KEY);//参数名 和 参数值
                map.put("city", city);//参数名 和 参数值
                return map;
            }
        };//错误监听 当请求失败时 回调此监听中的onErrorResponse 方法

        //将请求对象添加到请求队列中
        request.add(stringRequest);
    }

}
