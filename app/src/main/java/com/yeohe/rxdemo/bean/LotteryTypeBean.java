package com.yeohe.rxdemo.bean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/16
 * creator:  LYS
 * 功能描述：
 */

public class LotteryTypeBean {

    /**
     * msg : success
     * result : ["双色球","大乐透","3D","排列3","排列5","七星彩","七乐彩","胜负彩","任选九","六场半全场","四场进球"]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<String> result;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public List<String> getResult() {
        return result;
    }
}
