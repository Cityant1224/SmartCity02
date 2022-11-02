package cn.itcast.smartcity02.activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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


public class MainActivity extends AppCompatActivity {
    //服务列表
    private RecyclerView service_recyclerview;
    private RecycleServiceAdapter adapter;
    private List<ServiceBean.RowsBean> rowsBeanList;


    //新闻列表
    private List<NewsBean.RowsBean> newsBeanlist;
    private NewsAdapter adapter2;
    private RecyclerView news_recyclerview;


    //服务列表
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0) {
                ServiceBean serviceBean = (ServiceBean) msg.obj;
                rowsBeanList = serviceBean.getRows();
                // 实例化adapter
                adapter= new RecycleServiceAdapter(MainActivity.this,rowsBeanList);
                // 设置布局管理器
                service_recyclerview.setLayoutManager(new GridLayoutManager(MainActivity.this,4));
                // 设置适配器
                service_recyclerview.setAdapter(adapter);
                // 设置item点击跳转事件 分别到对应的页面,在Intent中可以自己创建跳转的activity
                adapter.setItemClickListener(new RecycleServiceAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String url = ApiConfig.BASE_API + "/" + rowsBeanList.get(position).getLink();
                        Intent intent = null;
                        if (position==0) {
                            intent = new Intent(MainActivity.this, ParkActivity.class);
                        }  else if (position==1) {
                            intent = new Intent(MainActivity.this, SubwayActivity.class);
                        }  else if (position==2) {
                            intent = new Intent(MainActivity.this, BusActivity.class);
                        }  else if (position==3) {
                            intent = new Intent(MainActivity.this, ApponitmentActivity.class);
                        }  else if (position==4) {
                            intent = new Intent(MainActivity.this, TrafficActivity.class);
                        }  else if (position==5) {
                            intent = new Intent(MainActivity.this, LivingPayActivity.class);
                        }  else if (position==6) {
                            intent = new Intent(MainActivity.this, TakeawayActivity.class);
                        }  else if (position==7) {
                            intent = new Intent(MainActivity.this, FindhouseActivity.class);
                        }  else if (position==8) {
                            intent = new Intent(MainActivity.this, MovieActivity.class);
                        }  else if (position==9) {
                            intent = new Intent(MainActivity.this, FindworkActivity.class);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("title",rowsBeanList.get(position).getServiceName());
                        bundle.putString("url",url);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        }
    };


    //新闻列表
    //创建handler
    @SuppressLint("HandlerLeak")
    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg2) {
            super.handleMessage(msg2);

            //handler捕获消息
            if (msg2.what == 0) {
                NewsBean newsBean = (NewsBean) msg2.obj;
                newsBeanlist = newsBean.getRows();
                // 实例化adapter
                adapter2 = new NewsAdapter(MainActivity.this, newsBeanlist);
                // 设置布局管理器
                news_recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                // 设置适配器
                news_recyclerview.setAdapter(adapter2);
                adapter2.setItemClickListener(new NewsAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        if (position==0) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==1) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==2) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==3) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==4) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==5) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==6) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==7) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==8) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
                        }  else if (position==9) {
                            intent = new Intent(MainActivity.this, NewsActivity.class);
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
        setContentView(R.layout.activity_main);

        //初始化轮播图
        initbanner();
        //初始化服务列表
        service_recyclerview = findViewById(R.id.service_list);
        initservicelist();
        //新闻recyclerview控件
        news_recyclerview = findViewById(R.id.news_recycler);

        EditText search = findViewById(R.id.search_news_input);
        String search_text = search.getText().toString();

        ImageView sousuo = findViewById(R.id.imageView_main);
        sousuo.setOnClickListener(v -> {
            if (search_text.equals("新闻")){
                startActivity(new Intent(MainActivity.this,XinwenActivity.class));
            }
        });


        //初始化新闻列表
        initnewslist();
        //初始化导航栏
        inittab();
    }


    //轮播图
    List<String> stringList = new ArrayList<String>();
    private Banner banner;
    public void initbanner() {
        banner = findViewById(R.id.banner);
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/e614cb7f-63b0-4cda-bf47-db286ea1b074.png");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/242e06f7-9fb0-4e16-b197-206f999c98f2.png");
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


    //服务列表
    public void initservicelist() {
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 创建 Request对象
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API+"/prod-api/api/service/list")
                .build();
        try {
            // 回调
            Call call = client.newCall(request);
            // 异步请求
            call.enqueue(new okhttp3.Callback() {
                @Override
                // 请求失败
                public void onFailure(Call call, IOException e) {
                    Log.i("onFailure",e.getMessage());
                }
                // 响应成功
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String result = response.body().string();
                        // runOnUiThread()用于更新UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                ServiceBean serviceBean = gson.fromJson(result,ServiceBean.class);
                                Message msg = new Message();
                                msg.what=0;
                                msg.obj = serviceBean;
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


    //新闻列表
    public void initnewslist(){
        OkHttpClient client2 = new OkHttpClient();
        Request request2 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/press/press/list")
                .build();
        try{
            Call call2 =  client2.newCall(request2);
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

                        //  runOnUiThread() 创建子线程用于更新UI

                        runOnUiThread(() -> {
                            Gson gson2 = new Gson();
                            NewsBean newsBean = gson2.fromJson(result2, NewsBean.class);

                            //从子线程发出消息
                            Message msg2 = new Message();
                            msg2.what = 0;
                            msg2.obj = newsBean;
                            handler2.sendMessage(msg2);
                        });
                    }
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //菜单条
    public void inittab() {
        LinearLayout shouye = findViewById(R.id.shouye);
        LinearLayout xinwen = findViewById(R.id.xinwen);
        LinearLayout fuwu = findViewById(R.id.fuwu);
        LinearLayout huodong = findViewById(R.id.huodong);
        LinearLayout geren = findViewById(R.id.geren);

        shouye.setOnClickListener( v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        xinwen.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,NewsActivity.class)));
        fuwu.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ServiceActivity.class)));
        huodong.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,HuodongActivity.class)));
        geren.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,PersonCenterActivity.class)));
    }
}
