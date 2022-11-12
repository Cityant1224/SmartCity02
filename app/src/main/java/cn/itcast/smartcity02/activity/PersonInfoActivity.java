package cn.itcast.smartcity02.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.itcast.smartcity02.R;

public class PersonInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        LinearLayout nicheng = findViewById(R.id.nicheng);
        TextView nicheng_text = findViewById(R.id.nicheng_text);
        LinearLayout youxiang = findViewById(R.id.youxiang);
        TextView youxiang_text = findViewById(R.id.youxiang_text);
        LinearLayout xingbie = findViewById(R.id.xingbie);
        LinearLayout dianhuahaoma = findViewById(R.id.dianhuahaoma);
        TextView dianhuahaoma_text = findViewById(R.id.dianhuahaoma_text);
        LinearLayout shenfenzhenghao = findViewById(R.id.shenfenzheng);
        TextView shenfenzhenghao_text = findViewById(R.id.shenfenzheng_text);
        Button save = findViewById(R.id.save);

        //修改昵称
        nicheng.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            builder.setTitle("修改昵称");
            final View view_nicheng = View.inflate(PersonInfoActivity.this, R.layout.edittext_nicheng, null);
            //实例化布局中的编辑框
            EditText edit_nicheng = view_nicheng.findViewById(R.id.old_nicheng);
            builder.setView(view_nicheng);

            //确定按钮
            builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //将布局编辑框中的信息变成字符串类型 并实例化
                    String new_nicheng = edit_nicheng.getText().toString();
                    //将 个人信息界面的信息 改为 输入框中的信息
                    nicheng_text.setText(new_nicheng);
                    //关闭dialog
                    dialog.cancel();
                }
            });
            //取消按钮
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        });


        //修改邮箱
        youxiang.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            builder.setTitle("修改邮箱");
            final View view_youxiang = View.inflate(PersonInfoActivity.this, R.layout.edittext_youxiang, null);
            //实例化布局中的编辑框
            EditText edit_youxiang = view_youxiang.findViewById(R.id.old_youxiang);
            builder.setView(view_youxiang);

            //确定按钮
            builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //将布局编辑框中的信息变成字符串类型 并实例化
                    String new_youxiang = edit_youxiang.getText().toString();
                    //将 个人信息界面的信息 改为 输入框中的信息
                    youxiang_text.setText(new_youxiang);
                    //关闭dialog
                    dialog.cancel();
                }
            });
            //取消按钮
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        });


        //修改电话号码
        dianhuahaoma.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            builder.setTitle("修改电话号码");
            final View view_dianhuahaoma = View.inflate(PersonInfoActivity.this, R.layout.edittext_youxiang, null);
            //实例化布局中的编辑框
            EditText edit_dianhuahaoma = view_dianhuahaoma.findViewById(R.id.old_dianhuahaoma);
            builder.setView(view_dianhuahaoma);

            //确定按钮
            builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //将布局编辑框中的信息变成字符串类型 并实例化
                    String new_dianhuahaoma = edit_dianhuahaoma.getText().toString();
                    //将 个人信息界面的信息 改为 输入框中的信息
                    dianhuahaoma_text.setText(new_dianhuahaoma);
                    //关闭dialog
                    dialog.cancel();
                }
            });
            //取消按钮
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        });


        //修改身份证号
        shenfenzhenghao.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            builder.setTitle("修改身份证号");
            final View view_shenfenzhenghao = View.inflate(PersonInfoActivity.this, R.layout.edittext_nicheng, null);
            //实例化布局中的编辑框
            EditText edit_nicheng = view_shenfenzhenghao.findViewById(R.id.old_shenfenzhenghao);
            builder.setView(view_shenfenzhenghao);

            //确定按钮
            builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //将布局编辑框中的信息变成字符串类型 并实例化
                    String new_shenfenzhenghao = edit_nicheng.getText().toString();
                    //将 个人信息界面的信息 改为 输入框中的信息
                    shenfenzhenghao_text.setText(new_shenfenzhenghao);
                    //关闭dialog
                    dialog.cancel();
                }
            });
            //取消按钮
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        });

        //修改性别
        xingbie.setOnClickListener(view -> showSingleDialog());
    }


    //修改性别并弹出一个单选对话框
    private void showSingleDialog() {
        //构造对话框的实例
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择性别");
        final String[] items = {"男", "女"};
        builder.setSingleChoiceItems(items, 0, (dialog, which) -> {
            //[1]获取选择条目
            String item = items[which];
            TextView sex = findViewById(R.id.xingbie_text);
            sex.setText(item);
            dialog.dismiss();
        });
        //展示对话框
        builder.show();
    }


}