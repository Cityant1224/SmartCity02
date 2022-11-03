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

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.ReyingBean;
import cn.itcast.smartcity02.R;
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
                        if (position == 0){
                            intent = new Intent(MovieActivity.this,MoviedetialActivity.class);
                        }
                        startActivity(intent);
                    }
                });


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mrecyclerView = findViewById(R.id.reying_movie);
        initReyingview();
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


}