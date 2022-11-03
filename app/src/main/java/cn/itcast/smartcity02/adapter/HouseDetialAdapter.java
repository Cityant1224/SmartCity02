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

import cn.itcast.smartcity02.Bean.HouseDetialBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class HouseDetialAdapter extends RecyclerView.Adapter<HouseDetialAdapter.MyHolder> {
    private HouseDetialBean.DataBean dataBeans;
    private Context mContext;
    private LayoutInflater layoutInflater;
    
    public HouseDetialAdapter(Context context, HouseDetialBean.DataBean databeans) {
        this.dataBeans  = databeans;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public HouseDetialAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.housedetial_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseDetialAdapter.MyHolder holder, int position) {
        holder.address.setText(dataBeans.getAddress());
        holder.title.setText(dataBeans.getSourceName());
        holder.phone.setText(dataBeans.getTel());
        holder.price.setText(dataBeans.getPrice());
        holder.type.setText(dataBeans.getHouseType());
        holder.mianji.setText(dataBeans.getAreaSize());
        holder.detial.setText(dataBeans.getDescription());
        String url = ApiConfig.BASE_API + dataBeans.getPic();
        Glide.with(mContext).load(url).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView price;
        private TextView mianji;
        private TextView type;
        private TextView title;
        private TextView address;
        private TextView phone;
        private TextView detial;
        private ImageView image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            price = (TextView) itemView.findViewById(R.id.price_housedetial_item);
            mianji = (TextView) itemView.findViewById(R.id.mianji_housedetial_item);
            type = (TextView) itemView.findViewById(R.id.type_housedetial_item);
            title = (TextView) itemView.findViewById(R.id.title_housedetial_item);
            address = (TextView) itemView.findViewById(R.id.address_housedetial_item);
            phone = (TextView) itemView.findViewById(R.id.phone_housedetial_item);
            detial = (TextView) itemView.findViewById(R.id.detial_housedetial_item);
            image = (ImageView) itemView.findViewById(R.id.img_housedetial_item);

        }
    }
}
