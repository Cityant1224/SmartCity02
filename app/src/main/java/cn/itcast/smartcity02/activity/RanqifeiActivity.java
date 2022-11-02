package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cn.itcast.smartcity02.R;

public class RanqifeiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranqifei);

        ImageView fanhui = fanhui = findViewById(R.id.fanhui_ranqifei);
        ImageView guanbi = guanbi = findViewById(R.id.guanbi_ranqifei);
        fanhui.setOnClickListener(v -> startActivity(new Intent(RanqifeiActivity.this,LivingPayActivity.class)));
        guanbi.setOnClickListener(v -> startActivity(new Intent(RanqifeiActivity.this,LivingPayActivity.class)));
        ImageView sousuo = findViewById(R.id.sousuo_ranqifei);
        sousuo.setOnClickListener(v ->{
            Toast.makeText(this, "暂无记录", Toast.LENGTH_SHORT).show();
        });

    }
}