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

import cn.itcast.smartcity02.Bean.MovieDaiyingDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class MovieDaiyingDetialAdapter extends RecyclerView.Adapter<MovieDaiyingDetialAdapter.MyHolder> {
    private MovieDaiyingDetialBean.DataBean dataBeans;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private MyItemClickListener mItemClickListener;


    public MovieDaiyingDetialAdapter(@NonNull Context context, MovieDaiyingDetialBean.DataBean dataBeans){
        this.dataBeans = dataBeans;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public MovieDaiyingDetialAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.moviedaiyingdetial_item, parent, false);
        MyHolder holder = new MyHolder(view,mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDaiyingDetialAdapter.MyHolder holder, int position) {
        holder.name.setText(dataBeans.getName());
        holder.time.setText(dataBeans.getPlayDate());
        String url = ApiConfig.BASE_API + dataBeans.getCover();
        Glide.with(mContext).load(url).into(holder.image);
        holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView image;
        private TextView time;

        private MyItemClickListener Listener;

        public MyHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);

            this.Listener = myItemClickListener;
            itemView.setOnClickListener(this);

            time = (TextView) view.findViewById(R.id.publishTime_daiyingmovie_item);
            name = (TextView) itemView.findViewById(R.id.name_daiyingmovie_item);
            image = (ImageView) itemView.findViewById(R.id.img_daiyingmovie_item);
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
