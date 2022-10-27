package cn.itcast.smartcity02.Bean;

import java.util.List;

public class SalerlistBean {

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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


    public class RowsBean {

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

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getThemeId() {
            return themeId;
        }

        public void setThemeId(String themeId) {
            this.themeId = themeId;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSaleQuantity() {
            return saleQuantity;
        }

        public void setSaleQuantity(String saleQuantity) {
            this.saleQuantity = saleQuantity;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAvgCost() {
            return avgCost;
        }

        public void setAvgCost(String avgCost) {
            this.avgCost = avgCost;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getSaleNum3hour() {
            return saleNum3hour;
        }

        public void setSaleNum3hour(String saleNum3hour) {
            this.saleNum3hour = saleNum3hour;
        }

        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private ParamsBean params;
        private int id;
        private String name;
        private String adress;
        private String introduction;
        private String themeId;
        private String score;
        private String saleQuantity;
        private String deliveryTime;
        private String imgUrl;
        private String avgCost;
        private String other;
        private String recommend;
        private String distance;
        private String saleNum3hour;

        private class ParamsBean {
        }

        public RowsBean(String name, String score, String saleQuantity, String deliveryTime, String distance, String avgCost){
            this.name = name;
            this.score = score;
            this.saleQuantity = saleQuantity;
            this.deliveryTime = deliveryTime;
            this.distance = distance;
            this.avgCost = avgCost;
        }

        @Override
        public String toString(){
            return "RowsBean{" +
                    "name='" + name + '\'' +
                    ", score='" + score + '\'' +
                    ", saleQuantity='" + saleQuantity + '\'' +
                    ", deliveryTime=" + deliveryTime +
                    ", distance=" + distance +
                    ", avgCost=" + avgCost +
                    '}';
        }
    }
}
