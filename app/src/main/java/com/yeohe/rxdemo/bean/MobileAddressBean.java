package com.yeohe.rxdemo.bean;

/**
 * Created by Administrator on 2018/1/3.
 */

public class MobileAddressBean {


    /**
     * msg : success
     * result : {"city":"江门市","cityCode":"0750","mobileNumber":"1508813","operator":"移动150卡","province":"广东","zipCode":"529000"}
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
         * city : 江门市
         * cityCode : 0750
         * mobileNumber : 1508813
         * operator : 移动150卡
         * province : 广东
         * zipCode : 529000
         */

        private String city;
        private String cityCode;
        private String mobileNumber;
        private String operator;
        private String province;
        private String zipCode;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public String getCityCode() {
            return cityCode;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public String getOperator() {
            return operator;
        }

        public String getProvince() {
            return province;
        }

        public String getZipCode() {
            return zipCode;
        }
    }
}
