package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cn.itcast.smartcity02.Bean.HuodongcategoryBean;
import cn.itcast.smartcity02.R;


public class HuodongcategoryAdapter extends RecyclerView.Adapter<HuodongcategoryAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private List<HuodongcategoryBean.DatasBean> datasBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;


    public HuodongcategoryAdapter(Context context,List<HuodongcategoryBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.huodongcategory_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.hd_name.setText(datasBeans.get(position).getName());

    }

    // 返回Item总条数
    @Override
    public int getItemCount() {return datasBeans.size();}

    // 内部类，绑定控件
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView hd_name;

        private MyItemClickListener myListener;

        public MyViewHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);

            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            hd_name = view.findViewById(R.id.hd_name);
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


