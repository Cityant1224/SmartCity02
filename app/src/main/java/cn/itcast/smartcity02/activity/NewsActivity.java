package cn.itcast.smartcity02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.NewsBean;
import cn.itcast.smartcity02.Bean.ServiceBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.NewsAdapter;
import cn.itcast.smartcity02.adapter.RecycleServiceAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsActivity extends AppCompatActivity {
    private List<NewsBean.RowsBean> newsBeanlist;
    private NewsAdapter adapter;
    private RecyclerView news_recyclerview;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                NewsBean newsBean = (NewsBean) msg.obj;
                newsBeanlist = newsBean.getRows();
                // 实例化adapter
                adapter = new NewsAdapter(NewsActivity.this, newsBeanlist);
                // 设置布局管理器
                news_recyclerview.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
                // 设置适配器
                news_recyclerview.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ImageView fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(v -> startActivity(new Intent(NewsActivity.this,MainActivity.class)));

        news_recyclerview = findViewById(R.id.new_RecyclerView);
        getNewsData();
    }

    //请求数据
    public void getNewsData(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/press/press/list")
                .build();

    try{
        Call call =  client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i("onFailure", e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    Log.i("请求成功", result);

                    // runOnUiThread()用于更新UI
                    runOnUiThread(() -> {
                        Gson gson = new Gson();
                        NewsBean newsBean = gson.fromJson(result, NewsBean.class);
                        Message msg = new Message();
                        msg.what = 0;
                        msg.obj = newsBean;
                        handler.sendMessage(msg);
                    });
                }
            }
        });
    }catch (Exception e) {
        e.printStackTrace();
        }
    }
}