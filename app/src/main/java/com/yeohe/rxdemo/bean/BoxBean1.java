package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class BoxBean1 {


    /**
     * msg : success
     * result : [{"cur":109.22,"days":42,"name":"寻梦环游记","sum":117810.49},{"cur":24.47,"days":27,"name":"帕丁顿熊2","sum":20216.09},{"cur":66.28,"days":14,"name":"机器之血","sum":30128.71},{"cur":826.03,"days":21,"name":"芳华","sum":129556.81},{"cur":268.16,"days":7,"name":"解忧杂货店","sum":20194.48},{"cur":276.75,"days":14,"name":"妖猫传","sum":50394.58},{"cur":210.07,"days":0,"name":"星球大战：最后的绝地武士","sum":210.07},{"cur":5622.58,"days":7,"name":"前任3：再见前任","sum":67686.65},{"cur":7.77,"days":5,"name":"小猫巴克里","sum":955.67},{"cur":424.98,"days":7,"name":"妖铃铃","sum":33123.68},{"cur":491.68,"days":7,"name":"二代妖精之今生有幸","sum":23598.72},{"cur":52.61,"days":14,"name":"心理罪之城市之光","sum":21954.24}]
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
         * cur : 109.22
         * days : 42
         * name : 寻梦环游记
         * sum : 117810.49
         */

        private double cur;
        private int days;
        private String name;
        private double sum;

        public void setCur(double cur) {
            this.cur = cur;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public double getCur() {
            return cur;
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
    }
}
