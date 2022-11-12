package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.smartcity02.R;

public class ShipinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin);

        ImageView minus = findViewById(R.id.minus);
        ImageView add = findViewById(R.id.add);


        minus.setOnClickListener(new View.OnClickListener() {
            int num = 0;
            TextView shuliang = findViewById(R.id.shuliang);
            @Override
            public void onClick(View v) {
                if (num >= 0){
                    num -= 1;
                }else if (num < 0){
                    num = 0;
                }
                shuliang.setText(String.valueOf(num));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            int num2 = 0;
            TextView shuliang2 = findViewById(R.id.shuliang);
            @Override
            public void onClick(View v) {
                if (num2 >= 0){
                    num2 += 1;
                }
                shuliang2.setText(String.valueOf(num2));
            }
        });
    }
}