package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;

import cn.itcast.smartcity02.Bean.MovieDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.MovieDetialAdapter;
import cn.itcast.smartcity02.adapter.MovieotrherdetialAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MoviedetialActivity extends AppCompatActivity {

    //    上
    private MovieDetialBean.DataBean dataBeans;
    private MovieDetialAdapter adapter;
    private RecyclerView mrecyclerview;

    //    下
    private MovieDetialBean.DataBean ndataBeans;
    private MovieotrherdetialAdapter nadapter;
    private RecyclerView nrecyclerview;


    //上
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MovieDetialBean databean = (MovieDetialBean) msg.obj;
                dataBeans = databean.getData();
                adapter = new MovieDetialAdapter(MoviedetialActivity.this, dataBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(MoviedetialActivity.this));
                mrecyclerview.setAdapter(adapter);
            }
        }
    };

    //    下
    @SuppressLint("HandlerLeak")
    private final Handler handler2 = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MovieDetialBean databean2 = (MovieDetialBean) msg.obj;
                ndataBeans = databean2.getData();
                nadapter = new MovieotrherdetialAdapter(MoviedetialActivity.this, ndataBeans);
                nrecyclerview.setLayoutManager(new LinearLayoutManager(MoviedetialActivity.this));
                nrecyclerview.setAdapter(nadapter);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetial);

//        上
        mrecyclerview = findViewById(R.id.moviedetial_item);
        initmoviedetial();
//下
        nrecyclerview = findViewById(R.id.movieotherdetial_item);
        initmovieotherdetial();


        ImageView fanhui = findViewById(R.id.fanhui_moviedetial);
        fanhui.setOnClickListener(v -> startActivity(new Intent(MoviedetialActivity.this,MovieActivity.class)));

        Button want = findViewById(R.id.xiangkan_btn_moviedetial);
        Button kanguo = findViewById(R.id.kanguo_btn_moviedetial);
        want.setOnClickListener(v -> {Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();});
        kanguo.setOnClickListener(v -> {Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();});
    }

    public void initmoviedetial() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/detail/2")
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
                            MovieDetialBean bean = gson.fromJson(result, MovieDetialBean.class);
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


    public void initmovieotherdetial() {

        OkHttpClient client2 = new OkHttpClient();
        Request request2 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/film/detail/2")
                .build();
        try {
            Call call2 = client2.newCall(request2);
            call2.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response2) throws IOException {
                    if (response2.isSuccessful()) {
                        String result2 = response2.body().string();

                        runOnUiThread(() -> {
                            Gson gson2 = new Gson();
                            MovieDetialBean bean2 = gson2.fromJson(result2, MovieDetialBean.class);
                            Message message2 = new Message();
                            message2.what = 0;
                            message2.obj = bean2;
                            handler2.sendMessage(message2);
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