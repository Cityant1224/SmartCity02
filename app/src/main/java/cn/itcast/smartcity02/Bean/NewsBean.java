package cn.itcast.smartcity02.Bean;

import java.util.List;

public class NewsBean {

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

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String appType;
        private Object subTitle;
        private String title;
        private String cover;
        private String content;
        private String likeNum;
        private String viewNum;
        private String imgUrl;
        private String pressCategory;
        private int isRecommend;
        private int userId;
        private int pressStatus;
        private String status;
        private String type;
        private String top;
        private String hot;
        private String publishDate;
        private Object tags;
        public int commentNum;


        public RowsBean(String createTime, String title, String cover, String likeNum, String viewNum) {
            this.createTime = createTime;
            this.title = title;
            this.cover = cover;
            this.likeNum = likeNum;
            this.viewNum = viewNum;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getPressCategory() {
            return pressCategory;
        }

        public void setPressCategory(String pressCategory) {
            this.pressCategory = pressCategory;
        }

        public int getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(int isRecommend) {
            this.isRecommend = isRecommend;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPressStatus() {
            return pressStatus;
        }

        public void setPressStatus(int pressStatus) {
            this.pressStatus = pressStatus;
        }

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
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

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getId(){return id;}

        public void setId(int id) {
            this.id = id;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

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

        public Object getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(Object subTitle) {
            this.subTitle = subTitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(String likeNum) {
            this.likeNum = likeNum;
        }

        public String getViewNum() {
            return viewNum;
        }

        public void setViewNum(String viewNum) {
            this.viewNum = viewNum;
        }

        public String getType() {

            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "createTime='" + createTime + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", likeNumber=" + likeNum +
                    ", viewsNumber=" + viewNum +
                    '}';
        }

        public static class ParamsBean {
        }
    }
}


