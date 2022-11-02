package cn.itcast.smartcity02.Bean;

import java.util.List;

public class HuodonglistBean {
    private int code;
    private int total;
    private String msg;
    private List<HuodonglistBean.RowsBean> rows;

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

    public List<RowsBean> getRowsbean() {
        return rows;
    }

    public void setRowsbean(List<RowsBean> rowsbean) {
        this.rows = rowsbean;
    }

    public class RowsBean {
        private String publishTime;
        private String name;
        private int id;
        private String content;
        private  String imgUrl;
        private String signupNum;
        private String likeNum;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getSignupNum() {
            return signupNum;
        }

        public void setSignupNum(String signupNum) {
            this.signupNum = signupNum;
        }

        public String getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(String likeNum) {
            this.likeNum = likeNum;
        }

        public RowsBean(String name, String imgUrl, String signuNum,String likeNum,String publishTime){
            this.name = name;
            this.imgUrl = imgUrl;
            this.signupNum = signuNum;
            this.likeNum = likeNum;
            this.publishTime = publishTime;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "name='" + name + '\'' +
                    "publishTime='" + publishTime + '\'' +
                    ", id=" + id +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", signupNum='" + signupNum + '\'' +
                    ", likeNum='" + likeNum + '\'' +
                    '}';
        }
    }
}
