package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import cn.itcast.smartcity02.R;

public class ShiwuzhaolingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiwuzhaoling);

        Button swzl_btn = findViewById(R.id.shiwuzhaoling_button);
//        RecyclerView rcv = (RecyclerView) findViewById(R.id.shiwuzhaoling_recyclerview);

    }
}