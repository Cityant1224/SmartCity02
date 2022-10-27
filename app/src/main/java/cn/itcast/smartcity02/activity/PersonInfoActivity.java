package cn.itcast.smartcity02.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.itcast.smartcity02.R;

public class PersonInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        ImageView fanhui = findViewById(R.id.return_toPersoncenter);
        LinearLayout nicheng = findViewById(R.id.nicheng);
        TextView nicheng_text = findViewById(R.id.nicheng_text);
        LinearLayout youxiang = findViewById(R.id.youxiang);
        TextView youxiang_text = findViewById(R.id.youxiang_text);
        LinearLayout xingbie = findViewById(R.id.xingbie);
        LinearLayout number = findViewById(R.id.dianhuahaoma);
        TextView number_text = findViewById(R.id.dianhuahaoma_text);
        LinearLayout shenfenzhenghao = findViewById(R.id.shenfenzheng);
        TextView shenfenzhenghao_text = findViewById(R.id.shenfenzheng_text);
        Button save = findViewById(R.id.save);

        //修改昵称
        nicheng.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            //创建dialog
            final AlertDialog dialog = builder.create();
            //加载自定义dialog布局
            View dialogView = View.inflate(PersonInfoActivity.this, R.layout.edittext_nicheng, null);
            //将布局放入dialog
            dialog.setView(dialogView);
            //显示放入布局的dialog
            dialog.show();

            //实例化布局中的编辑框
            final EditText edit_nicheng = dialogView.findViewById(R.id.old_nicheng);
            //实例化布局中的取消按钮
            final Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);
            //实例化布局中的确定按钮
            final Button btn_sure = dialogView.findViewById(R.id.btn_sure);
            //将布局编辑框中的信息变成字符串类型 并实例化
            String new_nicheng = edit_nicheng.getText().toString();
            //确定按钮监听事件
            btn_sure.setOnClickListener(v -> {
                //将 个人信息界面的信息 改为 输入框中的信息
                nicheng_text.setText(new_nicheng);
                //关闭dialog
                dialog.dismiss();
            });
            //取消按钮监听事件，关闭dialog
            btn_cancel.setOnClickListener(v -> dialog.dismiss());
        });

        //修改邮箱
        youxiang.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            //创建dialog
            final AlertDialog dialog = builder.create();
            //加载自定义dialog布局
            View dialogView = View.inflate(PersonInfoActivity.this, R.layout.edittext_youxiang, null);
            //将布局放入dialog
            dialog.setView(dialogView);
            //显示放入布局的dialog
            dialog.show();

            //实例化布局中的编辑框
            final EditText edit_youxiang = dialogView.findViewById(R.id.old_youxiang);
            //实例化布局中的取消按钮
            final Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);
            //实例化布局中的确定按钮
            final Button btn_sure = dialogView.findViewById(R.id.btn_sure);
            //将布局编辑框中的信息变成字符串类型 并实例化
            String new_youxiang = edit_youxiang.getText().toString();
            //确定按钮监听事件
            btn_sure.setOnClickListener(v -> {
                //将 个人信息界面的信息 改为 输入框中的信息
                youxiang_text.setText(new_youxiang);
                //显示放入布局的dialog
                dialog.dismiss();
            });
            //取消按钮监听事件，关闭dialog
            btn_cancel.setOnClickListener(v -> dialog.dismiss());
        });

        //修改电话号码
        number.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            //创建dialog
            final AlertDialog dialog = builder.create();
            //加载自定义dialog布局
            View dialogView = View.inflate(PersonInfoActivity.this, R.layout.edittext_dianhuahaoma, null);
            //将布局放入dialog
            dialog.setView(dialogView);
            //显示放入布局的dialog
            dialog.show();

            //实例化布局中的编辑框
            final EditText edit_number = dialogView.findViewById(R.id.new_dianhuahaoma);
            //实例化布局中的取消按钮
            final Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);
            //实例化布局中的确定按钮
            final Button btn_sure = dialogView.findViewById(R.id.btn_sure);
            //将布局编辑框中的信息变成字符串类型 并实例化
            String new_dianhuahaoma = edit_number.getText().toString();
            //确定按钮监听事件
            btn_sure.setOnClickListener(v -> {
                //将 个人信息界面的信息 改为 输入框中的信息
                number_text.setText(new_dianhuahaoma);
                //显示放入布局的dialog
                dialog.dismiss();
            });
            //取消按钮监听事件，关闭dialog
            btn_cancel.setOnClickListener(v -> dialog.dismiss());
        });

        //修改身份证号
        shenfenzhenghao.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
            //创建dialog
            final AlertDialog dialog = builder.create();
            //加载自定义dialog布局
            View dialogView = View.inflate(PersonInfoActivity.this, R.layout.edittext_shenfenzhenghao, null);
            //将布局放入dialog
            dialog.setView(dialogView);
            //显示放入布局的dialog
            dialog.show();

            //实例化布局中的编辑框
            final EditText edit_shenfenzhenghao = dialogView.findViewById(R.id.old_shenfenzhenghao);
            //实例化布局中的取消按钮
            final Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);
            //实例化布局中的确定按钮
            final Button btn_sure = dialogView.findViewById(R.id.btn_sure);
            //将布局编辑框中的信息变成字符串类型 并实例化
            String new_shenfenzhenghao = edit_shenfenzhenghao.getText().toString();
            //确定按钮监听事件
            btn_sure.setOnClickListener(v -> {
                //将 个人信息界面的信息 改为 输入框中的信息
                shenfenzhenghao_text.setText(new_shenfenzhenghao);
                //关闭dialog
                dialog.dismiss();
            });
            //取消按钮监听事件，关闭dialog
            btn_cancel.setOnClickListener(v -> dialog.dismiss());
        });

        fanhui.setOnClickListener(v ->{
            Intent intent = new Intent(PersonInfoActivity.this,PersonCenterActivity.class);
            startActivity(intent);
        });

        //修改性别
        xingbie.setOnClickListener(view -> showSingleDialog());
    }

    //弹出一个单选对话框
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