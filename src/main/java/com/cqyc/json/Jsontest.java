package com.cqyc.json;

import com.alibaba.fastjson.JSON;

/**
 * @author: CQYC
 * @date: 2024-06-07-13:23
 */
public class Jsontest {

    private boolean isActive;
    private boolean valid;

    private int id;

    public Jsontest() {
    }

    public Jsontest(boolean isActive, boolean valid, int id) {
        this.isActive = isActive;
        this.valid = valid;
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Jsontest jsontest = new Jsontest(true, false, 123);

        String jsonString = JSON.toJSONString(jsontest);
        System.out.println("jsonString = " + jsonString);
        //{"active":true,"id":123,"valid":false}这里会少一个is出现，因为computeGetters里面反射会计算出来把is去掉
    }
}
