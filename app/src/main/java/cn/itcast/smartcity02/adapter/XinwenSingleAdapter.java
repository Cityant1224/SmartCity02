package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.itcast.smartcity02.Bean.WorkdetialBean;
import cn.itcast.smartcity02.Bean.XinwenSingleBean;
import cn.itcast.smartcity02.R;
import cn.itcast.smartcity02.activity.WorkdetialActivity;
import cn.itcast.smartcity02.utils.ApiConfig;

public class XinwenSingleAdapter extends RecyclerView.Adapter<XinwenSingleAdapter.MyHolder> {
    private XinwenSingleBean.DataBean singlebean;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public XinwenSingleAdapter(Context context,XinwenSingleBean.DataBean bean){
        this.mContext = context;
        this.singlebean = bean;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.xinwen_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String text = singlebean.getContent();
        holder.content.setText(Html.fromHtml(text));
//        holder.content.setText(singlebean.getContent());
        holder.title.setText(singlebean.getTitle());
        String url = ApiConfig.BASE_API + singlebean.getCover();
        Glide.with(mContext).load(url).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private ImageView image;


        public MyHolder(@NonNull View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.xinwen_text_item);
            content = (TextView) view.findViewById(R.id.xinwen_content_item);
            image = (ImageView) view.findViewById(R.id.xinwen_img_item);
        }
    }
}
