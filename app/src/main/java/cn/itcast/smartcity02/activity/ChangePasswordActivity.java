package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.itcast.smartcity02.Bean.UserBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChangePasswordActivity extends AppCompatActivity {


    //设置发送格式
    public static final MediaType JSON = MediaType.parse("application/json;charset=UTF-8");
    //创建okhttp连接
    final OkHttpClient client = new OkHttpClient();

    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String ReturnMessage = (String) msg.obj;
                final UserBean userbean = new Gson().fromJson(ReturnMessage, UserBean.class);
                final String AA = userbean.getMsg();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        EditText old_pwd = findViewById(R.id.old_pwd);
        EditText new_pwd = findViewById(R.id.new_pwd);
        EditText sure_pwd = findViewById(R.id.sure_pwd);
        Button sure = findViewById(R.id.sure);
        Button cancel = findViewById(R.id.cancel);

        String old_password = old_pwd.getText().toString();
        String new_password = new_pwd.getText().toString();
        String sure_password = sure_pwd.getText().toString();
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //放入json类型数据
                JSONObject json = new JSONObject();
                try {
                    json.put("newpassword", new_password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    json.put("oldpassword", old_password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //第一个参数为存储的文件名，第二个参数为默认的操作模式
                SharedPreferences spf = getSharedPreferences("get_token.xml", MODE_PRIVATE);
                //第一个参数为键的名称，第二个参数为找不到值的时候的默认值
                String token = spf.getString("token", "");


                //发送请求
                RequestBody body = RequestBody.create(JSON, json.toString());
                Request request = new Request.Builder()
                        .url(ApiConfig.BASE_API + "/prod-api/api/common/user/resetPwd")
                        .put(body)
                        .addHeader("Authorization", token)
                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        String result2 = response.body().string();
                        //获取获得的json中的对象
                        JsonObject jsonObject = new JsonParser().parse(result2).getAsJsonObject();
                        String msg = jsonObject.get("msg").getAsString();
                        Looper.prepare();
                        Toast.makeText(ChangePasswordActivity.this, msg, Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        Log.i("onFailure", e.getMessage());
                    }
                });


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePasswordActivity.this, PersonCenterActivity.class));
            }
        });


    }
}
