package cn.itcast.smartcity02.Bean;

import java.util.List;

public class PisaBean {

    private String msg;
    private List<DataBean> data;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }





    public class DataBean {


        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getStatues() {
            return statues;
        }

        public void setStatues(String statues) {
            this.statues = statues;
        }

        public String getSaleQuantity() {
            return saleQuantity;
        }

        public void setSaleQuantity(String saleQuantity) {
            this.saleQuantity = saleQuantity;
        }

        public String getFavorRate() {
            return favorRate;
        }

        public void setFavorRate(String favorRate) {
            this.favorRate = favorRate;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }


        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private ParamsBean params;
        private int id;
        private String categoryId;
        private String imgUrl;
        private String name;
        private String price;
        private String detail;
        private String statues;
        private String saleQuantity;
        private String favorRate;
        private String sellerId;

        private class ParamsBean{
        }

        public DataBean(String name,String saleQuantity,String price){
            this.name = name;
            this.saleQuantity = saleQuantity;
            this.price = price;
        }

        @Override
        public String toString(){
            return "RowsBean{" +
                    "name='" + name + '\'' +
                    ", score='" + saleQuantity + '\'' +
                    ", saleQuantity='" + price + '\'' +
                    '}';
        }
    }
}
