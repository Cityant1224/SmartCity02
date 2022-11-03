package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.itcast.smartcity02.Bean.MovieDetialBean;
import cn.itcast.smartcity02.R;

public class MovieotrherdetialAdapter extends RecyclerView.Adapter<MovieotrherdetialAdapter.MyHolder> {
    private final MovieDetialBean.DataBean dataBean;
    private final Context mContext;
    private final LayoutInflater layoutInflater;

    public MovieotrherdetialAdapter(Context context, MovieDetialBean.DataBean dataBean) {
        this.mContext = context;
        this.dataBean = dataBean;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MovieotrherdetialAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.movieotherdetial_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieotrherdetialAdapter.MyHolder holder, int position) {
        holder.pinglun.setText(dataBean.getRecommend());
        holder.likeNum.setText(dataBean.getLikeNum());
        holder.wantNum.setText(dataBean.getFavoriteNum());
        holder.introduce.setText(dataBean.getIntroduction());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView likeNum;
        private final TextView wantNum;
        private final TextView introduce;
        private final TextView pinglun;

        public MyHolder(@NonNull View view) {
            super(view);

            likeNum = (TextView) view.findViewById(R.id.likenum_movieother_item);
            wantNum = (TextView) view.findViewById(R.id.want_movieother_item);
            introduce = (TextView) view.findViewById(R.id.introduce_movieother_item);
            pinglun = (TextView) view.findViewById(R.id.pinglun_movieother_item);
        }
    }
}
