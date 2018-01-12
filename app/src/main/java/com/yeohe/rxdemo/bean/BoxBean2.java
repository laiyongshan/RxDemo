package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class BoxBean2 {


    /**
     * msg : success
     * result : [{"days":48,"name":"寻梦环游记","sum":119825.74,"weekPeriod":"2018-01-01至2018-01-07","weekSum":4274},{"days":31,"name":"帕丁顿熊2","sum":20476.07,"weekPeriod":"2017-12-25至2017-12-31","weekSum":906},{"days":19,"name":"机器之血","sum":30431.1,"weekPeriod":"2018-01-01至2018-01-07","weekSum":1185},{"days":27,"name":"芳华","sum":137714.7,"weekPeriod":"2018-01-01至2018-01-07","weekSum":17041},{"days":13,"name":"解忧杂货店","sum":21914.64,"weekPeriod":"2018-01-01至2018-01-07","weekSum":6300},{"days":20,"name":"妖猫传","sum":52200.99,"weekPeriod":"2018-01-01至2018-01-07","weekSum":4874},{"days":6,"name":"星球大战：最后的绝地武士","sum":21772.49,"weekPeriod":"2018-01-01至2018-01-07","weekSum":18643},{"days":13,"name":"前任3：再见前任","sum":149065.82,"weekPeriod":"2018-01-01至2018-01-07","weekSum":100667},{"days":13,"name":"妖铃铃","sum":35712.35,"weekPeriod":"2018-01-01至2018-01-07","weekSum":10015},{"days":13,"name":"二代妖精之今生有幸","sum":27740.92,"weekPeriod":"2018-01-01至2018-01-07","weekSum":9716},{"days":19,"name":"心理罪之城市之光","sum":22236.95,"weekPeriod":"2018-01-01至2018-01-07","weekSum":782}]
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
         * weekPeriod : 2018-01-01至2018-01-07
         * weekSum : 4274
         */

        private int days;
        private String name;
        private double sum;
        private String weekPeriod;
        private int weekSum;

        public void setDays(int days) {
            this.days = days;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public void setWeekPeriod(String weekPeriod) {
            this.weekPeriod = weekPeriod;
        }

        public void setWeekSum(int weekSum) {
            this.weekSum = weekSum;
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

        public String getWeekPeriod() {
            return weekPeriod;
        }

        public int getWeekSum() {
            return weekSum;
        }
    }
}
