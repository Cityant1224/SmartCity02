package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;

import cn.itcast.smartcity02.Bean.MovieDaiyingDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.MovieDaiyingDetialAdapter;
import cn.itcast.smartcity02.adapter.MovieDaiyingOtherDetialAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MoviedaiyingdetialActivity extends AppCompatActivity {

    //    上
    private MovieDaiyingDetialBean.DataBean dataBeans;
    private MovieDaiyingDetialAdapter adapter;
    private RecyclerView mrecyclerview;
    //    上
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MovieDaiyingDetialBean databean = (MovieDaiyingDetialBean) msg.obj;
                dataBeans = databean.getData();
                adapter = new MovieDaiyingDetialAdapter(MoviedaiyingdetialActivity.this, dataBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(MoviedaiyingdetialActivity.this));
                mrecyclerview.setAdapter(adapter);
            }
        }
    };
    //    下
    private MovieDaiyingDetialBean.DataBean ndataBeans;
    private MovieDaiyingOtherDetialAdapter nadapter;
    private RecyclerView nrecyclerview;
    @SuppressLint("HandlerLeak")
    private final Handler handler2 = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MovieDaiyingDetialBean databean = (MovieDaiyingDetialBean) msg.obj;
                ndataBeans = databean.getData();
                nadapter = new MovieDaiyingOtherDetialAdapter(MoviedaiyingdetialActivity.this, ndataBeans);
                nrecyclerview.setLayoutManager(new LinearLayoutManager(MoviedaiyingdetialActivity.this));
                nrecyclerview.setAdapter(nadapter);
            }
        }
    };

//下


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedaiyingdetial);
        //上
        mrecyclerview = findViewById(R.id.moviedaiyingdetial_item);
        initmoviedetial();

//        下
        nrecyclerview = findViewById(R.id.moviedaiyingotherdetial_item);
        initotherdaiyingdetialview();

        ImageView fanhui = findViewById(R.id.fanhui_moviedaiyingdetial);
        Button xiangkan = findViewById(R.id.xiangkandaiying_btn_moviedaiyingdetial);
        Button kanguo = findViewById(R.id.kanguodaiying_btn_moviedaiyingdetial);

        fanhui.setOnClickListener(v -> startActivity(new Intent(MoviedaiyingdetialActivity.this, MovieActivity.class)));
        xiangkan.setOnClickListener(v -> Toast.makeText(MoviedaiyingdetialActivity.this, "添加成功", Toast.LENGTH_SHORT).show());
        kanguo.setOnClickListener(v -> Toast.makeText(MoviedaiyingdetialActivity.this, "添加成功", Toast.LENGTH_SHORT).show());

    }

    public void initmoviedetial() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/preview/2")
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
                            MovieDaiyingDetialBean bean = gson.fromJson(result, MovieDaiyingDetialBean.class);
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
    public void initotherdaiyingdetialview() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/preview/2")
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
                            MovieDaiyingDetialBean bean = gson.fromJson(result, MovieDaiyingDetialBean.class);
                            Message message = new Message();
                            message.what = 0;
                            message.obj = bean;
                            handler2.sendMessage(message);
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

}