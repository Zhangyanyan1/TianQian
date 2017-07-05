package com.example.lenovo.tianqishujuku.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yinm_pc on 2017/4/23.
 * 城市代码 实体类
 */
@Entity
public class CityBean {
    @Id
    private String id;
    @Property(nameInDb="cityEn")
    private String cityEn;
    @Property(nameInDb="cityZh")
    private String cityZh;
    @Property(nameInDb="countryCode")
    private String countryCode;
    @Property(nameInDb="countryEn")
    private String countryEn;
    @Property(nameInDb="countryZh")
    private String countryZh;
    @Property(nameInDb="provinceEn")
    private String provinceEn;
    @Property(nameInDb="provinceZh")
    private String provinceZh;
    @Property(nameInDb="leaderEn")
    private String leaderEn;
    @Property(nameInDb="leaderZh")
    private String leaderZh;
    @Property(nameInDb="lat")
    private String lat;
    @Property(nameInDb="lon")
    private String lon;

    @Generated(hash = 397060836)
    public CityBean(String id, String cityEn, String cityZh, String countryCode,
            String countryEn, String countryZh, String provinceEn,
            String provinceZh, String leaderEn, String leaderZh, String lat,
            String lon) {
        this.id = id;
        this.cityEn = cityEn;
        this.cityZh = cityZh;
        this.countryCode = countryCode;
        this.countryEn = countryEn;
        this.countryZh = countryZh;
        this.provinceEn = provinceEn;
        this.provinceZh = provinceZh;
        this.leaderEn = leaderEn;
        this.leaderZh = leaderZh;
        this.lat = lat;
        this.lon = lon;
    }

    @Generated(hash = 273649691)
    public CityBean() {
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "id='" + id + '\'' +
                ", cityEn='" + cityEn + '\'' +
                ", cityZh='" + cityZh + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryEn='" + countryEn + '\'' +
                ", countryZh='" + countryZh + '\'' +
                ", provinceEn='" + provinceEn + '\'' +
                ", provinceZh='" + provinceZh + '\'' +
                ", leaderEn='" + leaderEn + '\'' +
                ", leaderZh='" + leaderZh + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCityZh() {
        return cityZh;
    }

    public void setCityZh(String cityZh) {
        this.cityZh = cityZh;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getCountryZh() {
        return countryZh;
    }

    public void setCountryZh(String countryZh) {
        this.countryZh = countryZh;
    }

    public String getProvinceEn() {
        return provinceEn;
    }

    public void setProvinceEn(String provinceEn) {
        this.provinceEn = provinceEn;
    }

    public String getProvinceZh() {
        return provinceZh;
    }

    public void setProvinceZh(String provinceZh) {
        this.provinceZh = provinceZh;
    }

    public String getLeaderEn() {
        return leaderEn;
    }

    public void setLeaderEn(String leaderEn) {
        this.leaderEn = leaderEn;
    }

    public String getLeaderZh() {
        return leaderZh;
    }

    public void setLeaderZh(String leaderZh) {
        this.leaderZh = leaderZh;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
