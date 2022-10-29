package cn.itcast.smartcity02.Bean;

import androidx.annotation.NonNull;

import java.util.List;

public class ParkBean {

    private int total;
    private List<RowsData> rows;
    private int code;
    private String msg;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsData> getRowsdata() {
        return rows;
    }

    public void setRowsdata(List<RowsData> rows) {
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


    @NonNull
    @Override
    public String toString() {
        return "ParkBean{" +
                "total=" + total +
                ", rowsdata=" + rows +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static class RowsData {
        private String parkName;
        private int id;
        private String vacancy;
        private String priceCaps;
        private String imgUrl;
        private String rates;
        private String address;
        private String distance;
        private String allPark;
        private String open;

        public String getParkName() {
            return parkName;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVacancy() {
            return vacancy;
        }

        public void setVacancy(String vacancy) {
            this.vacancy = vacancy;
        }

        public String getPriceCaps() {
            return priceCaps;
        }

        public void setPriceCaps(String priceCaps) {
            this.priceCaps = priceCaps;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getRates() {
            return rates;
        }

        public void setRates(String rates) {
            this.rates = rates;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getAllPark() {
            return allPark;
        }

        public void setAllPark(String allPark) {
            this.allPark = allPark;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }



        public RowsData(String parkName,String vacancy,String priceCaps,String imgUrl){
            this.parkName = parkName;
            this.vacancy = vacancy;
            this.priceCaps = priceCaps;
            this.imgUrl = imgUrl;
        }

        @Override
        public String toString() {
            return "RowsData{" +
                    "parkName='" + parkName + '\'' +
                    ", id=" + id +
                    ", vacancy='" + vacancy + '\'' +
                    ", priceCaps='" + priceCaps + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", rates='" + rates + '\'' +
                    ", address='" + address + '\'' +
                    ", distance='" + distance + '\'' +
                    ", allPark='" + allPark + '\'' +
                    ", open='" + open + '\'' +
                    '}';
        }
    }
}
