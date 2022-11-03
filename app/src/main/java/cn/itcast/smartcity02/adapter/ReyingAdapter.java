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
import cn.itcast.smartcity02.Bean.ReyingBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class ReyingAdapter extends RecyclerView.Adapter<ReyingAdapter.MyHolder> {
    private List<ReyingBean.RowsBean> rowsBeans;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private MyItemClickListener mItemClickListener;


    public ReyingAdapter(@NonNull Context context, List<ReyingBean.RowsBean> rowsBeans){
        this.rowsBeans = rowsBeans;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ReyingAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.reyingitem_movie, parent, false);
        MyHolder holder = new MyHolder(view,mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReyingAdapter.MyHolder holder, int position) {
        holder.name.setText(rowsBeans.get(position).getName());
        String url = ApiConfig.BASE_API + rowsBeans.get(position).getCover();
        Glide.with(mContext).load(url).into(holder.image);
        holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView image;

        private MyItemClickListener Listener;

        public MyHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);

            this.Listener = myItemClickListener;
            itemView.setOnClickListener(this);



            name = (TextView) itemView.findViewById(R.id.reying_name_item);
            image = (ImageView) itemView.findViewById(R.id.reying_img_item);
        }

        @Override
        public void onClick(View view) {
            if (Listener !=null ){
                Listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface MyItemClickListener{
        void onItemClick(View view,int position);
    }
    public void setmItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }
}
