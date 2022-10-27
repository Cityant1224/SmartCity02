package cn.itcast.smartcity02.Bean;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TakeawayCategoryBean{

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





    public static class RowsBean {

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

        public String getThemeName() {
            return themeName;
        }

        public void setThemeName(String themeName) {
            this.themeName = themeName;
        }

        public String getThemeDesc() {
            return themeDesc;
        }

        public void setThemeDesc(String themeDesc) {
            this.themeDesc = themeDesc;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private ParamsBean params;
        private int id;
        private String themeName;
        private String themeDesc;
        private String imgUrl;
        private String sort;

        private class ParamsBean {
        }


        private RowsBean(String themeName,String imgUrl){
            this.themeName = themeName;
            this.imgUrl = imgUrl;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "serviceName='" + themeName + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    '}';
        }
    }
}
