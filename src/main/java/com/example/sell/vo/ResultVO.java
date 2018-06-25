package com.example.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * http请求返回的最外层对象
 */
public class ResultVO<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体数据
    private T data;

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
