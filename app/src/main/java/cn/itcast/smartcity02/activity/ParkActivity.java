package cn.itcast.smartcity02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.ParkBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.ParkAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ParkActivity extends AppCompatActivity {
    private List<ParkBean.RowsData> rowsbean;
    private ParkAdapter adapter;
    private RecyclerView mrecyclerview;



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            super.handleMessage(msg);
            if(msg.what == 0){
                ParkBean parkbean = (ParkBean) msg.obj;
                Log.i("parkbean", "handleMessage: "+parkbean.toString());
                rowsbean = parkbean.getRowsdata();
                adapter = new ParkAdapter(ParkActivity.this, rowsbean);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(ParkActivity.this));
                mrecyclerview.setAdapter(adapter);
                adapter.setMyItemClickListener((v, position) -> {
                    Intent intent = null;
                    if (position == 0){
                        intent = new Intent(ParkActivity.this,ParkoneActivity.class);
                    }else if (position == 1) {
                        intent = new Intent(ParkActivity.this,ParkoneActivity.class);
                    } else if (position == 2) {
                        intent = new Intent(ParkActivity.this,ParkoneActivity.class);
                    }else if (position == 3) {
                        intent = new Intent(ParkActivity.this,ParkoneActivity.class);
                    } else if (position == 4) {
                        intent = new Intent(ParkActivity.this,ParkoneActivity.class);
                    }
                    startActivity(intent);

                });
            }
        }
    };

//    List<String> id = new ArrayList<String>();
//                    @Override
//                    public void onItemClick(View v, int position) {
//                        for(position = 0; position < 50; position++) {
//                           String a =  String.valueOf(position);
//                           id.add(a);
//
//                        }
//
//
//                    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        initbanner();

        mrecyclerview = findViewById(R.id.park_park);
        initparklist();

        ImageView guanbi = findViewById(R.id.guanbi_park);
        guanbi.setOnClickListener(v -> startActivity(new Intent(ParkActivity.this,MainActivity.class)));

    }


    //轮播图
    List<String> stringList = new ArrayList<>();
    private Banner banner;
    public void initbanner(){
        banner = findViewById(R.id.banner_park);
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/73143911-6ae6-4423-aab5-545f619dc7ac.jpeg");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/4f2ce448-3051-4c9c-a1b8-d90bb6168fdb.jpeg");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/4f2ce448-3051-4c9c-a1b8-d90bb6168fdb.jpeg");
        banner.setAdapter(new BannerImageAdapter<String>(stringList){

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



    //停车场信息
    public void initparklist() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/park/lot/list")
                .build();

        try {
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result = response.body().string();

                        runOnUiThread(() -> {
                            Gson gson = new Gson();
                            ParkBean bean = gson.fromJson(result, ParkBean.class);
                            Message msg = new Message();
                            msg.what = 0;
                            msg.obj = bean;
                            handler.sendMessage(msg);
                        });
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }
            });
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

}