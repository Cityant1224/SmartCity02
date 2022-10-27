package cn.itcast.smartcity02.Bean;

public class NewsMainBean {
    public String newstitle;
    public Integer dianzan_image;
    public String dianzan_count;
    public Integer pinglun_image;
    public String pinglun_count;
    public String date;
    public Integer image;

    public NewsMainBean(String newstitle, int dianzan_image, String dianzan_count, int pinglun_image, String pinglun_count, String date, int image) {
        this.newstitle = newstitle;
        this.dianzan_image = dianzan_image;
        this.dianzan_count = dianzan_count;
        this.pinglun_image = pinglun_image;
        this.pinglun_count = pinglun_count;
        this.date = date;
        this.image = image;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public Integer getDianzan_image() {
        return dianzan_image;
    }

    public void setDianzan_image(Integer dianzan_image) {
        this.dianzan_image = dianzan_image;
    }

    public String getDianzan_count() {
        return dianzan_count;
    }

    public void setDianzan_count(String dianzan_count) {
        this.dianzan_count = dianzan_count;
    }

    public Integer getPinglun_image() {
        return pinglun_image;
    }

    public void setPinglun_image(Integer pinglun_image) {
        this.pinglun_image = pinglun_image;
    }

    public String getPinglun_count() {
        return pinglun_count;
    }

    public void setPinglun_count(String pinglun_count) {
        this.pinglun_count = pinglun_count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
