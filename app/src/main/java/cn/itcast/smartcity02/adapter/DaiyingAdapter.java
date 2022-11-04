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

import cn.itcast.smartcity02.Bean.DaiyingBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class DaiyingAdapter extends RecyclerView.Adapter<DaiyingAdapter.MyHolder>{
    private List<DaiyingBean.RowsBean> rowsBean;
    private LayoutInflater layoutInflater;
    private Context context;
    private MyItemClickListener myItemClickListener;

    public DaiyingAdapter(Context context,List<DaiyingBean.RowsBean> rowsbean){
        this.context = context;
        this.rowsBean = rowsbean;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DaiyingAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.daiyingitem_movie, parent, false);
        MyHolder holder = new MyHolder(view,myItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DaiyingAdapter.MyHolder holder, int position) {
        holder.name.setText(rowsBean.get(position).getName());
        String url = ApiConfig.BASE_API + rowsBean.get(position).getCover();
        Glide.with(context).load(url).into(holder.image);
        holder.image.setScaleType(ImageView.ScaleType.FIT_XY);


    }

    @Override
    public int getItemCount() {
        return rowsBean.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private ImageView image;
        private MyItemClickListener myListener;

        public MyHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);

            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            name = (TextView) view.findViewById(R.id.daiying_name_item);
            image = (ImageView) view.findViewById(R.id.daiying_img_item);


        }

        @Override
        public void onClick(View v) {
            if (myListener!=null){
                myListener.onClick(v,getPosition());
            }
        }
    }

    public interface MyItemClickListener {
        void onClick(View view,int position);
    }

    public void setMyItemClickListener (MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}
