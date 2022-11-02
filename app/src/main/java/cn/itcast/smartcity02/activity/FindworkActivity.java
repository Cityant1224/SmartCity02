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

import cn.itcast.smartcity02.Bean.FindworkBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.FindworkAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FindworkActivity extends AppCompatActivity {

    //找工作
    private List<FindworkBean.RowsBean> worklist;
    private FindworkAdapter workadapter;
    private RecyclerView workview;


    //找工作
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                FindworkBean mbean = (FindworkBean) msg.obj;
                worklist = mbean.getRows();
                workadapter = new FindworkAdapter(FindworkActivity.this,worklist);

                workview.setLayoutManager(new LinearLayoutManager(FindworkActivity.this));
                workview.setAdapter(workadapter);

                workadapter.setItemClickListener(new FindworkAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = null;
                        if (position == 0) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        }else if (position == 1) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        }else if (position == 2) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 3) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 4) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 5) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 6) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 7) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 8) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        } else if(position == 9) {
                            intent = new Intent(FindworkActivity.this,WorkdetialActivity.class);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("",worklist.get(position).getName());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                });

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findwork);
        //初始化找工作列表
        initjoblist();
        workview = findViewById(R.id.findwork);

        //返回按钮
        ImageView fanhui = findViewById(R.id.fanhui_findwork);
        fanhui.setOnClickListener(v -> startActivity(new Intent(FindworkActivity.this,MainActivity.class)));

    }


    //找工作
    public void initjoblist() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/job/post/list")
                .build();

        try {
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String result = response.body().string();
                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        FindworkBean findworkBean = gson.fromJson(result, FindworkBean.class);
                        Message message = new Message();
                        message.what = 0;
                        message.obj = findworkBean;
                        handler.sendMessage(message);
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