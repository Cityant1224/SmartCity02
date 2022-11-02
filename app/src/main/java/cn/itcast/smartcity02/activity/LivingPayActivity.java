package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class LivingPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_pay);

        TextView tianqi = findViewById(R.id.tianqi);
        tianqi.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,TianqiActivity.class)));
        ImageView guanbi = findViewById(R.id.guanbi_live);
        guanbi.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,ServiceActivity.class)));
        LinearLayout dianhuafei = findViewById(R.id.dianhuafei);
//        dianhuafei.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,DianhuafeiActivity.class)));
        dianhuafei.setOnClickListener(v -> {
            Toast.makeText(this, "暂未开放", Toast.LENGTH_SHORT).show();
        });

        LinearLayout shuifei = findViewById(R.id.shuifei);
        shuifei.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,ShuifeiActivity.class)));
        LinearLayout dianfei = findViewById(R.id.dianfei);
        dianfei.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,DianfeiActivity.class)));
        LinearLayout ranqifei = findViewById(R.id.ranqifei);
        ranqifei.setOnClickListener(v -> startActivity(new Intent(LivingPayActivity.this,RanqifeiActivity.class)));

        initbanner();
    }

    List<String> stringlist = new ArrayList<String>();
    private Banner banner;
    public void initbanner() {
        banner = findViewById(R.id.banner_live);
        stringlist.add(ApiConfig.BASE_API + "/profile/upload/image/2021/05/12/4aa010a5-2787-4aeb-aecb-6032d0d327cb.jpg");
        stringlist.add(ApiConfig.BASE_API + "prod-api/profile/upload/image/2021/05/12/4a980d40-a1e7-4eab-84f8-c4a3eb873bee.jpg");
        stringlist.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/12/c81fdbd5-3257-4f98-83eb-9c4bdfbd044a.jpg");
        banner.setAdapter(new BannerImageAdapter<String>(stringlist) {
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