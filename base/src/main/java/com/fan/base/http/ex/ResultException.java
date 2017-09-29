package com.fan.base.http.ex;


public class ResultException extends RuntimeException {
    private static final String TAG = "ResultException";
    private int errCode = -1;

    public ResultException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
