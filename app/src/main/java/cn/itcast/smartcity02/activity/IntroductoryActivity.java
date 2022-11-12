package cn.itcast.smartcity02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.IntroductoryAdapter;

public class IntroductoryActivity extends AppCompatActivity {
    private ViewPager mViewPage;
    private List<View> viewList = new ArrayList<View>();
    private Button to_login_btn,to_register_btn,to_getin_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        //初始化
        initView();
        initAdapter();



        to_login_btn = viewList.get(3).findViewById(R.id.goto_login);
        to_register_btn = viewList.get(3).findViewById(R.id.goto_register);
        to_getin_btn = viewList.get(3).findViewById(R.id.getin_main);
        //创建登录监听器
        to_login_btn.setOnClickListener(v -> startActivity(new Intent(IntroductoryActivity.this, login.class)));
        //创建注册监听器
        to_register_btn.setOnClickListener(v -> startActivity(new Intent(IntroductoryActivity.this,RegisterActivity.class)));
        //创建进入主页监听器
        to_getin_btn.setOnClickListener(v -> startActivity(new Intent(IntroductoryActivity.this, MainActivity.class)));
    }


    private void initAdapter() {
        IntroductoryAdapter adapter = new IntroductoryAdapter(viewList);
        mViewPage.setAdapter(adapter);
    }


    private void initView() {
        mViewPage = findViewById(R.id.introductory_viewPager);
        viewList = new ArrayList<>();
        viewList.add(getView(R.layout.introductory1));
        viewList.add(getView(R.layout.introductory2));
        viewList.add(getView(R.layout.introductory3));
        viewList.add(getView(R.layout.introductory4));

    }

    private View getView(int resId) {
        return LayoutInflater.from(this).inflate(resId,null);
    }
}

