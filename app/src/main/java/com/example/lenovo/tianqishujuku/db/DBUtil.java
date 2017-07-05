package com.example.lenovo.tianqishujuku.db;

import android.content.Context;

import com.example.lenovo.tianqishujuku.bean.CityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/1.
 */

public class DBUtil {
    private static DBUtil dbUtil;
    private static String NAME="city.db";
    private static CityBeanDao cbd;
    public static synchronized DBUtil getInstance(Context context){
        if (dbUtil==null){
            dbUtil=new DBUtil();
           dbUtil.init(context);
        }
        return dbUtil;
    }
    public void init(Context context){
        if (cbd==null){
            DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(context,NAME);
            DaoMaster daoMaster=new DaoMaster(devOpenHelper.getWritableDb());
            DaoSession daoSession = daoMaster.newSession();
            cbd = daoSession.getCityBeanDao();
        }
    }
    public void add(CityBean cityBean){

        cbd.insert(cityBean);
    }
    public void addAll(ArrayList<CityBean> cityBean){

        cbd.insertInTx(cityBean);
    }
    public List<CityBean> getAll(){

        return cbd.queryBuilder().limit(5).build().list();
    }
}
