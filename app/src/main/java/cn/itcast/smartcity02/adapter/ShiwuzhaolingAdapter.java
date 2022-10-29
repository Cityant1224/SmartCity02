package cn.itcast.smartcity02.adapter;

import java.util.List;

//            "/prod-api/profile/upload/image/2021/05/10/ed997996-d26c-43f3-b169-86330362c90f.png",

public class ShiwuzhaolingAdapter {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Databeans> getData() {
        return data;
    }

    public void setData(List<Databeans> data) {
        this.data = data;
    }

    private String code;
    private List<Databeans> data;




    private class Databeans {
        private String imgUrl;
        private String foundPlace;
        private String foundTime;
        private String claimPlace;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getFoundPlace() {
            return foundPlace;
        }

        public void setFoundPlace(String foundPlace) {
            this.foundPlace = foundPlace;
        }

        public String getFoundTime() {
            return foundTime;
        }

        public void setFoundTime(String foundTime) {
            this.foundTime = foundTime;
        }

        public String getClaimPlace() {
            return claimPlace;
        }

        public void setClaimPlace(String claimPlace) {
            this.claimPlace = claimPlace;
        }
    }
}
