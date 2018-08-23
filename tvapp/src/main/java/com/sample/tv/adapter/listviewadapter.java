package com.sample.tv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sample.tv.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/17.
 */

public class listviewadapter extends BaseAdapter {
    private Context context;
    ArrayList<String> name=new ArrayList<>();//姓名
    ArrayList<String> reason=new ArrayList<>();//病因
    ArrayList<String> tiaoli=new ArrayList<>();//调理
    public listviewadapter(Context context,ArrayList<String> name, ArrayList<String> reason,ArrayList<String> tiaoli){
         super();
        this.context=context;
        this.name=name;
        this.reason=reason;
        this.tiaoli=tiaoli;
        Log.i("frfrrwewe", "getCount: "+name.size());
    }
    @Override
    public int getCount() {

        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int postion) {
        return postion ;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup viewGroup) {
        ViewHold vh = null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.activity_name,null);
            vh=new ViewHold();
            convertView.setTag(vh);
            vh.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
        }else {
            vh= (ViewHold) convertView.getTag();
        }
        vh.tv_name.setText(name.get(postion));
        return convertView;
    }
    public class ViewHold {
        TextView tv_name;
    }
}
