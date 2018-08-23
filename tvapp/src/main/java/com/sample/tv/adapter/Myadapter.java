package com.sample.tv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/7/17.
 */

public class Myadapter extends BaseAdapter {
    private Context context;
    private  int image[];
    public  Myadapter(Context context,int image[]){
        super();
        this.context=context;
        this.image=image;
    }
    @Override
    public int getCount() {
        return image.length;
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
    public View getView(int postion, View view, ViewGroup viewGroup) {
        ImageView imageview=new ImageView(context);
        int img_id=image[postion];
        imageview.setLayoutParams(new GridView.LayoutParams(300,300));
        imageview.setImageResource(img_id);
        return imageview;
    }
}
