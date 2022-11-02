//package cn.itcast.smartcity02.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//import cn.itcast.smartcity02.Bean.WorkdetialBean;
//import cn.itcast.smartcity02.R;
//
//public class WorkdetialAdapter extends RecyclerView.Adapter<WorkdetialAdapter.WorkHolder> {
//    private LayoutInflater layoutInflater;
//    private List<WorkdetialBean.DataBean> datasBeans;
//    private Context context;
//    private MyItemClickListener listener;
//
//
//    public WorkdetialAdapter(Context context, WorkdetialBean.DataBean rowsBeans){
//        this.context = context;
//        this.datasBeans = rowsBeans;
//        layoutInflater = LayoutInflater.from(context);
//    }
//
//
//    @NonNull
//    @Override
//    public WorkdetialAdapter.WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = layoutInflater.inflate(R.layout.workdetial_item,parent,false);
//        WorkHolder holder = new WorkHolder(view,listener);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull WorkdetialAdapter.WorkHolder holder, int position) {
//        holder.contacts.setText(datasBeans.get(position).getContacts());
//        holder.name.setText(datasBeans.get(position).getName());
//        holder.address.setText(datasBeans.get(position).getAddress());
//        holder.salary.setText(datasBeans.get(position).getSalary());
//        holder.need.setText(datasBeans.get(position).getNeed());
//        holder.obligation.setText(datasBeans.get(position).getObligation());
//    }
//
//    @Override
//    public int getItemCount() {
//        return  datasBeans.size();
//    }
//
//
//
//    public class WorkHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        private TextView contacts;
//        private TextView name;
//        private TextView address;
//        private TextView salary;
//        private TextView need;
//        private TextView obligation;
//
//        private MyItemClickListener listener;
//
//        public WorkHolder(@NonNull View itemView, MyItemClickListener listener) {
//            super(itemView);
//            this.listener = listener;
//            itemView.setOnClickListener(this);
//
//            contacts = itemView.findViewById(R.id.person_name_detial);
//            name = itemView.findViewById(R.id.name_work_detial);
//            salary = itemView.findViewById(R.id.salary_work_detial);
//            address = itemView.findViewById(R.id.address_work_detial);
//            need = itemView.findViewById(R.id.yaoqiu_detial);
//            obligation= itemView.findViewById(R.id.zhize_detial);
//        }
//
//        @Override
//        public void onClick(View v) {
//            if (listener != null){
//                listener.onItemClick(v,getPosition());
//            }
//        }
//    }
//    public interface MyItemClickListener {
//        void onItemClick(View v, int position);
//    }
//    public void setItemClickListener(MyItemClickListener myItemClickListener){
//        this.listener = myItemClickListener;
//    }
//}
