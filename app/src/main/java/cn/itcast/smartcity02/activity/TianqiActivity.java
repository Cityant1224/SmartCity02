package cn.itcast.smartcity02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.metrics.Event;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.HouseDetialBean;
import cn.itcast.smartcity02.Bean.TianqiBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.HoursTemperatureAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TianqiActivity extends AppCompatActivity {

    private List<TianqiBean.DataBean.TodayBean.HoursBean> dataBeans;
    private HoursTemperatureAdapter adapter;
    private RecyclerView mrecyclerview;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                TianqiBean.DataBean.TodayBean bean = (TianqiBean.DataBean.TodayBean)msg.obj;
                dataBeans = bean.getHours();
                adapter = new HoursTemperatureAdapter(TianqiActivity.this,dataBeans);
                mrecyclerview.setLayoutManager(new LinearLayoutManager(TianqiActivity.this));
                mrecyclerview.setAdapter(adapter);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianqi);
        mrecyclerview = findViewById(R.id.today_times_weather);
        initNowTemperature();

        initDaysTemperature();
    }

    private void initNowTemperature() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/living/weather")
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
                            TianqiBean.DataBean.TodayBean bean = gson.fromJson(result,TianqiBean.DataBean.TodayBean.class);
                            Message message = new Message();
                            message.what = 0;
                            message.obj = bean;
                            handler.sendMessage(message);

                        });
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure",e.getMessage());
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDaysTemperature() {

    }
}