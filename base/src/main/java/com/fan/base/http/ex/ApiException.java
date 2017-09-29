package com.fan.base.http.ex;


import com.fan.base.http.constant.ResponseCode;

public class ApiException extends RuntimeException {
    private ResponseCode responseCode;

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public ApiException(ResponseCode responseCode) {
        super(responseCode.getText());
        this.responseCode = responseCode;
    }
}
