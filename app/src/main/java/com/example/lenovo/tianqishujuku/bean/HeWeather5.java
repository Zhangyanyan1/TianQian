package com.example.lenovo.tianqishujuku.bean;

import java.util.List;

/**
 * Created by yinm_pc on 2017/4/23.
 */

public class HeWeather5 {

    private List<Alarms> alarms;
    private Aqi aqi;
    private Basic basic;
    private List<Daily_Forecast> daily_forecast;
    private List<Hourly_Forecast> hourly_forecast;
    private Now now;
    private String status;
    private Suggestion suggestion;

    public List<Alarms> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<Alarms> alarms) {
        this.alarms = alarms;
    }

    public Aqi getAqi() {
        return aqi;
    }

    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public List<Daily_Forecast> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<Daily_Forecast> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<Hourly_Forecast> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<Hourly_Forecast> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}
