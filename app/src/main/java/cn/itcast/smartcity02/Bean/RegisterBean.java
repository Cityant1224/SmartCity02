package cn.itcast.smartcity02.Bean;

public class RegisterBean {
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;

    public RegisterBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String toString() {

        return "RegisterBean{" +
                "msg=" + msg + '\'' +
                ", + code=" + code ;

    }
}
