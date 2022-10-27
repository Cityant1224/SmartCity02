package cn.itcast.smartcity02.activity;

import android.content.Intent;
import android.os.Bundle;
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
    private Button to_login_btn,to_getin_btn;
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introductory4);
        //初始化
        initView();
        initAdapter();
        initStart();
    }
    /**
     * 设置第4个引导页的 button 点击事件
     */
    private void initStart() {
          to_login_btn = viewList.get(3).findViewById(R.id.goto_login);
          to_getin_btn = findViewById(R.id.getin_main);
          //创建登录监听器
          to_login_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(IntroductoryActivity.this, login.class));
              }
          });

          //创建进入主页监听器
          to_getin_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(IntroductoryActivity.this, MainActivity.class));
              }
          });
    }

    /**
     * 适配器
     */
    private void initAdapter() {
        IntroductoryAdapter adapter = new IntroductoryAdapter(viewList);
        mViewPage.setAdapter(adapter);
    }

    /**
     * viewPager和4个引导
     */
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

