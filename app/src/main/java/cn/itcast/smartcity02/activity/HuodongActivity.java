package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.HuodongcategoryBean;
import cn.itcast.smartcity02.Bean.HuodonglistBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.HuodongcategoryAdapter;
import cn.itcast.smartcity02.adapter.HuodonglistAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HuodongActivity extends AppCompatActivity {

    //轮播图
    List<String> stringList = new ArrayList<String>();
    //分类
    private RecyclerView huodong_recyclerview;
    private HuodongcategoryAdapter adapter;
    private List<HuodongcategoryBean.DatasBean> datasBeanList;
    //列表
    private List<HuodonglistBean.RowsBean> listbean;
    private HuodonglistAdapter adapter2;
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
                adapter2 = new HuodonglistAdapter(HuodongActivity.this, listbean);
                // 设置布局管理器
                list_recyclerview.setLayoutManager(new LinearLayoutManager(HuodongActivity.this));
                // 设置适配器
                list_recyclerview.setAdapter(adapter2);
                // 设置item点击跳转事件 分别到对应的页面,在Intent中可以自己创建跳转的activity
                adapter2.setItemClickListener(new HuodonglistAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        if (position == 0) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 1) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 2) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 3) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 4) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 5) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        }
                        startActivity(intent);
                    }
                });

            }
        }
    };
    //分类
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                HuodongcategoryBean huodongBean = (HuodongcategoryBean) msg.obj;
                datasBeanList = huodongBean.getData();
                // 实例化adapter
                adapter = new HuodongcategoryAdapter(HuodongActivity.this, datasBeanList);
                // 设置布局管理器
                LinearLayoutManager ms = new LinearLayoutManager(HuodongActivity.this);
                ms.setOrientation(LinearLayoutManager.HORIZONTAL);
                huodong_recyclerview.setLayoutManager(ms);
                // 设置适配器
                huodong_recyclerview.setAdapter(adapter);
                // 设置item点击跳转事件 分别到对应的页面,在Intent中可以自己创建跳转的activity
                adapter.setItemClickListener(new HuodongcategoryAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        if (position == 0) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 1) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 2) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 3) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 4) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        } else if (position == 5) {
                            intent = new Intent(HuodongActivity.this, DashujvyiliaoActivity.class);
                        }
                        startActivity(intent);
                    }
                });
            }
        }
    };
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);

        huodong_recyclerview = findViewById(R.id.category_recyclerview);
        list_recyclerview = findViewById(R.id.list_hd);
        initbanner();

        initnewslist();
        inithuodongcategorylist();

        LinearLayout shouye = findViewById(R.id.shouye_hd);
        LinearLayout fuwu = findViewById(R.id.fuwu_hd);
        LinearLayout xinwen = findViewById(R.id.xinwen_hd);
        LinearLayout huodong = findViewById(R.id.huodong_hd);
        LinearLayout geren = findViewById(R.id.geren_hd);

        shouye.setOnClickListener(v -> startActivity(new Intent(HuodongActivity.this,MainActivity.class)));
        fuwu.setOnClickListener(v -> startActivity(new Intent(HuodongActivity.this,ServiceActivity.class)));
        xinwen.setOnClickListener(v -> startActivity(new Intent(HuodongActivity.this,NewsActivity.class)));
        huodong.setOnClickListener(v -> startActivity(new Intent(HuodongActivity.this,HuodongActivity.class)));
        geren.setOnClickListener(v -> startActivity(new Intent(HuodongActivity.this,PersonCenterActivity.class)));


    }

    public void initbanner() {
        banner = findViewById(R.id.banner_hd);
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/08/a648fc9f-19de-4cb8-ab36-92784412d677.jpg");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/08/3e8fea67-6175-4029-ac58-58f8285e592d.jpg");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/08/daec8f1a-cfd5-426b-9118-dcc3ec3c72d3.jpg");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/08/c4d8e1ad-abb7-4160-9bb5-e283024da32c.jpg");
        banner.setAdapter(new BannerImageAdapter<String>(stringList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                        Glide.with(holder.itemView)
                                .load(data)
                                .into(holder.imageView);
                    }
                })
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this))
                .start();
    }


    //分类
    public void inithuodongcategorylist() {
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 创建 Request对象
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/activity/category/list")
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
                        //html -> txt
                        Spanned spanned = Html.fromHtml(result);
                        // runOnUiThread()用于更新UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                HuodongcategoryBean categoryBean = gson.fromJson(result, HuodongcategoryBean.class);
                                Message msg = new Message();
                                msg.what = 0;
                                msg.obj = categoryBean;
                                handler.sendMessage(msg);
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //列表
    public void initnewslist() {
        OkHttpClient client2 = new OkHttpClient();
        Request request2 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/activity/activity/list")
                .build();
        try {
            Call call2 = client2.newCall(request2);
            call2.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result2 = response.body().string();
                        Log.i("请求成功", result2);

                        // runOnUiThread()用于更新UI
                        runOnUiThread(() -> {
                            Gson gson2 = new Gson();
                            HuodonglistBean newsBean = gson2.fromJson(result2, HuodonglistBean.class);
                            Message msg2 = new Message();
                            msg2.what = 0;
                            msg2.obj = newsBean;
                            handler2.sendMessage(msg2);
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}