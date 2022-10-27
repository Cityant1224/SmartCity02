package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.itcast.smartcity02.Bean.Subway_lineBean;
import cn.itcast.smartcity02.R;

public class Subway_lineAdapter extends RecyclerView.Adapter<Subway_lineAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
   private List<Subway_lineBean.ParamsBean.DatasBean> datasbeans;
    private Context context;
    private MyItemClickListener myItemClickListener;

    public Subway_lineAdapter(Context context, List<Subway_lineBean.ParamsBean.DatasBean> datasbeans){
        this.datasbeans = datasbeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Subway_lineAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.zhandian, parent, false);
        MyViewHolder holder = new MyViewHolder(view,myItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Subway_lineAdapter.MyViewHolder holder, int position) {
        holder.zhandian_name.setText(datasbeans.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datasbeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView zhandian_name;
        private MyItemClickListener myItemClickListener;


        public MyViewHolder(@NonNull View view, MyItemClickListener myItemClickListener) {
            super(view);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);

            zhandian_name = view.findViewById(R.id.zhandian_name);
        }

        @Override
        public void onClick(View v) {
            if (myItemClickListener != null) {
                myItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }
    public interface MyItemClickListener {
            void onItemClick(View View, int position);

    }
    public void setMyItemClickListener(MyItemClickListener myItemClickListener){
            this.myItemClickListener = myItemClickListener;

    }
}
