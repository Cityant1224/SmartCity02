package cn.itcast.smartcity02.Bean;

import android.widget.TextView;

public class AddressBean {
    String tabel;

    public String getTabel() {
        return tabel;
    }

    public void setTabel(String tabel) {
        this.tabel = tabel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String address;
    String name;
    String phone;
}
