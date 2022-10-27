package cn.itcast.smartcity02.activity;


import static java.security.AccessController.getContext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.NewsMainBean;
import cn.itcast.smartcity02.R;


public class MainActivity extends AppCompatActivity {

    List<NewsMainBean> listData = new ArrayList<NewsMainBean>();    //界面数据
    private RecyclerView mRecyclerView;                     //控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.news_recycler); //没有此行会造成空指针
        //首页 新闻专栏item 的点击事件
        mRecyclerView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,NewsActivity.class));
        });
        initview();
    }

    //初始化界面
    public void initview() {
        initbanner();

        initservicelist();
        mRecyclerView = findViewById(R.id.news_recycler);
        //向组件设置布局格式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //向组件设置适配器
        mainNewsAdapter  mainNewsadapter= new mainNewsAdapter();
        mRecyclerView.setAdapter(mainNewsadapter);
        initnewslist();

        inittab();
    }

    //轮播图
    List<String> stringList = new ArrayList<String>();
    private Banner banner;
    public void initbanner() {
        banner = findViewById(R.id.banner);
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/e614cb7f-63b0-4cda-bf47-db286ea1b074.png");
        stringList.add("http://124.93.196.45:10001/prod-api/profile/upload/image/2021/05/06/242e06f7-9fb0-4e16-b197-206f999c98f2.png");
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

    //新闻专栏
    public void initnewslist(){
            listData = new ArrayList<NewsMainBean>();
            listData.add(new NewsMainBean("长视频斗不过",R.mipmap.news,"1",R.mipmap.news,"1","1",R.mipmap.news));
            listData.add(new NewsMainBean("长视频斗不过",R.mipmap.news,"1",R.mipmap.news,"1","1",R.mipmap.news));
            listData.add(new NewsMainBean("长视频斗不过",R.mipmap.news,"1",R.mipmap.news,"1","1",R.mipmap.news));
            listData.add(new NewsMainBean("长视频斗不过",R.mipmap.news,"1",R.mipmap.news,"1","1",R.mipmap.news));
    }

    class mainNewsAdapter extends RecyclerView.Adapter<mainNewsAdapter.mainNewsHolder>{

        @NonNull
        @Override
        public mainNewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //加载布局
            mainNewsHolder holder = new mainNewsHolder(LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.activity_newsmain,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull mainNewsHolder holder, int position) {
            NewsMainBean obj = listData.get(position);
            holder.newstitle.setText(obj.getNewstitle());
            holder.dianzan_count.setText(obj.getDianzan_count());
            holder.dianzan_image.setImageResource(obj.getDianzan_image());
            holder.pinglun_image.setImageResource(obj.getPinglun_image());
            holder.pinglun_count.setText(obj.getPinglun_count());
            holder.date.setText(obj.getDate());
            holder.image.setImageResource(obj.getImage());
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }
        class mainNewsHolder extends RecyclerView.ViewHolder{

            public TextView newstitle;
            public ImageView dianzan_image;
            public TextView dianzan_count;
            public ImageView pinglun_image;
            public TextView pinglun_count;
            public TextView date;
            public ImageView image;

            public mainNewsHolder(@NonNull View itemView) {
                super(itemView);
                newstitle = itemView.findViewById(R.id.new_title_main);
                dianzan_image = itemView.findViewById(R.id.dianzan_image_main);
                dianzan_count = itemView.findViewById(R.id.dianzan_count_main);
                pinglun_image = itemView.findViewById(R.id.pinglun_image_main);
                pinglun_count = itemView.findViewById(R.id.pinglun_count_main);
                date = itemView.findViewById(R.id.date_main);
                image = itemView.findViewById(R.id.image_main);
            }
        }
    }


    //服务列表
    public void initservicelist() {

    }


    //菜单条
    public void inittab() {
        //LinearLayout shouye = findViewById(R.id.shouye);
        LinearLayout xinwen = findViewById(R.id.xinwen);
        LinearLayout fuwu = findViewById(R.id.fuwu);
        LinearLayout huodong = findViewById(R.id.huodong);
        LinearLayout geren = findViewById(R.id.geren);


        xinwen.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,NewsActivity.class)));
        fuwu.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ServiceActivity.class)));
        huodong.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,HuodongActivity.class)));
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login.class));//PersonCenterActivity

            }
        });

        }
    }
