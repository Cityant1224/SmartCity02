package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import cn.itcast.smartcity02.R;

public class ChengchekaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengcheka);

        ImageView fanhui = findViewById(R.id.fanhui_chengcheka);
        Button delete = findViewById(R.id.deldte_chengcheka);


        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChengchekaActivity.this, SubwayActivity.class));
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChengchekaActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                Toast.makeText(ChengchekaActivity.this, "当前您没有乘车卡", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ChengchekaActivity.this, GrainchengchekaActivity.class));
            }
        });
    }
}