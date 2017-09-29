package com.fan.base.http.entity;


public class ResultResponse {
    private static final String TAG = "ResultResponse";
    private int errorCode = -1;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
