package com.sample.tv.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sample.tv.R;
import com.sample.tv.adapter.Hormyadapter;
import com.sample.tv.adapter.Myadapter;
import com.sample.tv.adapter.listviewadapter;
import com.sample.tv.model.ContactProvider;
import com.sample.tv.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link DialPanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialPanFragment extends Fragment implements View.OnClickListener {

    private TextView show_details;
    private ListView listview;
    private GridView gridview,gridview_hor;
    public Myadapter adapter;
    public Hormyadapter horadapter;
    public listviewadapter listadapter;
    int[] image={R.drawable.avater1,R.drawable.avater2,R.drawable.avater3,R.drawable.avater4,R.drawable.avater5,R.drawable.avater6,R.drawable.avater7,R.drawable.avater8};
    ArrayList<String> name=new ArrayList<>();//姓名
    ArrayList<String> reason=new ArrayList<>();//病因
    ArrayList<String> tiaoli=new ArrayList<>();//调理
    int count=1;
     public DialPanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DialFragment.
     */
    public static DialPanFragment newInstance() {
        DialPanFragment fragment = new DialPanFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dial_pan, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
        findViews();
        setadapter();

    }

    private void initdata() {
        name.add("储兵兵");
        name.add("张三");
        name.add("李四");
        name.add("王五");
        name.add("王五");
        name.add("陈有");
        name.add("肖飞");
        name.add("顾局");
        name.add("孙涛");
        name.add("赵春生");
        reason.add("肠胃功能紊乱");
        reason.add("咳嗽");
        reason.add("拉肚子");
        reason.add("打喷嚏");
        reason.add("鼻塞");
        reason.add("流鼻涕");
        reason.add("牙龈痛");
        reason.add("腿酸");
        reason.add("黑眼圈");
        reason.add("视力疲劳");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
        tiaoli.add("多喝水");
    }

    private void setadapter() {
        adapter=new Myadapter(getActivity(),image);
        gridview.setAdapter(adapter);
        listadapter=new listviewadapter(getActivity(),name,reason,tiaoli);
        listview.setAdapter(listadapter);
        setlistener();
    }

    private void setlistener() {
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("fdfdfre", "onItemClick: "+i);

                if(count==1){
                    horadapter=new Hormyadapter(getActivity(),image,i,count);
                    gridview_hor.setAdapter(horadapter);
                    count++;
                }else {

                    int[] image={R.drawable.avater1,R.drawable.avater2,R.drawable.avater3,R.drawable.avater4,R.drawable.avater5,R.drawable.avater6,R.drawable.avater7,R.drawable.avater8};
                    Log.i("fdrbe", "onItemClick: "+"fkfdir");
                    horadapter.staic(i,count);
                    horadapter.notifyDataSetChanged();

                    count++;

                }

            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("fmsdsf", "onItemClick: "+i);
                show_details.setText(" 姓名: "+name.get(i)+","+" 病因: "+reason.get(i)+","+" 调理: "+tiaoli.get(i));
            }
        });
    }

    private void findViews() {
        show_details = (TextView) getView().findViewById(R.id.show_details);
        listview = (ListView) getView().findViewById(R.id.listview);
        gridview=(GridView) getView().findViewById(R.id.gridview);
        gridview_hor=(GridView) getView().findViewById(R.id.gridview_hor);
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {

    }


}
