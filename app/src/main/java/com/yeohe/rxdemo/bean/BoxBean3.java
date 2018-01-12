package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class BoxBean3 {

    /**
     * msg : success
     * result : [{"days":48,"name":"寻梦环游记","sum":119825.74,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":1673},{"days":31,"name":"帕丁顿熊2","sum":20476.07,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":246},{"days":27,"name":"芳华","sum":137714.7,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":5606},{"days":13,"name":"解忧杂货店","sum":21914.64,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":1114},{"days":20,"name":"妖猫传","sum":52200.99,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":1161},{"days":6,"name":"星球大战：最后的绝地武士","sum":21772.49,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":18276},{"days":13,"name":"前任3：再见前任","sum":149065.82,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":56474},{"days":13,"name":"妖铃铃","sum":35712.35,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":1589},{"days":13,"name":"二代妖精之今生有幸","sum":27740.92,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":2556},{"days":19,"name":"心理罪之城市之光","sum":22236.95,"weekendPeriod":"2018-01-05至2018-01-07","weekendSum":176}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultEntity> result;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        /**
         * days : 48
         * name : 寻梦环游记
         * sum : 119825.74
         * weekendPeriod : 2018-01-05至2018-01-07
         * weekendSum : 1673
         */

        private int days;
        private String name;
        private double sum;
        private String weekendPeriod;
        private int weekendSum;

        public void setDays(int days) {
            this.days = days;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public void setWeekendPeriod(String weekendPeriod) {
            this.weekendPeriod = weekendPeriod;
        }

        public void setWeekendSum(int weekendSum) {
            this.weekendSum = weekendSum;
        }

        public int getDays() {
            return days;
        }

        public String getName() {
            return name;
        }

        public double getSum() {
            return sum;
        }

        public String getWeekendPeriod() {
            return weekendPeriod;
        }

        public int getWeekendSum() {
            return weekendSum;
        }
    }
}
