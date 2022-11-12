package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.itcast.smartcity02.Bean.PisaBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.PisadianinformationAdapter;
import cn.itcast.smartcity02.utils.ApiConfig;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class PisadianinfomationActivity extends AppCompatActivity {
    //购物车
        static LinearLayout popupLayout;
        static PopupWindow pw;

    //获取数据
        private List<PisaBean.DataBean> list;
        private PisadianinformationAdapter adapter;
        private RecyclerView foodlistView;

        @SuppressLint("HandlerLeak")
        private Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    PisaBean DataBean = (PisaBean) msg.obj;
                    list = DataBean.getData();
                    // 实例化adapter
                    adapter = new PisadianinformationAdapter(PisadianinfomationActivity.this, list);
                    // 设置布局管理器
                    foodlistView.setLayoutManager(new LinearLayoutManager(PisadianinfomationActivity.this));
                    // 设置适配器
                    foodlistView.setAdapter(adapter);

//                    adapter.setItemClickListener(new PisadianinformationAdapter.MyItemClickListener() {
//                        @Override
//                        public void onItemClick(View v, int position) {
//                            Intent intent = null;
//                            if (position == 0) {
//                                intent = new Intent(PisadianinfomationActivity.this, FirstfoodActivity.class);
//                            } else if (position == 1) {
//                                intent = new Intent(PisadianinfomationActivity.this, FirstfoodActivity.class);
//                            } else if (position == 2) {
//                                intent = new Intent(PisadianinfomationActivity.this, FirstfoodActivity.class);
//                            } else if (position == 3) {
//                                intent = new Intent(PisadianinfomationActivity.this, FirstfoodActivity.class);
//                            } else if (position == 4) {
//                                intent = new Intent(PisadianinfomationActivity.this, FirstfoodActivity.class);
//                            }
//                            startActivity(intent);
//                        }
//                    });
                }
            }
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pisadianinfomation);

            //购物车popup
            View list = getLayoutInflater().inflate(R.layout.activity_popup,null);
            pw = new PopupWindow(list, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            pw.setFocusable(true);//获得焦点
            pw.setBackgroundDrawable(new BitmapDrawable());     //点空白处 隐藏popup
            popupLayout = findViewById(R.id.popup);

            //默认初始化披萨界面
            initfoodlistpisa();

            //findViewById控件
            Button pisa = findViewById(R.id.pisa);
            Button zuhetaocan = findViewById(R.id.zuhetaocan);
            Button jvfan = findViewById(R.id.jvfan);

            //控件点击事件
            pisa.setOnClickListener(v -> initfoodlistpisa());
            zuhetaocan.setOnClickListener(v -> initfoodlistzuhetaocan());
            jvfan.setOnClickListener(v -> initfoodlistjvfan());


//            //  添加减去按钮点击事件
//            TextView shuliang = findViewById(R.id.shuliang);
//            //将获取到的数转化为int类型
//            int number =  Integer.valueOf(shuliang.getText().toString());
//            ImageView minus = findViewById(R.id.minus);
//            ImageView add = findViewById(R.id.add);
//            minus.setOnClickListener(v -> add_minus);
//            add.setOnClickListener(v -> add_minus.add());


            //findViewById按钮控件
            Button shopping_car = findViewById(R.id.shopping_car);
            Button gotopay = findViewById(R.id.goto_pay);

            //购物车点击事件
//            shopping_car.setOnClickListener(v -> onPopup());

            //结算点击事件
            gotopay.setOnClickListener(v -> {
                startActivity(new Intent(PisadianinfomationActivity.this,DingdanActivity.class));
            });

            //初始化菜品区
            foodlistView = findViewById(R.id.caipinqu);
        }








        //购物车点击方法
             public static void onPopup() {
                pw.showAtLocation(popupLayout, Gravity.BOTTOM,0,0);
            }

        //请求披萨数据
        public void initfoodlistpisa() {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(ApiConfig.BASE_API + "/prod-api/api/takeout/product/list?sellerId=1&categoryId=3")
                    .build();

            try {
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String result = response.body().string();
                            Log.i("请求成功", result);

                            //runOnUiThread()用于更新UI
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    Gson gson = new Gson();
                                    //将数据解析
                                    PisaBean foodlistbean = gson.fromJson(result, PisaBean.class);
                                    Message msg = handler.obtainMessage();
                                    msg.what = 0;
                                    msg.obj = foodlistbean;
                                    handler.sendMessage(msg);
                                }
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



            //请求组合套餐数据
            public void initfoodlistzuhetaocan(){
                OkHttpClient client2 = new OkHttpClient();
                Request request2 = new Request.Builder()
                        .url(ApiConfig.BASE_API + "/prod-api/api/takeout/product/list?sellerId=1&categoryId=19")
                        .build();

                try {
                    Call call2 = client2.newCall(request2);
                    call2.enqueue(new Callback() {
                        @Override
                        public void onResponse(@NonNull Call call2, @NonNull Response response2) throws IOException {
                            if (response2.isSuccessful()){
                                String result2 = response2.body().string();
                                Log.i("请求成功",result2);

                                //runOnUiThread()用于更新UI
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        Gson gson2 = new Gson();
                                        PisaBean foodlistbean = gson2.fromJson(result2,PisaBean.class);
                                        Message msg2 = new Message();
                                        msg2.what = 0;
                                        msg2.obj = foodlistbean;
                                        handler.sendMessage(msg2);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {
                            Log.i("onFailure", e.getMessage());
                        }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                }
        }


    //请求焗饭数据
    public void initfoodlistjvfan(){
        OkHttpClient client3 = new OkHttpClient();
        Request request3 = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/takeout/product/list?sellerId=1&categoryId=20")
                .build();

        try {
            Call call2 = client3.newCall(request3);
            call2.enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call3, @NonNull Response response3) throws IOException {
                    if (response3.isSuccessful()){
                        String result3 = response3.body().string();
                        Log.i("请求成功",result3);

                        //runOnUiThread()用于更新UI
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Gson gson3 = new Gson();
                                PisaBean foodlistbean = gson3.fromJson(result3,PisaBean.class);
                                Message msg3 = new Message();
                                msg3.what = 0;
                                msg3.obj = foodlistbean;
                                handler.sendMessage(msg3);
                            }
                        });
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.i("onFailure", e.getMessage());
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }





//   //减去按钮方法
//   public void minus() {
//               if (number < 0) {number = 0;}
//               else {number -= 1;}
//   }
//
//   //  添加按钮方法
//   public void add() {
//       number += 1;
//   }

}