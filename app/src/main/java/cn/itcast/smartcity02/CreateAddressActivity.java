package cn.itcast.smartcity02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.itcast.smartcity02.activity.MyAddressActivity;

public class CreateAddressActivity extends AppCompatActivity {
    String tabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_address);

        EditText address_detial = findViewById(R.id.address_detial);
        RadioGroup radio_group = findViewById(R.id.radiogroup);
        RadioButton address_home = findViewById(R.id.address_home);
        RadioButton address_compney = findViewById(R.id.address_compney);
        RadioButton address_school = findViewById(R.id.address_school);
        EditText address_name = findViewById(R.id.address_name);
        EditText address_phone = findViewById(R.id.address_phone);
        Button save_address = findViewById(R.id.save_address);

        String addressdetail = address_detial.getText().toString();
        String addressname = address_name.getText().toString();
        String addressphone = address_phone.getText().toString();


        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == address_home.getId()) {
                    tabel = "家";
//                    Toast.makeText(CreateAddressActivity.this, "您选的是家", Toast.LENGTH_SHORT).show();
                }else if(checkedId == address_compney.getId()){
                    tabel = "公司";
//                    Toast.makeText(CreateAddressActivity.this, "您选的是公司" , Toast.LENGTH_SHORT).show();
                }else if(checkedId == address_school.getId()){
                    tabel = "学校";
//                    Toast.makeText(CreateAddressActivity.this, "您选的是学校" , Toast.LENGTH_SHORT).show();
                }
            }
        });


        //保存地址监听事件
        save_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //传递数据
                Intent intent = new Intent(CreateAddressActivity.this, MyAddressActivity.class);
                intent.putExtra("address_tabel",tabel);
                intent.putExtra("address_datial",addressdetail);
                intent.putExtra("address_name",addressname);
                intent.putExtra("address_phone",addressphone);
                startActivity(intent);
                Toast.makeText(CreateAddressActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}