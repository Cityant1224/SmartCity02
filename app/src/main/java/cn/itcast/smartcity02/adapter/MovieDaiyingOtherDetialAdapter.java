package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.itcast.smartcity02.Bean.MovieDaiyingDetialBean;
import cn.itcast.smartcity02.R;


public class MovieDaiyingOtherDetialAdapter extends RecyclerView.Adapter<MovieDaiyingOtherDetialAdapter.MyHolder> {
    private final MovieDaiyingDetialBean.DataBean dataBean;
    private final Context mContext;
    private final LayoutInflater layoutInflater;

    public MovieDaiyingOtherDetialAdapter(Context context, MovieDaiyingDetialBean.DataBean dataBean) {
        this.mContext = context;
        this.dataBean = dataBean;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.moviedaiyingotherdetial, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.introduce.setText(dataBean.getIntroduction());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView introduce;


        public MyHolder(@NonNull View view) {
            super(view);
            introduce = (TextView) view.findViewById(R.id.introduce_moviedaiyingother_item);
        }
    }

}
