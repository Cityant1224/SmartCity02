package cn.itcast.smartcity02.Bean;

public class XinwenSingleBean {
    private String msg;
    private int code;
    private int total;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public DataBean getDataBean() {
        return data;
    }

    public void setRows(DataBean data) {
        this.data = data;
    }


    public class DataBean {
        private String cover;
        private String title;
        private String content;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }





        public DataBean(String title, String content,String cover){
            this.title = title;
            this.content = content;
            this.cover = cover;

        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "cover='" + cover + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
