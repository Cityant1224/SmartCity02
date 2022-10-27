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
import cn.itcast.smartcity02.Bean.TakeawayCategoryBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;


public class TakeawayCategoryAdapter extends RecyclerView.Adapter<TakeawayCategoryAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private List<TakeawayCategoryBean.RowsBean> rowsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;

    /**
     * 构造方法 传入参数
     * @param context
     * @param rowsBeans
     */
    public TakeawayCategoryAdapter(Context context,List<TakeawayCategoryBean.RowsBean> rowsBeans) {
        this.rowsBeans = rowsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.takeaway_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.takeaway_name.setText(rowsBeans.get(position).getThemeName());
        String url = ApiConfig.BASE_API + rowsBeans.get(position).getImgUrl();
        Glide.with(context).load(url).into(holder.takeaway_img);
    }

    // 返回Item总条数
    @Override
    public int getItemCount() { return rowsBeans.size(); }

    // 内部类，绑定控件
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView takeaway_name;
        private ImageView takeaway_img;
        private MyItemClickListener myListener;

        public MyViewHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            takeaway_img = view.findViewById(R.id.takeaway_img);
            takeaway_name = view.findViewById(R.id.takeaway_name);
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