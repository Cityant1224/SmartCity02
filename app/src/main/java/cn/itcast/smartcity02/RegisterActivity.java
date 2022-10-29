package cn.itcast.smartcity02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import cn.itcast.smartcity02.Bean.RegisterBean;
import cn.itcast.smartcity02.activity.login;
import cn.itcast.smartcity02.utils.ApiConfig;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

 @SuppressLint("HandlerLeak")
 Handler handler = new Handler(){
     @Override
     public void handleMessage(Message msg){
         super.handleMessage(msg);
         if(msg == obtainMessage()){
             Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
         }
     }
 };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.username_register);
        EditText password = findViewById(R.id.password_register);
        EditText phone = findViewById(R.id.phone_register);
        EditText sex = findViewById(R.id.sex_register);

        Button register = findViewById(R.id.register_register);

        String urn = username.getText().toString();
        String pwd = password.getText().toString();
        String phonenumber = phone.getText().toString();
        String xingbie = sex.getText().toString();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (TextUtils.isEmpty(urn)){
//                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
//                    return;
//                }else if(TextUtils.isEmpty(pwd)){
//                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
//                }else if(phonenumber.isEmpty()) {
//                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
//                } else if(true){
                    OkHttpClient client = new OkHttpClient();
                    final JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username",urn);
                        jsonObject.put("password",pwd);
                        jsonObject.put("phonenumber",phonenumber);
                        jsonObject.put("sex",xingbie);
                    }catch (JSONException e){
                        e.printStackTrace();

                        MediaType mMediaType = MediaType.parse("application/json;charset=UTF-8");
                       final RequestBody requestBody = RequestBody.create(mMediaType,jsonObject.toString());
                        Request request = new Request.Builder()
                                .post(requestBody)
                                .url(ApiConfig.BASE_API + "/prod-api/api/register")
                                .build();

                        Call call = client.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                if (response.isSuccessful()) {
                                    Log.i("响应状态","响应成功");
                                    final String registerbody = response.body().string();
                                    Gson gson = new Gson();
                                    RegisterBean registerBean = gson.fromJson(registerbody, RegisterBean.class);
                                    String code = registerBean.getCode();
                                    String msg = registerBean.getMsg();

                                    if (code.equals("200")){
                                        Message message = handler.obtainMessage();
                                        handler.sendMessage(message);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(RegisterActivity.this, registerbody, Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(RegisterActivity.this, login.class));
                                            }
                                        });
                                    }else{
                                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                                Log.i("请求情况","请求失败");
                            }
                        });
                    }
//                }
            }
        });
    }
}