package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.util.Log;
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
import cn.itcast.smartcity02.Bean.SalerlistBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;


public class SalerlistAdapter extends RecyclerView.Adapter<SalerlistAdapter.SalerlistHolder> {
    private LayoutInflater layoutInflater;
    private List<SalerlistBean.RowsBean> salerlistBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;

    /**
     * 构造方法 传入参数
     * @param context
     * @param salerlistBeans
     */
    public SalerlistAdapter(Context context,List<SalerlistBean.RowsBean> salerlistBeans) {
        this.salerlistBeans = salerlistBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SalerlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.salerlist_item,parent,false);
        SalerlistHolder SalerlistHolder = new SalerlistHolder(view,mItemClickListener);
        return SalerlistHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull SalerlistHolder holder, int position) {
        holder.name.setText(salerlistBeans.get(position).getName());
        holder.score.setText(salerlistBeans.get(position).getScore());
        holder.quanlity.setText(salerlistBeans.get(position).getSaleQuantity());
        holder.delivertime.setText(salerlistBeans.get(position).getDeliveryTime());
        holder.distance.setText(salerlistBeans.get(position).getDistance());
        holder.avdprice.setText(salerlistBeans.get(position).getAvgCost());
        String url = ApiConfig.BASE_API + salerlistBeans.get(position).getImgUrl();
        Glide.with(context).load(url).into(holder.image);
    }

    // 返回Item总条数
    @Override
    public int getItemCount() {
        return salerlistBeans.size();
    }

    // 内部类，绑定控件
    public class SalerlistHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private ImageView image;
        private TextView score;
        private TextView quanlity;
        private TextView delivertime;
        private TextView distance;
        private TextView avdprice;
        private MyItemClickListener myListener;

        public SalerlistHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            name = view.findViewById(R.id.salerlist_title);
            image = view.findViewById(R.id.salerlist_img);
            score = view.findViewById(R.id.salerlist_score);
            quanlity = view.findViewById(R.id.salerlist_quanlity);
            delivertime = view.findViewById(R.id.salerlist_delivertime);
            distance = view.findViewById(R.id.salerlist_distance);
            avdprice = view.findViewById(R.id.salerlist_avgprice);
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


























//package cn.itcast.smartcity02.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.List;
//
//import cn.itcast.smartcity02.Bean.NewsBean;
//import cn.itcast.smartcity02.Bean.SalerlistBean;
//import cn.itcast.smartcity02.R;
//import cn.itcast.smartcity02.utils.ApiConfig;
//
//
//
//public class SalerlistAdapter extends RecyclerView.Adapter<SalerlistAdapter.SalerlistHolder> {
//    private LayoutInflater layoutInflater;
//    private List<SalerlistBean.RowsBean> salerlistBeans;
//    private Context context;
//    private MyItemClickListener mItemClickListener;
//
//
//    public SalerlistAdapter(Context context,List<SalerlistBean.RowsBean> salerlistBeans) {
//        this.salerlistBeans = salerlistBeans;
//        this.context = context;
//        layoutInflater = LayoutInflater.from(context);
//    }
//
//    @NonNull
//    @Override
//    public SalerlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = layoutInflater.inflate(R.layout.salerlist_item,parent,false);
//        SalerlistHolder salerlistHolder = new SalerlistHolder(view,mItemClickListener);
//        return salerlistHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SalerlistAdapter.SalerlistHolder holder, int position) {
//        
//    }
//    
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//
//    public interface SalerlistHolder {
//    }
//}
//
//    // 内部类，绑定控件
//    class SalerlistHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private TextView name;
//        private ImageView image;
//        private TextView score;
//        private TextView quanlity;
//        private TextView delivertime;
//        private TextView distance;
//        private TextView avdprice;
//        private MyItemClickListener myListener;
//
//        public SalerlistHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
//            super(view);
//            this.myListener = myItemClickListener;
//            itemView.setOnClickListener(this);
//
//            name = view.findViewById(R.id.salerlist_title);
//            image = view.findViewById(R.id.salerlist_img);
//            score = view.findViewById(R.id.salerlist_score);
//            quanlity = view.findViewById(R.id.salerlist_quanlity);
//            delivertime = view.findViewById(R.id.salerlist_delivertime);
//            distance = view.findViewById(R.id.salerlist_distance);
//            avdprice = view.findViewById(R.id.salerlist_avgprice);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (myListener!=null) {
//                myListener.onItemClick(view,getPosition());
//            }
//        }
//    }
//
//    //创建一个回调接口
//    interface MyItemClickListener {
//        void onItemClick(View view,int position);
//    }
//
//
////    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
////    public void setItemClickListener(MyItemClickListener myItemClickListener){
////        this.mItemClickListener = myItemClickListener;
////    }
//
////}
//
//
