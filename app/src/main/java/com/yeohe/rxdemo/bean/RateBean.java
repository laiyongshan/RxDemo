package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/10
 * creator:  LYS
 * 功能描述：
 */

public class RateBean {


    /**
     * msg : success
     * result : [{"bank":"icbc","bankConversionPri":"652.3800","bankName":"工商银行","currencyCode":"USD","currencyName":"美元","date":"2018-01-10","fBuyPri":"651.0100","fSellPri":"653.7500","mBuyPri":"645.7900","mSellPri":"653.7500","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"778.4300","bankName":"工商银行","currencyCode":"EUR","currencyName":"欧元","date":"2018-01-10","fBuyPri":"775.5500","fSellPri":"781.3100","mBuyPri":"753.3700","mSellPri":"781.3100","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"83.3900","bankName":"工商银行","currencyCode":"HKD","currencyName":"港币","date":"2018-01-10","fBuyPri":"83.2200","fSellPri":"83.5600","mBuyPri":"82.5500","mSellPri":"83.5600","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"5.8218","bankName":"工商银行","currencyCode":"JPY","currencyName":"日元","date":"2018-01-10","fBuyPri":"5.8002","fSellPri":"5.8433","mBuyPri":"5.6343","mSellPri":"5.8433","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"882.0950","bankName":"工商银行","currencyCode":"GBP","currencyName":"英镑","date":"2018-01-10","fBuyPri":"878.8300","fSellPri":"885.3600","mBuyPri":"853.7000","mSellPri":"885.3600","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"510.3700","bankName":"工商银行","currencyCode":"AUD","currencyName":"澳大利亚元","date":"2018-01-10","fBuyPri":"508.4800","fSellPri":"512.2600","mBuyPri":"493.9400","mSellPri":"512.2600","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"523.4350","bankName":"工商银行","currencyCode":"CAD","currencyName":"加拿大元","date":"2018-01-10","fBuyPri":"521.5000","fSellPri":"525.3700","mBuyPri":"506.5800","mSellPri":"525.3700","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"20.2550","bankName":"工商银行","currencyCode":"THB","currencyName":"泰国铢","date":"2018-01-10","fBuyPri":"20.1800","fSellPri":"20.3300","mBuyPri":"19.5500","mSellPri":"20.3300","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"488.4950","bankName":"工商银行","currencyCode":"SGD","currencyName":"新加坡元","date":"2018-01-10","fBuyPri":"486.6900","fSellPri":"490.3000","mBuyPri":"472.7700","mSellPri":"490.3000","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"663.2550","bankName":"工商银行","currencyCode":"CHF","currencyName":"瑞士法郎","date":"2018-01-10","fBuyPri":"660.8000","fSellPri":"665.7100","mBuyPri":"641.9000","mSellPri":"665.7100","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"162.7400","bankName":"工商银行","currencyCode":"MYR","currencyName":"林吉特","date":"2018-01-10","fBuyPri":"162.1400","fSellPri":"163.3400","mSellPri":"163.3400","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"79.2850","bankName":"工商银行","currencyCode":"SEK","currencyName":"瑞典克朗","date":"2018-01-10","fBuyPri":"78.9900","fSellPri":"79.5800","mBuyPri":"76.7300","mSellPri":"79.5800","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"104.5400","bankName":"工商银行","currencyCode":"DKK","currencyName":"丹麦克朗","date":"2018-01-10","fBuyPri":"104.1500","fSellPri":"104.9300","mBuyPri":"101.1800","mSellPri":"104.9300","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"80.9300","bankName":"工商银行","currencyCode":"NOK","currencyName":"挪威克朗","date":"2018-01-10","fBuyPri":"80.6300","fSellPri":"81.2300","mBuyPri":"78.3200","mSellPri":"81.2300","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"467.9300","bankName":"工商银行","currencyCode":"NZD","currencyName":"新西兰元","date":"2018-01-10","fBuyPri":"466.2000","fSellPri":"469.6600","mBuyPri":"452.8700","mSellPri":"469.6600","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"11.4800","bankName":"工商银行","currencyCode":"RUB","currencyName":"卢布","date":"2018-01-10","fBuyPri":"11.4400","fSellPri":"11.5200","mBuyPri":"11.0800","mSellPri":"11.5200","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"12.9715","bankName":"工商银行","currencyCode":"PHP","currencyName":"菲律宾比索","date":"2018-01-10","fBuyPri":"12.4910","fSellPri":"13.4520","mBuyPri":"12.4910","mSellPri":"13.4520","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"80.9600","bankName":"工商银行","currencyCode":"MOP","currencyName":"澳门元","date":"2018-01-10","fBuyPri":"80.7900","fSellPri":"81.1300","mBuyPri":"80.1400","mSellPri":"81.1300","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"22.0950","bankName":"工商银行","currencyCode":"TWD","currencyName":"新台币","date":"2018-01-10","fBuyPri":"21.2800","fSellPri":"22.9100","mBuyPri":"21.2800","mSellPri":"22.9100","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"33.9300","bankName":"工商银行","currencyCode":"","currencyName":"","date":"2018-01-10","fBuyPri":"33.7200","fSellPri":"34.1400","mBuyPri":"32.7300","mSellPri":"34.1400","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"0.3060","bankName":"工商银行","currencyCode":"KRW","currencyName":"韩元","date":"2018-01-10","fSellPri":"0.6120","mBuyPri":"0.5901","mSellPri":"0.6120","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"201.8250","bankName":"工商银行","currencyCode":"BRL","currencyName":"巴西雷亚尔","date":"2018-01-10","fBuyPri":"191.7800","fSellPri":"211.8700","mBuyPri":"191.7800","mSellPri":"211.8700","time":"15:10:03"},{"bank":"icbc","bankConversionPri":"52.8550","bankName":"工商银行","currencyCode":"ZAR","currencyName":"南非兰特","date":"2018-01-10","fBuyPri":"52.6600","fSellPri":"53.0500","mBuyPri":"50.0900","mSellPri":"53.0500","time":"15:10:03"}]
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
         * bank : icbc
         * bankConversionPri : 652.3800
         * bankName : 工商银行
         * currencyCode : USD
         * currencyName : 美元
         * date : 2018-01-10
         * fBuyPri : 651.0100
         * fSellPri : 653.7500
         * mBuyPri : 645.7900
         * mSellPri : 653.7500
         * time : 15:10:03
         */

