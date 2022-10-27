package cn.itcast.smartcity02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

import cn.itcast.smartcity02.Bean.AddressBean;
import cn.itcast.smartcity02.R;

public class AddressAdapter extends BaseAdapter {

    private LinkedList<AddressBean> mdata;
    private Context context;

    public AddressAdapter(LinkedList<AddressBean> mdata,Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.myaddress_item,parent,false);
        TextView tabel = (TextView) convertView.findViewById(R.id.tabel);
        TextView address = (TextView) convertView.findViewById(R.id.address_address_item);
        TextView name = (TextView) convertView.findViewById(R.id.name_address_item);
        TextView phone = (TextView) convertView.findViewById(R.id.address_phone_item);

        tabel.setText(mdata.get(position).getTabel());
        address.setText(mdata.get(position).getAddress());
        name.setText(mdata.get(position).getName());
        phone.setText(mdata.get(position).getPhone());

        return convertView;
    }
}
