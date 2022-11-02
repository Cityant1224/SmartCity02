package cn.itcast.smartcity02.Bean;

import java.util.List;

public class WorkdetialBean {
    private    String    msg;
    private    int    code;
    private    DataBean    data;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setData(DataBean data){
        this.data = data;
    }
    public DataBean getData(){
        return this.data;
    }




    /**
     * Copyright 2022 json.im
     **//*===========params===========*/

    private class Params {
    }

    /*===========data===========*/

    public class DataBean {
        private    String    searchValue;
        private    String    createBy;
        private    String    createTime;
        private    String    updateBy;
        private    String    updateTime;
        private    String    remark;
        private    Params    params;
        private    int    id;
        private    int    companyId;
        private    int    professionId;
        private    String    contacts;
        private    String    name;
        private    String    obligation;
        private    String    address;
        private    String    need;
        private    String    salary;
        private    String    companyName;
        private    String    professionName;

        public void setSearchValue(String searchValue){
            this.searchValue = searchValue;
        }
        public String getSearchValue(){
            return this.searchValue;
        }
        public void setCreateBy(String createBy){
            this.createBy = createBy;
        }
        public String getCreateBy(){
            return this.createBy;
        }
        public void setCreateTime(String createTime){
            this.createTime = createTime;
        }
        public String getCreateTime(){
            return this.createTime;
        }
        public void setUpdateBy(String updateBy){
            this.updateBy = updateBy;
        }
        public String getUpdateBy(){
            return this.updateBy;
        }
        public void setUpdateTime(String updateTime){
            this.updateTime = updateTime;
        }
        public String getUpdateTime(){
            return this.updateTime;
        }
        public void setRemark(String remark){
            this.remark = remark;
        }
        public String getRemark(){
            return this.remark;
        }
        public void setParams(Params params){
            this.params = params;
        }
        public Params getParams(){
            return this.params;
        }
        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCompanyId(int companyId){
            this.companyId = companyId;
        }
        public int getCompanyId(){
            return this.companyId;
        }
        public void setProfessionId(int professionId){
            this.professionId = professionId;
        }
        public int getProfessionId(){
            return this.professionId;
        }
        public void setContacts(String contacts){
            this.contacts = contacts;
        }
        public String getContacts(){
            return this.contacts;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setObligation(String obligation){
            this.obligation = obligation;
        }
        public String getObligation(){
            return this.obligation;
        }
        public void setAddress(String address){
            this.address = address;
        }
        public String getAddress(){
            return this.address;
        }
        public void setNeed(String need){
            this.need = need;
        }
        public String getNeed(){
            return this.need;
        }
        public void setSalary(String salary){
            this.salary = salary;
        }
        public String getSalary(){
            return this.salary;
        }
        public void setCompanyName(String companyName){
            this.companyName = companyName;
        }
        public String getCompanyName(){
            return this.companyName;
        }
        public void setProfessionName(String professionName){
            this.professionName = professionName;
        }
        public String getProfessionName(){
            return this.professionName;
        }


        public DataBean(String salary, String name,String need, String address, String obligation){
            this.name = name;
            this.need = need;
            this.address = address;
            this.salary = salary;
            this.obligation =obligation;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "searchValue='" + searchValue + '\'' +
                    ", createBy='" + createBy + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy='" + updateBy + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", remark='" + remark + '\'' +
                    ", params=" + params +
                    ", id=" + id +
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
