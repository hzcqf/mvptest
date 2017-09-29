package com.fan.base.http.constant;


public enum ResponseCode {
    SUCCESS(200, "成功"),
    AUTH_FAILURE(408, "账号验证异常，请重新登陆"),;

    private Integer value;
    private String text;

    ResponseCode(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
