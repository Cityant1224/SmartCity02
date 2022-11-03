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

import cn.itcast.smartcity02.Bean.FindHouseBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class FindHouseAdapter extends RecyclerView.Adapter<FindHouseAdapter.MyHolder> {

    private List<FindHouseBean.RowsBean> rowsbean;
    private Context context;
    private LayoutInflater layoutInflater;
    private MyItemClickListener mItemClickListener;

    public FindHouseAdapter(Context context, List<FindHouseBean.RowsBean> rowsbean){
        this.context = context;
        this.rowsbean = rowsbean;
        layoutInflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public FindHouseAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.findhouse_item, parent, false);
        MyHolder holder = new MyHolder(view,mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FindHouseAdapter.MyHolder holder, int position) {
        holder.houseType.setText(rowsbean.get(position).getHouseType());
        holder.title.setText(rowsbean.get(position).getSourceName());
        holder.price.setText(rowsbean.get(position).getPrice());
        String url = ApiConfig.BASE_API + rowsbean.get(position).getPic();
        Glide.with(context).load(url).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return rowsbean.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView price;
        private TextView houseType;
        private ImageView image;
        private MyItemClickListener Listener;

        public MyHolder(@NonNull View view, MyItemClickListener mItemClickListener) {
            super(view);
            this.Listener = mItemClickListener;
            itemView.setOnClickListener(this);

            title = (TextView) view.findViewById(R.id.title_findhouse_item);
            price = (TextView) view.findViewById(R.id.price_findhouse_item);
            houseType = (TextView) view.findViewById(R.id.TF_findhouse_item);
            image = (ImageView) view.findViewById(R.id.img_findhouse_item);
        }

        @Override
        public void onClick(View view) {
            if (Listener != null){
                Listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.mItemClickListener = myItemClickListener;
    }
}
