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
import cn.itcast.smartcity02.Bean.PisaBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.utils.ApiConfig;

public class PisadianinformationAdapter extends RecyclerView.Adapter<PisadianinformationAdapter.PisadianinformationHolder> {
    private LayoutInflater layoutInflater;
    private List<PisaBean.DataBean> pisaBeans;
    private Context context;
    private MyItemClickListener myItemClickListener;

    public PisadianinformationAdapter(Context context, List<PisaBean.DataBean> pisaBeans){
        this.pisaBeans = pisaBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PisadianinformationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_shipin, parent, false);//pisadianinformation
        PisadianinformationHolder holder = new PisadianinformationHolder(view,myItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PisadianinformationHolder holder, int position) {
        holder.name.setText(pisaBeans.get(position).getName());
        holder.saleQuantity.setText(pisaBeans.get(position).getSaleQuantity());
        holder.price.setText(pisaBeans.get(position).getPrice());
        String url = ApiConfig.BASE_API + pisaBeans.get(position).getImgUrl();
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pisaBeans.size();
    }




    public class PisadianinformationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView image;
        private TextView name;
        private TextView saleQuantity;
        private TextView price;
        private MyItemClickListener myListener;

        public PisadianinformationHolder(@NonNull View view, MyItemClickListener myItemClickListener){
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);

            name = view.findViewById(R.id.name_pisa);
            saleQuantity = view.findViewById(R.id.xiaoliang_pisa);
            price = view.findViewById(R.id.price_pisa);
            image = view.findViewById(R.id.img_pisa);
        }

        @Override
        public void onClick(View v) {
            if (myListener != null){
                myListener.onItemClick(v,getPosition());
            }
        }
    }
    public interface MyItemClickListener{
        void onItemClick(View v,int position);
    }
    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}
