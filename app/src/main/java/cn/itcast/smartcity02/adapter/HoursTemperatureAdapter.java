package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.itcast.smartcity02.Bean.TianqiBean;
import cn.itcast.smartcity02.R;

public class HoursTemperatureAdapter extends RecyclerView.Adapter<HoursTemperatureAdapter.MyHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TianqiBean.DataBean.TodayBean.HoursBean> dataBeans;

    public HoursTemperatureAdapter(Context context, List<TianqiBean.DataBean.TodayBean.HoursBean> dataBeans){
        this.context = context;
        this.dataBeans = dataBeans;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public HoursTemperatureAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.now_temperature_item,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HoursTemperatureAdapter.MyHolder holder, int position) {
        holder.temperature.setText(dataBeans.get(position).getTemperature());
        holder.time.setText(dataBeans.get(position).getHour());

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView temperature;
        private TextView time;

        public MyHolder(@NonNull View view) {
            super(view);

            temperature = view.findViewById(R.id.img_now_temperature_item);
            time = view.findViewById(R.id.time_now_temperature_item);

        }
    }
}
