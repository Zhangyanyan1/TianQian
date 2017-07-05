package com.example.lenovo.tianqishujuku.act;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.tianqishujuku.R;
import com.example.lenovo.tianqishujuku.adapter.CityListAdapter;
import com.example.lenovo.tianqishujuku.bean.Aqi;
import com.example.lenovo.tianqishujuku.bean.CityBean;
import com.example.lenovo.tianqishujuku.bean.Daily_Forecast;
import com.example.lenovo.tianqishujuku.bean.HeWeather5;
import com.example.lenovo.tianqishujuku.bean.Now;
import com.example.lenovo.tianqishujuku.bean.Suggestion;
import com.example.lenovo.tianqishujuku.bean.WeatherResultBean;
import com.example.lenovo.tianqishujuku.callback.HttpCallBack;
import com.example.lenovo.tianqishujuku.db.DBUtil;
import com.example.lenovo.tianqishujuku.http.WeatherHttp;
import com.example.lenovo.tianqishujuku.http.WeatherRetrofit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayList<CityBean> cityList = new ArrayList<>();
    private CityListAdapter cityAdapter;
    private DrawerLayout drawerLayout;

    private WeatherResultBean weatherResultBean = new WeatherResultBean();
    private android.support.v7.app.ActionBar actionBar;

    private TextView tem, cond, tmp_max_min, wind, drsg, drsg_brf, comf, comf_brf, sport, sport_brf, cw, cw_brf, qity, today_tmp, today_cond, today_qlty, tomorrow_tmp, tomorrow_cond, tomorrow_qlty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        WeatherRetrofit.createRetrofit().getWeatherAPI("上海");


        actionBar=getSupportActionBar();
//        cityList=DBUtil.getDbUtil(this).getCityAll();

        cityList.addAll(DBUtil.getInstance(this).getAll());

        if (cityList.size()<1){
           getCityData();
        }else {
            notifyCity();
        }
    }
    private void setActionBarTitle(CityBean cityBean) {
        actionBar.setTitle(cityBean.getCityZh());
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(listView)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(listView);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        listView = (ListView) findViewById(R.id.show_list_city);

        cityAdapter = new CityListAdapter(this, cityList);

        listView.setAdapter(cityAdapter);
        listView.setOnItemClickListener(this);

        tem = (TextView) findViewById(R.id.show_tem_text);
        cond = (TextView) findViewById(R.id.show_cond_text);
        tmp_max_min = (TextView) findViewById(R.id.show_tmp_min_max_text);
        wind = (TextView) findViewById(R.id.show_wind_text);
        qity = (TextView) findViewById(R.id.show_qity_text);

        drsg = (TextView) findViewById(R.id.show_drsg_text);
        drsg_brf = (TextView) findViewById(R.id.show_drsg_brf_text);

        comf = (TextView) findViewById(R.id.show_comf_text);
        comf_brf = (TextView) findViewById(R.id.show_comf_brf_text);

        sport = (TextView) findViewById(R.id.show_sport_text);
        sport_brf = (TextView) findViewById(R.id.show_sport_brf_text);

        cw = (TextView) findViewById(R.id.show_cw_text);
        cw_brf = (TextView) findViewById(R.id.show_cw_brf_text);

        today_tmp = (TextView) findViewById(R.id.show_today_tmp);
        today_cond = (TextView) findViewById(R.id.show_today_cond);
        today_qlty = (TextView) findViewById(R.id.show_today_qlty);

        tomorrow_tmp = (TextView) findViewById(R.id.show_tomorrow_tmp);
        tomorrow_cond = (TextView) findViewById(R.id.show_tomorrow_cond);
        tomorrow_qlty = (TextView) findViewById(R.id.show_tomorrow_qlty);
    }

    private void setView(WeatherResultBean weatherResultBean) {
        List<HeWeather5> lists=weatherResultBean.getHeWeather5();
//        List<HeWeather5> lists = weatherResultBean.getHeWeather5();
        HeWeather5 bean = lists.get(0);
        Aqi aqi = bean.getAqi();
        List<Daily_Forecast> dates = bean.getDaily_forecast();
        Daily_Forecast today = dates.get(0);
        Daily_Forecast tomorrow = dates.get(1);
        Now now = bean.getNow();
        Suggestion suggestion = bean.getSuggestion();
        tem.setText(now.getTmp());
        cond.setText(now.getCond().getTxt());
        tmp_max_min.setText(today.getTmp().getMin() + "/" + today.getTmp().getMax() + "℃   ");
        wind.setText(now.getWind().getDir() + "  " + now.getWind().getSc() + "级    风力" + now.getWind().getSpd());

        qity.setText(aqi.getCity().getQlty());

        drsg.setText(suggestion.getDrsg().getTxt());
        drsg_brf.setText(suggestion.getDrsg().getBrf());

        comf.setText(suggestion.getComf().getTxt());
        comf_brf.setText(suggestion.getComf().getBrf());

        sport.setText(suggestion.getSport().getTxt());
        sport_brf.setText(suggestion.getSport().getBrf());

        cw.setText(suggestion.getCw().getTxt());
        cw_brf.setText(suggestion.getCw().getBrf());

//        today_qlty.setText(today.getCond().getTxt_d());
        today_tmp.setText(today.getTmp().getMin() + "/" + today.getTmp().getMax() + "℃");
        today_cond.setText(today.getCond().getTxt_d());

        //        tomorrow_qlty.setText(tomorrow.getCond().getTxt_d());
        tomorrow_tmp.setText(tomorrow.getTmp().getMin() + "/" + tomorrow.getTmp().getMax() + "℃");
        tomorrow_cond.setText(tomorrow.getCond().getTxt_d());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        CityBean cityBean = cityList.get(position);
        Log.e("onItemClick", cityBean.toString());
        drawerLayout.closeDrawers();
        setActionBarTitle(cityBean);
        getWeather(cityBean);
    }

    private void getWeather(CityBean cityBean) {
        WeatherHttp.getInstance(this).getWeather(cityBean.getCityZh(), new HttpCallBack() {
            @Override
            public ArrayList ok(ArrayList list) {
                weatherResultBean = (WeatherResultBean) list.get(0);
                setView(weatherResultBean);
                return null;
            }

            @Override
            public void no(String noStr) {

            }

            @Override
            public void err(String str) {

            }
        });
    }

    private void getCityData() {
        WeatherHttp.getInstance(this).getCity(new HttpCallBack() {
            @Override
            public ArrayList ok(ArrayList list) {
                cityList.addAll(list);
                notifyCity();

                DBUtil.getInstance(getApplicationContext()).addAll(cityList);

                return null;
            }

            @Override
            public void no(String noStr) {

            }

            @Override
            public void err(String str) {

            }
        });
    }

    private void notifyCity() {
        cityAdapter.notifyDataSetChanged();
        CityBean cityBean = cityList.get(0);
        setActionBarTitle(cityBean);
        getWeather(cityBean);
    }
}
