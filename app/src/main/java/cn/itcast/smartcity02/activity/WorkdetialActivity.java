package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;

import cn.itcast.smartcity02.Bean.WorkdetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.WorkdetialAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class WorkdetialActivity extends AppCompatActivity {

    //  工作细节
    private WorkdetialBean.DataBean workdetialitem;
    private WorkdetialAdapter workdetialadapter;
    private RecyclerView workdetialview;


    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                WorkdetialBean detialbean = (WorkdetialBean) msg.obj;
                workdetialitem = detialbean.getData();
                workdetialadapter = new WorkdetialAdapter(WorkdetialActivity.this, workdetialitem);

                workdetialview.setLayoutManager(new LinearLayoutManager(WorkdetialActivity.this));
                workdetialview.setAdapter(workdetialadapter);

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workdetial);

        workdetialview = findViewById(R.id.worklist);
        initview();
    }


    public void initview() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/job/post/1")
                .build();

        try {
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                        Gson gson = new Gson();
                        WorkdetialBean bean = gson.fromJson(result, WorkdetialBean.class);
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