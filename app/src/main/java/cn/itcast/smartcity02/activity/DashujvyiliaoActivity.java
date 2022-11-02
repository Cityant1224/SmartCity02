package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import cn.itcast.smartcity02.Bean.HuodonglistBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.DashujvyiliaoAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DashujvyiliaoActivity extends AppCompatActivity {

    //新闻列表
    private List<HuodonglistBean.RowsBean> listbean;
    private DashujvyiliaoAdapter adapter2;
    private RecyclerView list_recyclerview;


    //列表
    @SuppressLint("HandlerLeak")
    private final Handler handler2 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg2) {
            super.handleMessage(msg2);
            if (msg2.what == 0) {
                HuodonglistBean listBean = (HuodonglistBean) msg2.obj;
                listbean = listBean.getRowsbean();
                // 实例化adapter
                adapter2 = new DashujvyiliaoAdapter(DashujvyiliaoActivity.this, listbean);
                // 设置布局管理器
                list_recyclerview.setLayoutManager(new LinearLayoutManager(DashujvyiliaoActivity.this));
                // 设置适配器
                list_recyclerview.setAdapter(adapter2);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashujvyiliao);

        list_recyclerview = findViewById(R.id.recyclerview_dashujvyiliao);

        initdashujvlist();
    }


    //服务列表
    public void initdashujvlist() {
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 创建 Request对象
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/activity/activity/list")
                .build();
        try {
            // 回调
            Call call = client.newCall(request);
            // 异步请求
            call.enqueue(new okhttp3.Callback() {
                @Override
                // 请求失败
                public void onFailure(Call call, IOException e) {
                    Log.i("onFailure", e.getMessage());
                }

                // 响应成功
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String result = response.body().string();
//                        Log.i("result123",result);
                        Spanned spanned  =  Html.fromHtml(result);
//                        Log.i("spanned123",spanned.toString());

                        // runOnUiThread()用于更新UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                HuodonglistBean categoryBean = gson.fromJson(result, HuodonglistBean.class);
//                                Log.i("category123",categoryBean.toString());

                                Message msg = new Message();
                                msg.what = 0;
                                msg.obj = categoryBean;
                                handler2.sendMessage(msg);
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}