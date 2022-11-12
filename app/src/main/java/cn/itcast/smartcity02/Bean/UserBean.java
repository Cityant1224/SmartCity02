package cn.itcast.smartcity02.Bean;

public class UserBean {
    private String msg;
    private String token;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                ", code=" + code +
                '}';
    }
}
