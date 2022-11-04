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

import cn.itcast.smartcity02.Bean.CinameListBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class CinemaListAdapter extends RecyclerView.Adapter<CinemaListAdapter.MyHolder>{
    private List<CinameListBean.RowsBean> rowsBeans;
    private Context context;
    private LayoutInflater layoutInflater;
    private MyItemClickListener myItemClickListener;


    public CinemaListAdapter(Context context, List<CinameListBean.RowsBean> rows){
        this.context = context;
        this.rowsBeans = rows;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public CinemaListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.cinemalist_item, parent, false);
        MyHolder holder = new MyHolder(view,myItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaListAdapter.MyHolder holder, int position) {
        holder.name.setText(rowsBeans.get(position).getName());
        holder.address.setText(rowsBeans.get(position).getAddress());
        holder.distance.setText(rowsBeans.get(position).getDistance());
        holder.score.setText(rowsBeans.get(position).getScore());
        String url = ApiConfig.BASE_API + rowsBeans.get(position).getCover();
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView address;
        private TextView distance;
        private TextView score;
        private ImageView image;

        private MyItemClickListener myListener;

        public MyHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            name = (TextView) view.findViewById(R.id.name_cinamelist);
            address = (TextView) view.findViewById(R.id.address_cinamelist);
            distance = (TextView) view.findViewById(R.id.distance_cinamelist);
            score = (TextView) view.findViewById(R.id.score_cinamelist);
            image = (ImageView) view.findViewById(R.id.img_cinamelist);

        }

        @Override
        public void onClick(View view) {
            if (myListener !=null ){
                myListener.onItemClick(view,getPosition());
            }
        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}
