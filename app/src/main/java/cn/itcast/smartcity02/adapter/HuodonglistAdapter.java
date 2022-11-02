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

import cn.itcast.smartcity02.Bean.HuodonglistBean;
import cn.itcast.smartcity02.Bean.ServiceBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;


public class HuodonglistAdapter extends RecyclerView.Adapter<HuodonglistAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private List<HuodonglistBean.RowsBean> rowsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;


    public HuodonglistAdapter(Context context,List<HuodonglistBean.RowsBean> rowsBeans) {
        this.rowsBeans = rowsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.huodonglist_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.baoming_hd.setText(rowsBeans.get(position).getSignupNum());
       holder.dianzan_hd.setText(rowsBeans.get(position).getLikeNum());
       holder.text_hd.setText(rowsBeans.get(position).getName());
       String url = ApiConfig.BASE_API + rowsBeans.get(position).getImgUrl();
       Glide.with(context).load(url).into(holder.img_hd);
    }

    // 返回Item总条数
    @Override
    public int getItemCount() {return rowsBeans.size();}

    // 内部类，绑定控件
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView text_hd;
        private TextView dianzan_hd;
        private TextView baoming_hd;
        private ImageView img_hd;

        private MyItemClickListener myListener;

        public MyViewHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);

            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            img_hd = view.findViewById(R.id.img_hd);
            text_hd = view.findViewById(R.id.text_hd);
            dianzan_hd = view.findViewById(R.id.dianzan_hd);
            baoming_hd = view.findViewById(R.id.baoming_hd);
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