        private String bank;
        private String bankConversionPri;
        private String bankName;
        private String currencyCode;
        private String currencyName;
        private String date;
        private String fBuyPri;
        private String fSellPri;
        private String mBuyPri;
        private String mSellPri;
        private String time;

        public void setBank(String bank) {
            this.bank = bank;
        }

        public void setBankConversionPri(String bankConversionPri) {
            this.bankConversionPri = bankConversionPri;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public void setCurrencyName(String currencyName) {
            this.currencyName = currencyName;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setFBuyPri(String fBuyPri) {
            this.fBuyPri = fBuyPri;
        }

        public void setFSellPri(String fSellPri) {
            this.fSellPri = fSellPri;
        }

        public void setMBuyPri(String mBuyPri) {
            this.mBuyPri = mBuyPri;
        }

        public void setMSellPri(String mSellPri) {
            this.mSellPri = mSellPri;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getBank() {
            return bank;
        }

        public String getBankConversionPri() {
            return bankConversionPri;
        }

        public String getBankName() {
            return bankName;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public String getDate() {
            return date;
        }

        public String getFBuyPri() {
            return fBuyPri;
        }

        public String getFSellPri() {
            return fSellPri;
        }

        public String getMBuyPri() {
            return mBuyPri;
        }

        public String getMSellPri() {
            return mSellPri;
        }

        public String getTime() {
            return time;
        }
    }
}
