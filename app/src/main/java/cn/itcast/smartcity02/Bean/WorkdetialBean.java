package cn.itcast.smartcity02.Bean;


public class WorkdetialBean {

    private Integer code;
    private String msg;
    private DataBean data;
    private Integer total;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }




    public class DataBean {
        private Integer id;
        private Integer companyId;
        private Integer professionId;
        private String contacts;
        private String name;
        private String obligation;
        private String address;
        private String need;
        private String salary;
        private String companyName;
        private String professionName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getProfessionId() {
            return professionId;
        }

        public void setProfessionId(Integer professionId) {
            this.professionId = professionId;
        }

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

        public String getObligation() {
            return obligation;
        }

        public void setObligation(String obligation) {
            this.obligation = obligation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNeed() {
            return need;
        }

        public void setNeed(String need) {
            this.need = need;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getProfessionName() {
            return professionName;
        }

        public void setProfessionName(String professionName) {
            this.professionName = professionName;
        }




        public DataBean(String salary,String need,String address,String contacts,String obligation){
            this.address = address;
            this.need = need;
            this.contacts = contacts;
            this.salary = salary;
            this.obligation = obligation;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "id=" + id +
                    ", companyId=" + companyId +
                    ", professionId=" + professionId +
                    ", contacts='" + contacts + '\'' +
                    ", name='" + name + '\'' +
                    ", obligation='" + obligation + '\'' +
                    ", address='" + address + '\'' +
                    ", need='" + need + '\'' +
                    ", salary='" + salary + '\'' +
                    ", companyName='" + companyName + '\'' +
                    ", professionName='" + professionName + '\'' +
                    '}';
        }
    }
}
