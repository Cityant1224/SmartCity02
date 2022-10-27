package cn.itcast.smartcity02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import cn.itcast.smartcity02.activity.PersonInfoActivity;
import cn.itcast.smartcity02.activity.SubwayActivity;

public class GrainchengchekaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grainchengcheka);


        ImageView fanhui = findViewById(R.id.fanhui_grainchengcheka);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrainchengchekaActivity.this,SubwayActivity.class));
            }
        });


       Button chengcheka = findViewById(R.id.grain_chengcheka);
       chengcheka.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(GrainchengchekaActivity.this);
               //创建dialog
               final AlertDialog dialog = builder.create();
               //加载自定义dialog布局
               View dialogView = View.inflate(GrainchengchekaActivity.this, R.layout.activity_grainchengchekainformation2, null);
               //将布局放入dialog
               dialog.setView(dialogView);
               //显示放入布局的dialog
               dialog.show();

              EditText shenfenzheng_text = dialogView.findViewById(R.id.shenfenzheng_chengcheka);
              EditText shoujihao_text = dialogView.findViewById(R.id.shoujihao_chengcheka);
              EditText xingming_text = dialogView.findViewById(R.id.xingming_chengcheka);
              Button cancel = dialogView.findViewById(R.id.cancel_chengcheka);
              Button sure = dialogView.findViewById(R.id.sure_chengcheka);

              cancel.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      dialog.dismiss();
                  }
              });

              sure.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(GrainchengchekaActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                      dialog.dismiss();
                      addcard();
                      startActivity(new Intent(GrainchengchekaActivity.this,ChengchekaActivity.class));
                  }
              });
           }
       });

    }

    public void addcard(){
        Intent intent = new Intent(GrainchengchekaActivity.this,SubwayActivity.class);
        intent.putExtra("card1","card1");
        startActivity(intent);
    }
}