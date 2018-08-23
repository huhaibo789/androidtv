package com.sample.tv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sample.tv.R;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/7/17.
 */

public class Hormyadapter extends BaseAdapter {
    private Context context;
    private  int[] image;
    int i,count;
    ViewHold vh = null;
    private  boolean flag=true;
    private View v_img;
    //定义hashMap 用来存放之前创建的每一项item
    HashMap<Integer, View> lmap = new HashMap<Integer, View>();
    public  Hormyadapter(Context context,int image[],int i,int count){
        super();
        this.context=context;
        this.image=image;
        this.i=i;
        this.count=count;

        if(count!=1){
            Log.i("frsrsereees1", "Hormyadapter: "+count);
          //  notifyDataSetChanged();

        }
        Log.i("frsrsereees", "Hormyadapter: "+i+count);

    }
   public  void  staic(int i,int count){
       this.i=i;
       this.count=count;
       Log.i("frsrsereees3", "Hormyadapter: "+i+count);
   }


    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Log.i("xuemao", "getView: "+"来了");
          /* if(convertView==null){
               convertView=View.inflate(context, R.layout.activity_normalalldingdan,null);
               vh=new ViewHold();
               convertView.setTag(vh);
               vh.linear_buju= (LinearLayout) convertView.findViewById(R.id.linear_buju);
           }else {
               vh= (ViewHold) convertView.getTag();
           }*/
        if (lmap.get(position) == null) {
            // convertView=View.inflate(context, R.layout.activity_normalalldingdan,null);
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_horimage, null);
            vh = new ViewHold();
            convertView.setTag(vh);
            lmap.put(position, convertView);
            vh.hor_linear = (LinearLayout) convertView.findViewById(R.id.hor_linear);
            flag = true;
        } else {
            convertView = lmap.get(position);
            vh = (ViewHold) convertView.getTag();
            flag = false;
        }
        Log.i("ferdewwe", "getView: "+flag);

            v_img = LayoutInflater.from(context).inflate(R.layout.activity_img, null);
            ImageView appointyuyue_bianhao = (ImageView) v_img.findViewById(R.id.hor_img);
           Log.i("ferdewwe1", "getView: "+i);
            appointyuyue_bianhao.setImageResource(image[i]);
            vh.hor_linear.addView(v_img);

        return convertView;
    }
    public class ViewHold {
        LinearLayout hor_linear;
    }

}
