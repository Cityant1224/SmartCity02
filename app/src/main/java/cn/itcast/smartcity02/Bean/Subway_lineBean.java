package cn.itcast.smartcity02.Bean;

import java.util.List;

public class Subway_lineBean {

    private String msg;
    private int code;

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

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    private ParamsBean params;


    public class ParamsBean {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getStationsNumber() {
            return stationsNumber;
        }

        public void setStationsNumber(String stationsNumber) {
            this.stationsNumber = stationsNumber;
        }

        public String getKm() {
            return km;
        }

        public void setKm(String km) {
            this.km = km;
        }

        public String getRunStationsName() {
            return runStationsName;
        }

        public void setRunStationsName(String runStationsName) {
            this.runStationsName = runStationsName;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        private String name;
        private String first;
        private String end;
        private String startTime;
        private String endTime;
        private String cityId;
        private String stationsNumber;
        private String km;
        private String runStationsName;
        private List<DatasBean> datas;


        public class DatasBean {
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            private String name;
        }


        public String toString() {
            return "DatasBean{" +
                    "serviceName='" + name + '\'' + '}';
        }

    }
}