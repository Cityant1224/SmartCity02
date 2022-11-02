package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.itcast.smartcity02.Bean.WorkdetialBean;
import cn.itcast.smartcity02.R;

public class WorkdetialAdapter extends RecyclerView.Adapter<WorkdetialAdapter.WorkHolder> {
    private Context context;
    private WorkdetialBean.DataBean rowsbean;
    private LayoutInflater layoutInflater;


    public WorkdetialAdapter(Context context,WorkdetialBean.DataBean rowsBeans){
        this.context = context;
        this.rowsbean = rowsBeans;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WorkdetialAdapter.WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.workdetial_item, parent, false);
        return new WorkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkdetialAdapter.WorkHolder holder, int position) {
        holder.salary.setText(rowsbean.getSalary());
        holder.obligation.setText(rowsbean.getObligation());
        holder.contacts.setText(rowsbean.getContacts());
        holder.address.setText(rowsbean.getAddress());
        holder.name.setText(rowsbean.getName());
        holder.need.setText(rowsbean.getNeed());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class WorkHolder extends RecyclerView.ViewHolder{
        private TextView contacts;
        private TextView name;
        private TextView obligation;
        private TextView address;
        private TextView need;
        private TextView salary;

        public WorkHolder(@NonNull View view) {
            super(view);

            salary = (TextView) view.findViewById(R.id.salary_work_detial);
            name = (TextView) view.findViewById(R.id.name_work_detial);
            address = (TextView) view.findViewById(R.id.address_work_detial);
            contacts = (TextView) view.findViewById(R.id.person_name_detial);
            obligation = (TextView) view.findViewById(R.id.zhize_detial);
            need = (TextView) view.findViewById(R.id.yaoqiu_detial);
        }
    }
}
