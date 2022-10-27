package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.itcast.smartcity02.Bean.AddressBean;
import cn.itcast.smartcity02.CreateAddressActivity;
import cn.itcast.smartcity02.EditAddressActivity;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.adapter.AddressAdapter;

public class MyAddressActivity extends AppCompatActivity {
//    private List<AddressBean> mData = null;
//    private Context mContext;
//    private AddressAdapter adapter = null;
//    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);


        //新增收货地址
        Button create_address = findViewById(R.id.create_address);
        create_address.setOnClickListener(v -> startActivity(new Intent(MyAddressActivity.this, CreateAddressActivity.class)));

        TextView tabel = findViewById(R.id.tabel);
        TextView address = findViewById(R.id.address_address_item);
        TextView name = findViewById(R.id.name_address_item);
        TextView phone = findViewById(R.id.address_phone_item);
        ImageView exit = findViewById(R.id.bianji);

        //从CreateAddress获取数据
        Intent intent = getIntent();
        String address_tabel = intent.getStringExtra("address_tabel");
        String address_address = intent.getStringExtra("address_datial");
        String address_name = intent.getStringExtra("address_name");
        String address_phone = intent.getStringExtra("address_phone");


//        mContext = MyAddressActivity.this;
//        listView = findViewById(R.id.address_listview);
//        mData = new LinkedList<AddressBean>();


        tabel.setText(address_tabel);
        address.setText(address_address);
        name.setText(address_name);
        phone.setText(address_phone);

        exit.setOnClickListener(v -> startActivity(new Intent(MyAddressActivity.this, EditAddressActivity.class)));
    }
}