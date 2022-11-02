package cn.itcast.smartcity02.Bean;

import java.util.List;

public class FindworkBean {

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }


    private int code;
    private int total;
    private String msg;
    private List<RowsBean> rows;



    public class RowsBean {


        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAdress() {
            return address;
        }

        public void setAdress(String adress) {
            this.address = adress;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getObligation() {
            return obligation;
        }

        public void setObligation(String obligation) {
            this.obligation = obligation;
        }

        public String getNeed() {
            return need;
        }

        public void setNeed(String need) {
            this.need = need;
        }

        private String contacts;
        private String name;
        private String address;
        private String salary;
        private String obligation;
        private String need;

        public RowsBean(String name, String adress, String salary, String contacts, String need, String obligation){
            this.name = name;
            this.address = adress;
            this.salary = salary;
            this.contacts = contacts;
            this.obligation = obligation;
            this.need = need;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "contacts='" + contacts + '\'' +
                    ", name='" + name + '\'' +
                    ", adress='" + address + '\'' +
                    ", salary='" + salary + '\'' +
                    ", obligation='" + obligation + '\'' +
                    ", need='" + need + '\'' +
                    '}';
        }
    }
}
