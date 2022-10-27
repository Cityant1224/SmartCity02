package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.itcast.smartcity02.R;

public class DingdanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);

        //返回
        ImageView fanhui = findViewById(R.id.fanhui_dingdan);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DingdanActivity.this, PisadianinfomationActivity.class));
            }
        });

        //收货地址
        LinearLayout shouuhuodizhi = (LinearLayout) findViewById(R.id.shouhuodizhi);
        shouuhuodizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DingdanActivity.this, MyAddressActivity.class));
            }
        });
    }
}