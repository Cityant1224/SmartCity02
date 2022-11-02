package cn.itcast.smartcity02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.Subway_lineBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.Subway_lineAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DiyigeActivity extends AppCompatActivity {

    private List<Subway_lineBean.ParamsBean.DatasBean> namelist;
    private Subway_lineAdapter adapter;
    private RecyclerView namelistView;


    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if (msg.what ==0){
                Subway_lineBean.ParamsBean namelistBean = (Subway_lineBean.ParamsBean) msg.obj;
                namelist = namelistBean.getDatas();
                adapter = new Subway_lineAdapter(DiyigeActivity.this, namelist);
                namelistView.setLayoutManager(new LinearLayoutManager(DiyigeActivity.this));
                namelistView.setAdapter(adapter);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyige);
        initStationname_first();

        namelistView = findViewById(R.id.recycler_stationname_first);
    }

    private void initStationname_first(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://124.93.196.45:10001/prod-api/api/metro/line/31")
                .build();

        try{
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("Onfailure",e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                        Log.i("请求成功",result);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                Subway_lineBean.ParamsBean namelistBean = gson.fromJson(result,Subway_lineBean.ParamsBean.class);
                                Message msg = new Message();
                                msg.what = 0;
                                msg.obj = namelistBean;
                                handler.sendMessage(msg);
                            }
                        });
                    }
                }
            });
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}