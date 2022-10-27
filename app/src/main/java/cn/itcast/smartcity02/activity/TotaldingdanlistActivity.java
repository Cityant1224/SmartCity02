package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import cn.itcast.smartcity02.R;

public class TotaldingdanlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaldingdanlist);

        ImageView fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(v -> startActivity(new Intent(TotaldingdanlistActivity.this,PersonCenterActivity.class)));


    }
}