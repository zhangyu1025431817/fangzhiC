package com.fangzhic.app.bean;

/**
 * Created by smacr on 2016/12/26.
 */

public class ApiModel<T> {
    private static final int SUCCEED_CODE = 0;
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public boolean isOk(){
        return code == SUCCEED_CODE;
    }
}
