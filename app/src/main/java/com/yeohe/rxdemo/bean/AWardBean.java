package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/16
 * creator:  LYS
 * 功能描述：
 */

public class AWardBean {

    /**
     * msg : success
     * result : {"awardDateTime":"2018-01-15 20:30","lotteryDetails":[{"awardNumber":2,"awardPrice":1.0E7,"awards":"一等奖"},{"awardNumber":2,"awardPrice":6000000,"awards":"一等奖","type":"追加"},{"awardNumber":41,"awardPrice":263162,"awards":"二等奖"},{"awardNumber":12,"awardPrice":157897,"awards":"二等奖","type":"追加"},{"awardNumber":613,"awardPrice":6669,"awards":"三等奖"},{"awardNumber":211,"awardPrice":4001,"awards":"三等奖","type":"追加"},{"awardNumber":21865,"awardPrice":200,"awards":"四等奖"},{"awardNumber":6862,"awardPrice":100,"awards":"四等奖","type":"追加"},{"awardNumber":428083,"awardPrice":10,"awards":"五等奖"},{"awardNumber":145006,"awardPrice":5,"awards":"五等奖","type":"追加"},{"awardNumber":4515350,"awardPrice":5,"awards":"六等奖"}],"lotteryNumber":["03","04","28","31","34","04","11"],"name":"大乐透","period":"18007","pool":4.50410267218E9,"sales":2.10430592E8}
     * retCode : 200
     */

    private String msg;
    private ResultEntity result;
    private String retCode;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getRetCode() {
        return retCode;
    }

    public static class ResultEntity {
        /**
         * awardDateTime : 2018-01-15 20:30
         * lotteryDetails : [{"awardNumber":2,"awardPrice":1.0E7,"awards":"一等奖"},{"awardNumber":2,"awardPrice":6000000,"awards":"一等奖","type":"追加"},{"awardNumber":41,"awardPrice":263162,"awards":"二等奖"},{"awardNumber":12,"awardPrice":157897,"awards":"二等奖","type":"追加"},{"awardNumber":613,"awardPrice":6669,"awards":"三等奖"},{"awardNumber":211,"awardPrice":4001,"awards":"三等奖","type":"追加"},{"awardNumber":21865,"awardPrice":200,"awards":"四等奖"},{"awardNumber":6862,"awardPrice":100,"awards":"四等奖","type":"追加"},{"awardNumber":428083,"awardPrice":10,"awards":"五等奖"},{"awardNumber":145006,"awardPrice":5,"awards":"五等奖","type":"追加"},{"awardNumber":4515350,"awardPrice":5,"awards":"六等奖"}]
         * lotteryNumber : ["03","04","28","31","34","04","11"]
         * name : 大乐透
         * period : 18007
         * pool : 4.50410267218E9
         * sales : 2.10430592E8
         */

        private String awardDateTime;
        private String name;
        private String period;
        private double pool;
        private double sales;
        private List<LotteryDetailsEntity> lotteryDetails;
        private List<String> lotteryNumber;

        public void setAwardDateTime(String awardDateTime) {
            this.awardDateTime = awardDateTime;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public void setPool(double pool) {
            this.pool = pool;
        }

        public void setSales(double sales) {
            this.sales = sales;
        }

        public void setLotteryDetails(List<LotteryDetailsEntity> lotteryDetails) {
            this.lotteryDetails = lotteryDetails;
        }

        public void setLotteryNumber(List<String> lotteryNumber) {
            this.lotteryNumber = lotteryNumber;
        }

        public String getAwardDateTime() {
            return awardDateTime;
        }

        public String getName() {
            return name;
        }

        public String getPeriod() {
            return period;
        }

        public double getPool() {
            return pool;
        }

        public double getSales() {
            return sales;
        }

        public List<LotteryDetailsEntity> getLotteryDetails() {
            return lotteryDetails;
        }

        public List<String> getLotteryNumber() {
            return lotteryNumber;
        }

        public static class LotteryDetailsEntity {
            /**
             * awardNumber : 2
             * awardPrice : 1.0E7
             * awards : 一等奖
             */

            private int awardNumber;
            private double awardPrice;
            private String awards;
            private String type;

            public void setType(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public void setAwardNumber(int awardNumber) {
                this.awardNumber = awardNumber;
            }

            public void setAwardPrice(double awardPrice) {
                this.awardPrice = awardPrice;
            }

            public void setAwards(String awards) {
                this.awards = awards;
            }

            public int getAwardNumber() {
                return awardNumber;
            }

            public double getAwardPrice() {
                return awardPrice;
            }

            public String getAwards() {
                return awards;
            }
        }
    }
}
