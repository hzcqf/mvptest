package com.fan.base.http.ex;


public class ToastException extends RuntimeException {

    public ToastException(String detailMessage) {
        super(detailMessage);
    }

    public ToastException() {
        super();
    }

    public ToastException(Throwable throwable) {
        super(throwable);
    }

    public ToastException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

}
