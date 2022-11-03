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
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.HouseDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.HouseDetialAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HousedetialActivity extends AppCompatActivity {
    private HouseDetialBean.DataBean DataBeans;
    private HouseDetialAdapter adapter;
    private RecyclerView mrecyclerview;


    @SuppressLint("HandlerLeak")
    private Handler handler =new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                HouseDetialBean databean = (HouseDetialBean)msg.obj;
                DataBeans = databean.getData();
                adapter =new HouseDetialAdapter(HousedetialActivity.this, DataBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(HousedetialActivity.this));
                mrecyclerview.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housedetial);

        mrecyclerview = findViewById(R.id.recycler_housedetial);
        initview();

        ImageView fanhui = findViewById(R.id.fanhui_housedetial);
        fanhui.setOnClickListener(v -> startActivity(new Intent(HousedetialActivity.this,FindhouseActivity.class)));
    }

    public void initview(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/house/housing/1")
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
                            HouseDetialBean bean = gson.fromJson(result,HouseDetialBean.class);
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
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
}