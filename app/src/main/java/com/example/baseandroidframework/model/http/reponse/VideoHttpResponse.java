package com.example.baseandroidframework.model.http.reponse;

/**
 * 功能: 消息响应类
 *
 * @author aserbao
 * @date : On 2020-01-13 11:23
 * @project:BaseAndroidFramework
 * @package:com.example.baseandroidframework.model.http.reponse
 */
public class VideoHttpResponse<T> {
    private int code;
    private String msg;
    T ret;

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

    public T getRet() {
        return ret;
    }

    public void setRet(T ret) {
        this.ret = ret;
    }
}
