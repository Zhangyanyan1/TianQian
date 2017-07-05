package com.example.lenovo.tianqishujuku.bean;

/**
 * Created by yinm_pc on 2017/4/23.
 */

public class City {
    private String aqi;
//    private String co;
//    private String no2;
//    private String o3;
    private String pm10;
    private String pm25;
    private String qlty;
//    private String so2;

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }


    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getQlty() {
        return qlty;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
    }

}
