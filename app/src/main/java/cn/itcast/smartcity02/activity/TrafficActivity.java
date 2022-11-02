package cn.itcast.smartcity02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class TrafficActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_zhang);

        initbanner();


        ImageView fanhui = findViewById(R.id.fanhui_traffic);
        ImageView close = findViewById(R.id.close_traffic);
        TextView carmanager = findViewById(R.id.car_manager);
        TextView mydrvier = findViewById(R.id.my_driver);
        TextView chuli = findViewById(R.id.chuli);

    }

    //轮播图
    List<String> stringList = new ArrayList<String>();
    private Banner banner;

    public void initbanner(){
        banner = findViewById(R.id.weizhang_banner);
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/ff133289-6f6d-47c7-bf55-9bf6b43c1a48.jpeg");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/0b83479e-72d9-4342-93e8-750fea1a053d.jpeg");
        stringList.add(ApiConfig.BASE_API + "/prod-api/profile/upload/image/2021/05/05/003adf91-6721-4854-a48e-95fe1cd496f6.jpeg");
        banner.setAdapter(new BannerImageAdapter<String>(stringList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                        Glide.with(holder.itemView)
                                .load(data)
                                .into(holder.imageView);
                    }
                })
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this))
                .start();
    }
}