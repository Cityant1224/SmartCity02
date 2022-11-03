package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.FindHouseBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.FindHouseAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FindhouseActivity extends AppCompatActivity {
    private List<FindHouseBean.RowsBean> rowsBeans;
    private FindHouseAdapter adapter;
    private RecyclerView mrecyclerview;


    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                FindHouseBean bean = (FindHouseBean) msg.obj;
                rowsBeans = bean.getRows();
                adapter = new FindHouseAdapter(FindhouseActivity.this, rowsBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(FindhouseActivity.this));
                mrecyclerview.setAdapter(adapter);
                adapter.setItemClickListener((view, position) -> {
                    Intent intent = null;
                    if (position == 0) {
                        intent = new Intent(FindhouseActivity.this, HousedetialActivity.class);
                    }
                    startActivity(intent);
                });
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findhouse);

        mrecyclerview = findViewById(R.id.recycler_findhouse);
        initview();

        ImageView guanbi = findViewById(R.id.guanbi_findhouse);
        guanbi.setOnClickListener(v -> startActivity(new Intent(FindhouseActivity.this, MainActivity.class)));
    }


    public void initview() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/house/housing/list")
                .build();
        try {
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                        Log.i("result", result);
                        Gson gson = new Gson();
                        FindHouseBean bean = gson.fromJson(result, FindHouseBean.class);
                        Message message = new Message();
                        message.what = 0;
                        message.obj = bean;
                        handler.sendMessage(message);
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}