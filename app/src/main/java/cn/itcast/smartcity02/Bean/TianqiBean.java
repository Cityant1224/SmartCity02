package cn.itcast.smartcity02.Bean;

import java.util.List;


public class TianqiBean {

    private String msg;
    private Integer code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }







    public static class DataBean {
        private TodayBean today;
        private List<WeatherListBean> weatherList;

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public List<WeatherListBean> getWeatherList() {
            return weatherList;
        }

        public void setWeatherList(List<WeatherListBean> weatherList) {
            this.weatherList = weatherList;
        }






        public static class TodayBean {
            private List<HoursBean> hours;
            private AirQuantityBean airQuantity;
            private ComfortLevelBean comfortLevel;
            private TempInfoBean tempInfo;
            private String updateTime;
            private WindBean wind;

            public List<HoursBean> getHours() {
                return hours;
            }

            public void setHours(List<HoursBean> hours) {
                this.hours = hours;
            }

            public AirQuantityBean getAirQuantity() {
                return airQuantity;
            }

            public void setAirQuantity(AirQuantityBean airQuantity) {
                this.airQuantity = airQuantity;
            }

            public ComfortLevelBean getComfortLevel() {
                return comfortLevel;
            }

            public void setComfortLevel(ComfortLevelBean comfortLevel) {
                this.comfortLevel = comfortLevel;
            }

            public TempInfoBean getTempInfo() {
                return tempInfo;
            }

            public void setTempInfo(TempInfoBean tempInfo) {
                this.tempInfo = tempInfo;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }





            public static class AirQuantityBean {
                private Integer no2;
                private Integer pm25;
                private Integer o3;
                private Integer so2;
                private Integer pm10;
                private Double co;

                public Integer getNo2() {
                    return no2;
                }

                public void setNo2(Integer no2) {
                    this.no2 = no2;
                }

                public Integer getPm25() {
                    return pm25;
                }

                public void setPm25(Integer pm25) {
                    this.pm25 = pm25;
                }

                public Integer getO3() {
                    return o3;
                }

                public void setO3(Integer o3) {
                    this.o3 = o3;
                }

                public Integer getSo2() {
                    return so2;
                }

                public void setSo2(Integer so2) {
                    this.so2 = so2;
                }

                public Integer getPm10() {
                    return pm10;
                }

                public void setPm10(Integer pm10) {
                    this.pm10 = pm10;
                }

                public Double getCo() {
                    return co;
                }

                public void setCo(Double co) {
                    this.co = co;
                }
            }







            public static class ComfortLevelBean {
                private Integer uv;
                private String dressingIndex;
                private Integer humidity;
                private String coldIndex;
                private Integer apparentTemperature;
                private String uvIndex;
                private String washIndex;
                private String sportIndex;

                public Integer getUv() {
                    return uv;
                }

                public void setUv(Integer uv) {
                    this.uv = uv;
                }

                public String getDressingIndex() {
                    return dressingIndex;
                }

                public void setDressingIndex(String dressingIndex) {
                    this.dressingIndex = dressingIndex;
                }

                public Integer getHumidity() {
                    return humidity;
                }

                public void setHumidity(Integer humidity) {
                    this.humidity = humidity;
                }

                public String getColdIndex() {
                    return coldIndex;
                }

                public void setColdIndex(String coldIndex) {
                    this.coldIndex = coldIndex;
                }

                public Integer getApparentTemperature() {
                    return apparentTemperature;
                }

                public void setApparentTemperature(Integer apparentTemperature) {
                    this.apparentTemperature = apparentTemperature;
                }

                public String getUvIndex() {
                    return uvIndex;
                }

                public void setUvIndex(String uvIndex) {
                    this.uvIndex = uvIndex;
                }

                public String getWashIndex() {
                    return washIndex;
                }

                public void setWashIndex(String washIndex) {
                    this.washIndex = washIndex;
                }

                public String getSportIndex() {
                    return sportIndex;
                }

                public void setSportIndex(String sportIndex) {
                    this.sportIndex = sportIndex;
                }
            }







            public static class TempInfoBean {
                private String maxTemperature;
                private String uv;
                private String minTemperature;
                private String temperature;
                private String weather;
                private String humidity;
                private String air;
                private String apparentTemperature;
                private String label;
                private String day;

                public String getMaxTemperature() {
                    return maxTemperature;
                }

                public void setMaxTemperature(String maxTemperature) {
                    this.maxTemperature = maxTemperature;
                }

                public String getUv() {
                    return uv;
                }

                public void setUv(String uv) {
                    this.uv = uv;
                }

                public String getMinTemperature() {
                    return minTemperature;
                }

                public void setMinTemperature(String minTemperature) {
                    this.minTemperature = minTemperature;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getAir() {
                    return air;
                }

                public void setAir(String air) {
                    this.air = air;
                }

                public String getApparentTemperature() {
                    return apparentTemperature;
                }

                public void setApparentTemperature(String apparentTemperature) {
                    this.apparentTemperature = apparentTemperature;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }
            }









            public static class WindBean {
                private String windStrength;
                private String windDirection;

                public String getWindStrength() {

                    return windStrength;
                }

                public void setWindStrength(String windStrength) {
                    this.windStrength = windStrength;
                }

                public String getWindDirection() {
                    return windDirection;
                }

                public void setWindDirection(String windDirection) {
                    this.windDirection = windDirection;
                }
            }








            public class HoursBean {
                private String hour;
                private String weather;
                private String temperature;

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }









        public static class WeatherListBean {
            private String maxTemperature;
            private String uv;
            private String minTemperature;
            private String temperature;
            private String weather;
            private Integer humidity;
            private String air;
            private String apparentTemperature;
            private String label;
            private String day;

            public String getMaxTemperature() {
                return maxTemperature;
            }

            public void setMaxTemperature(String maxTemperature) {
                this.maxTemperature = maxTemperature;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getMinTemperature() {
                return minTemperature;
            }

            public void setMinTemperature(String minTemperature) {
                this.minTemperature = minTemperature;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public Integer getHumidity() {
                return humidity;
            }

            public void setHumidity(Integer humidity) {
                this.humidity = humidity;
            }

            public String getAir() {
                return air;
            }

            public void setAir(String air) {
                this.air = air;
            }

            public String getApparentTemperature() {
                return apparentTemperature;
            }

            public void setApparentTemperature(String apparentTemperature) {
                this.apparentTemperature = apparentTemperature;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }
        }
    }
}
