package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;
import cn.itcast.smartcity02.Bean.NewsBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private LayoutInflater layoutInflater;
    private List<NewsBean.RowsBean> newsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;

    /**
     * 构造方法 传入参数
     * @param context
     * @param newsBeans
     */
    public NewsAdapter(Context context,List<NewsBean.RowsBean> newsBeans) {
        this.newsBeans = newsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.news_item,parent,false);
        NewsHolder newsHolder = new NewsHolder(view,mItemClickListener);
        return newsHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.title.setText(newsBeans.get(position).getTitle());
        holder.likeNum.setText(newsBeans.get(position).getLikeNum());
        holder.viewNum.setText(newsBeans.get(position).getViewNum());
        holder.date.setText(newsBeans.get(position).getPublishDate());
        String url = ApiConfig.BASE_API + newsBeans.get(position).getCover();
        Glide.with(context).load(url).into(holder.image);
    }

    // 返回Item总条数
    @Override
    public int getItemCount() {
        return newsBeans.size();
    }

    // 内部类，绑定控件
    public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView image;
        private TextView likeNum;
        private TextView viewNum;
        private TextView date;
        private MyItemClickListener myListener;

        public NewsHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            title = view.findViewById(R.id.news_title);
            image = view.findViewById(R.id.news_img);
            likeNum = view.findViewById(R.id.news_likeNumber);
            viewNum = view.findViewById(R.id.news_viewNumber);
            date = view.findViewById(R.id.news_date);
        }

        @Override
        public void onClick(View view) {
            if (myListener!=null) {
                myListener.onItemClick(view,getPosition());
            }
        }
    }

    //创建一个回调接口
    public interface MyItemClickListener {
        void onItemClick(View view,int position);
    }
    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.mItemClickListener = myItemClickListener;
    }

}


