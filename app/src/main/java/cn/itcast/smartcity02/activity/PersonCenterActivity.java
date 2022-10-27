package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.itcast.smartcity02.R;

public class PersonCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_center);

        LinearLayout dingdan_list = findViewById(R.id.dingdanliebiao);
        LinearLayout edit_password = findViewById(R.id.edit_password);
        LinearLayout yijianfankui = findViewById(R.id.yijianfankui);
        ImageView exit = findViewById(R.id.return_toMainActivity);
        Button edit_info = findViewById(R.id.edit_info);
        Button out = findViewById(R.id.login_exit);


        dingdan_list.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this, TotaldingdanlistActivity.class)));
        edit_password.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this, ChangePasswordActivity.class)));
        yijianfankui.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this, YijianfankuiActivity.class)));
        edit_info.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this,PersonInfoActivity.class)));
        out.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this, MainActivity.class)));
        exit.setOnClickListener(v -> startActivity(new Intent(PersonCenterActivity.this,MainActivity.class)));
    }
}