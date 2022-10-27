package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import cn.itcast.smartcity02.R;

public class YijianfankuiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yijianfankui);

        ImageView fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(v -> startActivity(new Intent(YijianfankuiActivity.this,PersonCenterActivity.class)));
    }
}