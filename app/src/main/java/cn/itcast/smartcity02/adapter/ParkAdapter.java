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

import java.util.ArrayList;
import java.util.List;

import cn.itcast.smartcity02.Bean.ParkBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.MyHolder>{
    private Context context;
    private List<ParkBean.RowsData> rowsbean;
    private LayoutInflater layoutInflater;
    private MyItemClickListener myItemClickListener;


    public ParkAdapter(Context context, List<ParkBean.RowsData> rowsbean){
        this.context = context;
        this.rowsbean = rowsbean;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.park_item, parent, false);
        MyHolder holder = new MyHolder(view,myItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(rowsbean.get(position).getParkName());
        holder.rongliang.setText(rowsbean.get(position).getVacancy());
        holder.price.setText(rowsbean.get(position).getRates());
        String url = ApiConfig.BASE_API + rowsbean.get(position).getImgUrl();
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return rowsbean.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView rongliang;
        private TextView price;
        private ImageView image;
        private MyItemClickListener myItemClickListener;

        public MyHolder(@NonNull View view, MyItemClickListener myItemClickListener) {
            super(view);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.name_park_item);
            rongliang = itemView.findViewById(R.id.rongliang_park_item);
            price = itemView.findViewById(R.id.price_park_item);
            image = itemView.findViewById(R.id.img_park);
        }

        @Override
        public void onClick(View v) {
            if (myItemClickListener != null) {
                myItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
        public interface MyItemClickListener {
            void onItemClick(View v, int position);
    }
    public void setMyItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }
}
