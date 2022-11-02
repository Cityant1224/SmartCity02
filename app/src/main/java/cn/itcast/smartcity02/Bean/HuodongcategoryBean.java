package cn.itcast.smartcity02.Bean;

import java.util.List;

public class HuodongcategoryBean {
    private int code;
    private String msg;
    private List<HuodongcategoryBean.DatasBean> data;

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

    public List<DatasBean> getData() {
        return data;
    }

    public void setData(List<DatasBean> data) {
        this.data = data;
    }

    public class DatasBean {
        private int id;
        private String name;

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

        public DatasBean(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
