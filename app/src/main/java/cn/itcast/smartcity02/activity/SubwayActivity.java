package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.Subway_lineBean;
import cn.itcast.smartcity02.ChengchekaActivity;
import cn.itcast.smartcity02.DitiegonggaoActivity;
import cn.itcast.smartcity02.DiyigeActivity;
import cn.itcast.smartcity02.GrainchengchekaActivity;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.ShiwuzhaolingActivity;
import cn.itcast.smartcity02.adapter.Subway_lineAdapter;

public class SubwayActivity extends AppCompatActivity {

    public List[] ka = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        //findViewById线路
        LinearLayout diyige = (LinearLayout) findViewById(R.id.diyige);
//        LinearLayout dierge = findViewById(R.id.dierge);
//        LinearLayout disange = findViewById(R.id.disange);
//        LinearLayout disige = findViewById(R.id.disige);

        //第一个点击事件
       diyige.setOnClickListener(v -> startActivity(new Intent(SubwayActivity.this,DiyigeActivity.class)));
//        dierge.setOnClickListener(v ->new Intent(SubwayActivity.this,DiergeActivity.class));
//        disange.setOnClickListener(v ->new Intent(SubwayActivity.this,DisangeActivity.class));
//        disige.setOnClickListener(v ->new Intent(SubwayActivity.this,DisigeActivity.class));


        //findviewbyid 乘车卡，失物招领，地铁公告
        LinearLayout chengcheka = findViewById(R.id.chengcheka);
        LinearLayout shiwuzhaoling = findViewById(R.id.shiwuzhaoling);
        LinearLayout ditiegonggao = findViewById(R.id.ditiegonggao);

        //乘车卡点击事件
        chengcheka.setOnClickListener(v -> startActivity(new Intent(SubwayActivity.this, GrainchengchekaActivity.class)));
        //失物招领点击事件
        shiwuzhaoling.setOnClickListener(v -> startActivity(new Intent(SubwayActivity.this, ShiwuzhaolingActivity.class)));
        //地铁公告点击事件
        ditiegonggao.setOnClickListener(v -> startActivity(new Intent(SubwayActivity.this, DitiegonggaoActivity.class)));

        //初始化轮播图
        initbanner();
    }

    //轮播图
    List<String> stringList = new ArrayList<String>();
    private Banner banner;
    public void initbanner(){
        banner = findViewById(R.id.banner_subway);
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/12/4a0fd4e7-2e01-420c-b89b-e39108d2f191.jpg");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/12/aaa2ac1e-94da-4d0f-8077-8b1affa8c932.png");
        banner.setAdapter(new BannerImageAdapter<String>(stringList) {

            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                Glide.with(holder.itemView)
                        .load(data)
                        .into(holder.imageView);
            }
        })
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this))
                .start();
    }
}