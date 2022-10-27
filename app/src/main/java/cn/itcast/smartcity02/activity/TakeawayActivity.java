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

import com.bumptech.glide.Glide;

import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.SalerlistBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.SalerlistAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TakeawayActivity extends AppCompatActivity {

    //主题列表
//    private List<TakeawayCategoryBean.RowsBean> list;
//    private TakeawayCategoryAdapter adapter;
//    private RecyclerView takeawayCategoryView;

    //商家列表
    private List<SalerlistBean.RowsBean> salerlist;
    private SalerlistAdapter adapter2;
    private RecyclerView salerlistView;


    //主题
//    @SuppressLint("HandlerLeak")
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0) {
//                TakeawayCategoryBean bean = (TakeawayCategoryBean) msg.obj;
//                list = bean.getRows();
//
//                adapter = new TakeawayCategoryAdapter(TakeawayActivity.this, list);
//                takeawayCategoryView.setLayoutManager(new GridLayoutManager(TakeawayActivity.this, 5));
//                takeawayCategoryView.setAdapter(adapter);



//                adapter.setItemClickListener((view, position) -> {
//                    Intent intent = null;
//                    if (position == 1) {
//                        intent = new Intent(TakeawayActivity.this, MeishiActivity.class);
//                    } else if (position == 2) {
//                        intent = new Intent(TakeawayActivity.this, TiandianActivity.class);
//                    } else if (position == 3) {
//                        intent = new Intent(TakeawayActivity.this, HanbaoActivity.class);
//                    } else if (position == 4) {
//                        intent = new Intent(TakeawayActivity.this, ZhajiActivity.class);
//                    } else if (position == 5) {
//                        intent = new Intent(TakeawayActivity.this, MianguanActivity.class);
//                    }
//
//                    Bundle bundle = new Bundle();
//                    bundle.putString("title", list.get(position).getThemeName());
//                    intent.putExtras(bundle);
//                    startActivity(intent);
//
//                });


//            }
//        }
//    };

    //salellerlist界面
    @SuppressLint("HandlerLeak")
    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                SalerlistBean salerlistBean = (SalerlistBean) msg.obj;
                salerlist = salerlistBean.getRows();
                // 实例化adapter
                adapter2 = new SalerlistAdapter(TakeawayActivity.this, salerlist);
                // 设置布局管理器
                salerlistView.setLayoutManager(new LinearLayoutManager(TakeawayActivity.this));
                // 设置适配器
                salerlistView.setAdapter(adapter2);

                adapter2.setItemClickListener(new SalerlistAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = null;
                        if (position == 0) {
                            intent = new Intent(TakeawayActivity.this, PisadianinfomationActivity.class);
                        }else if (position == 1) {
                            //intent = new Intent(TakeawayActivity.this,PisadianInformation.class);
                        }
                        else if (position == 2) {
                            //intent = new Intent(TakeawayActivity.this,PisadianInformation.class);
                        }else if (position == 3) {
                            //intent = new Intent(TakeawayActivity.this,PisadianInformation.class);
                        }else if (position == 4) {
                            //intent = new Intent(TakeawayActivity.this,PisadianInformation.class);
                        }else if (position == 5) {
                            //intent = new Intent(TakeawayActivity.this,PisadianInformation.class);
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
        setContentView(R.layout.activity_takeaway);

//        takeawayCategoryView = findViewById(R.id.category_takeaway);
        salerlistView = findViewById(R.id.takeaway_salerlist);

        initbanner();
//        initCategoryData();
        initsalerlist();
    }

    //轮播图
    List<String> categroyList = new ArrayList<String>();
    private Banner banner;

    public void initbanner() {
        banner = findViewById(R.id.banner_takeaway);
        categroyList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/12/873a6039-4294-43fe-9209-408a001cf7df.png");
        categroyList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/12/2e1d64a3-ce43-40de-99a7-48b281b3af15.jpg");
        categroyList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/12/b81c793c-3f6e-42b8-9a07-3d9b42a422c6.jpg");
        banner.setAdapter(new BannerImageAdapter<String>(categroyList) {
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

    //请求分类数据
//    private void initCategoryData() {
//        OkHttpClient client = new OkHttpClient();
//        okhttp3.Request request = new Request.Builder()
//                .url(ApiConfig.BASE_API + "/prod-api/api/takeout/theme/list")
//                .build();
//
//        try {
//            Call call = client.newCall(request);
//            call.enqueue(new Callback() {
//                @Override
//                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                    if (response.isSuccessful()) {
//                        final String result = response.body().string();
//                        Log.i("请求成功", result);
//                        runOnUiThread(() -> {
//                            Gson gson = new Gson();
//                            TakeawayCategoryBean bean = gson.fromJson(result, TakeawayCategoryBean.class);
//                            Message msg = new Message();
//                            msg.what = 0;
//                            msg.obj = bean;
//                            handler.sendMessage(msg);
//                        });
//                    }
//                }
//
//                @Override
//                public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                    Log.i("onFailure", e.getMessage());
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    //请求商家列表数据
    public void initsalerlist(){
        OkHttpClient client2 = new OkHttpClient();
        Request request2 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/takeout/seller/list")
                .build();

        try {
            Call call = client2.newCall(request2);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if(response.isSuccessful()) {
                        String result2 = response.body().string();
                        Log.i("请求成功",result2);

                        //runOnUiThread()用于更新UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                SalerlistBean salerlistBean = gson.fromJson(result2,SalerlistBean.class);
                                Message msg2 = new Message();
                                msg2.what = 0;
                                msg2.obj = salerlistBean;
                                handler2.sendMessage(msg2);
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