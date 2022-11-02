package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import cn.itcast.smartcity02.R;

public class DianfeiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianfei);

        ImageView fanhui = fanhui = findViewById(R.id.fanhui_dianfei);
        ImageView guanbi = guanbi = findViewById(R.id.guanbi_dianfei);
        fanhui.setOnClickListener(v -> startActivity(new Intent(DianfeiActivity.this,LivingPayActivity.class)));
        guanbi.setOnClickListener(v -> startActivity(new Intent(DianfeiActivity.this,LivingPayActivity.class)));
        ImageView sousuo = findViewById(R.id.sousuo_dianfei);
        sousuo.setOnClickListener(v ->{
            Toast.makeText(this, "暂无记录", Toast.LENGTH_SHORT).show();
        });
    }
}