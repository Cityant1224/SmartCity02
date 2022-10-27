package cn.itcast.smartcity02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.username_register);
        EditText password = findViewById(R.id.password_register);
        Button register = findViewById(R.id.register_register);

        String urn = username.getText().toString();
        String pwd = password.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(urn)){
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else if(true){
                    OkHttpClient client = new OkHttpClient();
                    final JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username",urn);
                        jsonObject.put("password",pwd);
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
                                    final String logonbody = response.body().string();
                                    Gson gson = new Gson();

                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                                Log.i("请求情况","请求失败");
                            }
                        });
                    }
                }
            }
        });
    }
}