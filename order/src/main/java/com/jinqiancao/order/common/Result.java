package com.jinqiancao.order.common;

/**
 * @author jinqiancao
 * @date 2022/1/5 14:19
 */
public class Result<T> {

    private Integer code;
    private String msg;
    private T date;

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public static Result error(Integer code,String msg){
        return new Result(code,msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
