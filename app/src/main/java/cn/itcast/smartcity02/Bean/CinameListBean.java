package cn.itcast.smartcity02.Bean;

import java.util.List;


public class CinameListBean {

    private int total;
    private List<RowsBean> rows;
    private int code;
    private String msg;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
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







    public static class RowsBean {
        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private ParamsBean params;
        private int id;
        private String name;
        private String cover;
        private String province;
        private String city;
        private String area;
        private String address;
        private String score;
        private String tags;
        private String brand;
        private String distance;
        private String status;
        private String movieId;
        private String timesId;


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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getTimesId() {
            return timesId;
        }

        public void setTimesId(String timesId) {
            this.timesId = timesId;
        }

        public static class ParamsBean {
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "searchValue='" + searchValue + '\'' +
                    ", createBy='" + createBy + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy='" + updateBy + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", remark='" + remark + '\'' +
                    ", params=" + params +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", cover='" + cover + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", area='" + area + '\'' +
                    ", address='" + address + '\'' +
                    ", score=" + score +
                    ", tags='" + tags + '\'' +
                    ", brand='" + brand + '\'' +
                    ", distance='" + distance + '\'' +
                    ", status='" + status + '\'' +
                    ", movieId='" + movieId + '\'' +
                    ", timesId='" + timesId + '\'' +
                    '}';
        }
    }
}
