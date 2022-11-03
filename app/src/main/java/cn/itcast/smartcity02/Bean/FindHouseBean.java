package cn.itcast.smartcity02.Bean;

import java.util.List;


public class FindHouseBean {

    private Integer code;
    private String msg;
    private List<RowsBean> rows;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static class RowsBean {
        private Integer id;
        private String sourceName;
        private String address;
        private Integer areaSize;
        private String tel;
        private String price;
        private String houseType;
        private String pic;
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getAreaSize() {
            return areaSize;
        }

        public void setAreaSize(Integer areaSize) {
            this.areaSize = areaSize;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "id=" + id +
                    ", sourceName='" + sourceName + '\'' +
                    ", address='" + address + '\'' +
                    ", areaSize=" + areaSize +
                    ", tel='" + tel + '\'' +
                    ", price='" + price + '\'' +
                    ", houseType='" + houseType + '\'' +
                    ", pic='" + pic + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
