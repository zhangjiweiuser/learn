package com.zhang.db.result;



/**
 * 响应结果实体
 */
public class ResponseResult<T> {
    /**
     * 响应编码。0-正常，小于0-系统级错误，大于0-业务级错误
     */
    private int code = 0;
    /**
     * 响应消息。code非0时，message非空
     */
    private String msg = "OK";
    /**
     * 响应结果
     */
    private T result;



    public static <T> ResponseResult<T> fail(String failMsg) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setMsg(failMsg);
        result.setCode(-1);
        return result;
    }

    public static <T> ResponseResult<T> fail(int code, String failMsg) {
        ResponseResult<T> rsres = new ResponseResult<T>();
        rsres.setMsg(failMsg);
        rsres.setCode(code);
        return rsres;
    }

    public static <T> ResponseResult<T> ok(T result) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setResult(result);
        return responseResult;
    }

    public boolean success() {
        return this.code == 0;
    }

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
