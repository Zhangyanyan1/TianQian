package com.example.lenovo.tianqishujuku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.tianqishujuku.R;
import com.example.lenovo.tianqishujuku.bean.CityBean;

import java.util.ArrayList;

/**
 * Created by yinm_pc on 2017/4/23.
 */

public class CityListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CityBean> list;

    public CityListAdapter(Context context, ArrayList<CityBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CityBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_city_list, parent, false);
            holder = new ViewHolder();
            holder.setView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(getItem(position).getCityZh());
        return convertView;
    }

    private class ViewHolder {
        private TextView textView;

        private void setView(View itemView) {
            textView = (TextView) itemView.findViewById(R.id.item_city_name);
        }
    }
}
