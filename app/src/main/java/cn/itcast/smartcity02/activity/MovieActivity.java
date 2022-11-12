package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.DaiyingBean;
import cn.itcast.smartcity02.Bean.ReyingBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.DaiyingAdapter;
import cn.itcast.smartcity02.adapter.ReyingAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
//    上
    private List<ReyingBean.RowsBean> rowsBeans;
    private ReyingAdapter adapter;
    private RecyclerView mrecyclerView;


//    下
    private List<DaiyingBean.RowsBean> nrowsBeans;
    private DaiyingAdapter nadapter;
    private RecyclerView nrecyclerView;


//    上
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                ReyingBean rowsbean = (ReyingBean) msg.obj;
                rowsBeans = rowsbean.getRows();
                adapter = new ReyingAdapter(MovieActivity.this, rowsBeans);
                LinearLayoutManager ms = new LinearLayoutManager(MovieActivity.this);
                ms.setOrientation(LinearLayoutManager.HORIZONTAL);
                mrecyclerView.setLayoutManager(ms);
                mrecyclerView.setAdapter(adapter);
                adapter.setmItemClickListener(new ReyingAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        if (position > 0){
                            intent = new Intent(MovieActivity.this,MoviedetialActivity.class);
                        }
                        startActivity(intent);
                    }
                });
            }
        }
    };

//    下
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(msg.what == 0 ){
                DaiyingBean bean = (DaiyingBean) msg.obj;
                nrowsBeans = bean.getRows();
                nadapter = new DaiyingAdapter(MovieActivity.this,nrowsBeans);
                LinearLayoutManager Lm = new LinearLayoutManager(MovieActivity.this);
                Lm.setOrientation(LinearLayoutManager.HORIZONTAL);
                nrecyclerView.setLayoutManager(Lm);
                nrecyclerView.setAdapter(nadapter);
                nadapter.setMyItemClickListener((view, position) -> {
                    Intent intent = null;
                    if (position > 0) {
                        intent = new Intent(MovieActivity.this,MoviedaiyingdetialActivity.class);
                    }
                    startActivity(intent);
                });

            }
        }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initbanner();

        mrecyclerView = findViewById(R.id.reying_movie);
        initReyingview();

        nrecyclerView = findViewById(R.id.daiying_movie);
        initDaiyingview();
    }




    //轮播图
    List<String> stringList = new ArrayList<String>();
    private Banner banner;
    public void initbanner() {
        banner = findViewById(R.id.banner_movie);
        stringList.add(ApiConfig.BASE_API + "/profile/upload/image/2021/05/10/16407a1d-123b-499f-84fb-ca290995b101.png");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/d754c43e-02ee-4697-82d4-2239a54025ef.jpeg");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/3e5edaf4-ef0e-478b-8875-483242d4711a.jpeg");
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

//    上
    private void initReyingview() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/list")
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
                            ReyingBean bean = gson.fromJson(result, ReyingBean.class);
                            Message message = new Message();
                            message.what = 0;
                            message.obj = bean;
                            handler.sendMessage(message);
                        });
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    下

    public void initDaiyingview(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/preview/list")
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
                            DaiyingBean bean = gson.fromJson(result,DaiyingBean.class);
                            Message message = new Message();
                            message.what = 0;
                            message.obj = bean;
                            mHandler.sendMessage(message);
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