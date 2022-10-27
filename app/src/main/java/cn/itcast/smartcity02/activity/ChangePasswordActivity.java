package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.itcast.smartcity02.R;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        EditText old_pwd = findViewById(R.id.old_pwd);
        EditText new_pwd = findViewById(R.id.new_pwd);
        EditText sure_pwd = findViewById(R.id.sure_pwd);
        Button sure = findViewById(R.id.sure);
        Button cancel = findViewById(R.id.cancel);

        String old_password = old_pwd.getText().toString();
        String new_password = new_pwd.getText().toString();
        String sure_password = sure_pwd.getText().toString();
            sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!new_password.equals(sure_password)){
                        Toast.makeText(ChangePasswordActivity.this, "两次输入的新密码不一致", Toast.LENGTH_SHORT).show();
                    }else
                    if(new_password.equals("") & sure_password.equals("")) {
                        Toast.makeText(ChangePasswordActivity.this,"请输入新密码或确认密码", Toast.LENGTH_SHORT).show();
                    } else{
                    Toast.makeText(ChangePasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                     }
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ChangePasswordActivity.this, PersonCenterActivity.class));
                }
            });
            }
        }
