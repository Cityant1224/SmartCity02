package cn.itcast.smartcity02.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import cn.itcast.smartcity02.Bean.LoginBean;
import cn.itcast.smartcity02.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class login extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_name;
    private EditText edt_psw;
    private Button btn_login;
    private Button btn_register;
    private String token;
    private Intent intent = null;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg==obtainMessage()) {
                Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edt_name = findViewById(R.id.username);
        edt_psw = findViewById(R.id.password);
        btn_login = findViewById(R.id.log_in);
        btn_register = findViewById(R.id.register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in:
                Login();
                break;
            case R.id.register:
                intent = new Intent(login.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void Login() {
        final String username =  edt_name.getText().toString().trim();
        final String password = edt_psw.getText().toString().trim();
        if (TextUtils.isEmpty(username )) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        } else if (true) {

            OkHttpClient client = new OkHttpClient();
            final JSONObject jsonObject = new JSONObject();

            try {//提交的参数
                jsonObject.put("username",username);
                jsonObject.put("password",password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MediaType mMediaType = MediaType.parse("application/json; charset=utf-8");
            final RequestBody requestBody = RequestBody.create(mMediaType, jsonObject.toString());
            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("http://124.93.196.45:10001/prod-api/api/login")
                    .build();
            okhttp3.Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //请求失败
                    Log.i("请求情况：", "请求失败");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        Log.i("响应状态", "响应成功");
                        final String loginBody = response.body().string();
                        Gson gson = new Gson();
                        LoginBean loginBean = gson.fromJson(loginBody, LoginBean.class);
                        String loginResultCode = loginBean.getCode();
                        Log.i("返回状态码", loginResultCode);
                        //响应成功,判断状态码
                        if (loginResultCode.equals("200")) {
                            Log.i("登录状态", "登录成功");
                            //获取token
                            token = loginBean.getToken();
                            // 把token保存到本地
                            SharedPreferences.Editor editor= getSharedPreferences("get_token", MODE_PRIVATE).edit();
                            editor.putString("token",token);
                            editor.putString("username",username);
                            editor.putString("password",password);
                            editor.apply();

                            //保存token
                            //登录成功，跳到个人中心界面
                            Message message = handler.obtainMessage();

                            message.obj = token;
                            handler.sendMessage(message);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),loginBody,Toast.LENGTH_LONG).show();
                                }
                            });
                            startActivity(new Intent(login.this, PersonCenterActivity.class));
                            finish();
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                }
            });
        }
    }
}


