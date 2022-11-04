package cn.itcast.smartcity02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.CinameListBean;
import cn.itcast.smartcity02.Bean.MovieDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.CinemaListAdapter;
import cn.itcast.smartcity02.adapter.MovieDetialAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CinemalistActivity extends AppCompatActivity {

    //    上
    private MovieDetialBean.DataBean dataBeans;
    private MovieDetialAdapter adapter;
    private RecyclerView mrecyclerview;


    //     下
    private List<CinameListBean.RowsBean> rowsBeans;
    private CinemaListAdapter adapter2;
    private RecyclerView nrecyclerview;


    //    上
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                MovieDetialBean databean = (MovieDetialBean) msg.obj;
                dataBeans = databean.getData();
                adapter = new MovieDetialAdapter(CinemalistActivity.this, dataBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(CinemalistActivity.this));
                mrecyclerview.setAdapter(adapter);
            }
        }
    };


    //     下
    @SuppressLint("HandlerLeak")
    private final Handler handler2 = new Handler() {
        public void handleMessage(Message msg2) {
            super.handleMessage(msg2);
            if (msg2.what == 0) {
                CinameListBean rowsbean = (CinameListBean) msg2.obj;
                rowsBeans = rowsbean.getRows();
                adapter2 = new CinemaListAdapter(CinemalistActivity.this, rowsBeans);
                nrecyclerview.setLayoutManager(new LinearLayoutManager(CinemalistActivity.this));
                nrecyclerview.setAdapter(adapter2);
                adapter2.setMyItemClickListener((view, position) -> {
                    Intent intent = null;
                    if (position == 0) {
                        intent = new Intent(CinemalistActivity.this,CinemaInfoActivity.class);
                    }
                    startActivity(intent);
                });
            }
        }
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemalist);

        mrecyclerview = findViewById(R.id.movie_cinemalist);
        initmoviedetial();

        nrecyclerview = findViewById(R.id.cinemalist_cinemalist);
        initCinemalistview();
    }


    //    上
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




    //      下
    public void initCinemalistview() {
        OkHttpClient client = new OkHttpClient();
        Request request2 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/movie/theatre/list")
                .build();
        try {
            Call call2 = client.newCall(request2);
            call2.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result2 = response.body().string();

                        runOnUiThread(() -> {
                            Gson gson2 = new Gson();
                            CinameListBean bean2 = gson2.fromJson(result2, CinameListBean.class);
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