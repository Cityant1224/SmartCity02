package cn.itcast.smartcity02.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;

import cn.itcast.smartcity02.Bean.UserBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class login extends AppCompatActivity {
    //设置发送格式
    public static final MediaType JSON = MediaType.parse("application/json;charset=UTF-8");
    //创建okhttp连接
    final OkHttpClient client = new OkHttpClient();
    //实例化控件
    private String urn, pwd;
    private EditText username, password;
    private Button denglu, zhuce;
    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String ReturnMessage = (String) msg.obj;
                final UserBean userbean = (UserBean) new Gson().fromJson(ReturnMessage, UserBean.class);
                final String AA = userbean.getMsg();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find控件
        username = (EditText) findViewById(R.id.yonghuming_edit);
        password = (EditText) findViewById(R.id.mima_edit);
        denglu = (Button) findViewById(R.id.denglu_edit);
        zhuce = (Button) findViewById(R.id.zhuce_edit);


        //设置登录监听
        denglu.setOnClickListener(v -> {
            urn = username.getText().toString().trim();
            pwd = password.getText().toString().trim();

            postRequest(urn, pwd);
        });
    }

    //请求方法（带参）
    public void postRequest(String username, String password) {
        String name = username;
        String pass = password;

        //放入json类型数据
        JSONObject json = new JSONObject();
        try {
            json.put("username", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("password", pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //发送请求
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(ApiConfig.BASE_API + "/prod-api/api/login")
                .post(body)
                .build();

        //建立新线程，更新UI
        new Thread(() -> {
            Response response = null;
            try {
                response = client.newCall(request).execute();
                //获取返回的结果
                String result2 = response.body().string();
                //获取获得的json中的对象
                JsonObject jsonObject = (JsonObject) new JsonParser().parse(result2).getAsJsonObject();
                int code = jsonObject.get("code").getAsInt();
                String msg = jsonObject.get("msg").getAsString();
                //判断与数据库中的数据是否相符
                if (code == 200) {
                    //相符即登录成功
                    startActivity(new Intent(login.this, MainActivity.class));
                    Looper.prepare();
                    Toast.makeText(login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                    finish();
                    //否则登录失败
                } else if (!msg.equals("操作成功")) {
                    Looper.prepare();
                    Toast.makeText(login.this, "登录失败,请检查用户名及密码是否正确", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}