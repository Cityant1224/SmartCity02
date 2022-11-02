package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import cn.itcast.smartcity02.Bean.FindworkBean;
import cn.itcast.smartcity02.R;

public class FindworkAdapter extends RecyclerView.Adapter<FindworkAdapter.WorkHolder> {
    private LayoutInflater layoutInflater;
    private List<FindworkBean.RowsBean> datasBeans;
    private Context context;
    private MyItemClickListener listener;


    public FindworkAdapter(Context context, List<FindworkBean.RowsBean> rowsBeans){
        this.context = context;
        this.datasBeans = rowsBeans;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public FindworkAdapter.WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.findwork_item,parent,false);
        WorkHolder holder = new WorkHolder(view,listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FindworkAdapter.WorkHolder holder, int position) {
        holder.contacts.setText(datasBeans.get(position).getContacts());
        holder.name.setText(datasBeans.get(position).getName());
        holder.address.setText(datasBeans.get(position).getAdress());
        holder.salary.setText(datasBeans.get(position).getSalary());

    }

    @Override
    public int getItemCount() {
        return  datasBeans.size();
    }



    public class WorkHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView contacts;
        private TextView name;
        private TextView address;
        private TextView salary;


        private MyItemClickListener listener;
        public WorkHolder(@NonNull View itemView, MyItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);

            contacts = itemView.findViewById(R.id.contacts_work);
            name = itemView.findViewById(R.id.name_work);
            salary = itemView.findViewById(R.id.salary_work);
            address = itemView.findViewById(R.id.address_work);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemClick(v,getPosition());
            }
        }
    }
    public interface MyItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.listener = myItemClickListener;
    }
}
