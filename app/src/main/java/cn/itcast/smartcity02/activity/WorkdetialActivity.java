package cn.itcast.smartcity02.activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cn.itcast.smartcity02.R;


//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.util.List;
//
//import cn.itcast.smartcity02.Bean.WorkdetialBean;
//import cn.itcast.smartcity02.R;
//import cn.itcast.smartcity02.adapter.WorkdetialAdapter;
//import cn.itcast.smartcity02.utils.ApiConfig;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
public class WorkdetialActivity extends AppCompatActivity {
//
////  工作细节
//    private WorkdetialBean.DataBean worklistitem;
//    private WorkdetialAdapter worklistadapter;
//    private RecyclerView worklistview;
//
//
//    //工作细节
//    @SuppressLint("HandlerLeak")
//    private Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0) {
//                WorkdetialBean mbean = (WorkdetialBean) msg.obj;
//                worklistadapter = new WorkdetialAdapter(WorkdetialActivity.this, WorkdetialBean.DataBean);
//
//                worklistview.setLayoutManager(new LinearLayoutManager(WorkdetialActivity.this));
//                worklistview.setAdapter(worklistadapter);
//
//
//            }
//        }
//    };
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workdetial);
//
//        initjoblist1();
//        worklistview = findViewById(R.id.worklist);
//
//        Button give = findViewById(R.id.give_report);
//        give.setOnClickListener(v -> {
//            Toast.makeText(WorkdetialActivity.this, "投递成功", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(WorkdetialActivity.this,FindworkActivity.class));
//        });
    }
//
//
//    //找工作
//    public void initjoblist1() {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(ApiConfig.BASE_API + "/prod-api/api/job/post/1")
//                .build();
//
//        try {
//            Call call = client.newCall(request);
//            call.enqueue(new Callback() {
//                @Override
//                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                    String result = response.body().string();
//                    if (response.isSuccessful()) {
//                        Gson gson = new Gson();
//                        Log.i("resopnse",result);
//                        WorkdetialBean workdetialBean = gson.fromJson(result, WorkdetialBean.class);
//                        Message message = new Message();
//                        message.what = 0;
//                        message.obj = workdetialBean;
//                        handler.sendMessage(message);
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
}