package com.example.demo3;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycle;
    private GridView gv;

    private TextView tv_title1;
    private TextView tv_title2;
    private TextView tv_title3;
    private TextView tv_title4;
    private LinearLayout liner;
    private ListView alv;
    private ListView blv;
    private View view1;
    private PopupWindow popupWindow;
    private int po;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initList();

    }

    private void initList() {

        tv_title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(liner);

                tv_title1.setCompoundDrawables(null,null,getRightDrawable(R.drawable.select_triangle_for),null);

            }
        });

    }

    private void initData() {

        List<UserBean> mlist = new ArrayList<>();
        List<UserBean> users = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            users.add(new UserBean("拍婚纱", R.drawable.selller_wedding_img));
            users.add(new UserBean("找策划", R.drawable.seller_weddingplan_img));
            users.add(new UserBean("选婚纱", R.drawable.seller_dress_img));
            users.add(new UserBean("找主持", R.drawable.seller_compere_img));
            users.add(new UserBean("找摄影", R.drawable.seller_camera_img));
            users.add(new UserBean("找摄像", R.drawable.seller_video_img));
            users.add(new UserBean("找跟妆", R.drawable.seller_makeup_img));

            users.add(new UserBean("找场合 ", R.drawable.seller_cake_img));
        }
        for (int i = 0; i < 20; i++) {
            mlist.add(new UserBean("测试" + i, 0));
        }


        gv.setAdapter(new MyGrAdapter(users, MainActivity.this));
        recycle.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recycle.setAdapter(new MyAdapter(mlist, MainActivity.this));


        final List<String> mStrings = new ArrayList<>();
        mStrings.add("拍婚照");
        mStrings.add("找策划");

        mStrings.add("选婚纱");
        mStrings.add("找主持");

        mStrings.add("找摄影");
        mStrings.add("找摄像");
        mStrings.add("找跟桩");

        mStrings.add("花艺甜品");
        mStrings.add("找场地");


        final List<List<String>> mStrs = new ArrayList<>();

        List<String> pai = new ArrayList<>();
        pai.add("全部");
        pai.add("婚纱摄影工作室");
        pai.add("婚纱摄影公司");
        mStrs.add(pai);

        List<String> zhao = new ArrayList<>();
        zhao.add("全部");
        zhao.add("策划师");
        zhao.add("策划工作室");
        zhao.add("策划公司");
        mStrs.add(zhao);

        List<String> xuan = new ArrayList<>();
        xuan.add("全部");
        xuan.add("婚纱礼服工作室");
        xuan.add("婚纱礼服公司");
        mStrs.add(xuan);


        List<String> zhuchi = new ArrayList<>();
        zhuchi.add("全部");
        zhuchi.add("主持人");
        zhuchi.add("主持工作室");
        mStrs.add(zhuchi);

        List<String> sheying = new ArrayList<>();
        sheying.add("全部");
        sheying.add("摄影师");
        sheying.add("摄影工作室");
        mStrs.add(sheying);

        List<String> shexiang = new ArrayList<>();
        shexiang.add("全部");
        shexiang.add("摄像师");
        shexiang.add("摄像工作室");
        mStrs.add(shexiang);

        List<String> genzhuang = new ArrayList<>();
        genzhuang.add("全部");
        genzhuang.add("化妆师");
        genzhuang.add("化妆工作室");
        mStrs.add(genzhuang);





        List<String> huayi = new ArrayList<>();
        huayi.add("全部");
        huayi.add("花艺师");
        huayi.add("花艺工坊");
        huayi.add("甜品师");
        huayi.add("甜品工坊");
        mStrs.add(huayi);

        List<String>changdi= new ArrayList<>();

        changdi.add("全部");
        changdi.add("星级酒店");
        changdi.add("特色餐厅");
        changdi.add("婚礼会馆");
        changdi.add("特色场地");
        mStrs.add(changdi);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mStrs.get(0));
        blv.setAdapter(adapter);

        alv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));
        alv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                po = i;
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mStrs.get(i));
                blv.setAdapter(adapter);

            }
        });

        blv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_title1.setText(mStrs.get(po).get(i));

                popupWindow.dismiss();

            }
        });





    }
    private void initView() {
        recycle = (RecyclerView) findViewById(R.id.recycle);
        gv = (GridView) findViewById(R.id.gv);
        tv_title1 = (TextView) findViewById(R.id.tv_title1);
        tv_title2 = (TextView) findViewById(R.id.tv_title2);
        tv_title3 = (TextView) findViewById(R.id.tv_title3);
        tv_title4 = (TextView) findViewById(R.id.tv_title4);
        liner = (LinearLayout) findViewById(R.id.liner);
        view1 = LayoutInflater.from(this).inflate(R.layout.item_popu, null);
        alv = view1.findViewById(R.id.alv);
        blv = view1.findViewById(R.id.blv);

        popupWindow = new PopupWindow(view1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        popupWindow.setHeight(Math.round(heightPixels * 0.4f));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);






    }

    public Drawable getRightDrawable(int mipmap) {
        Drawable drawable = getResources().getDrawable(mipmap);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

}
