package com.fan.base.http.modify;

import com.fan.base.http.constant.ResponseCode;
import com.fan.base.http.entity.ErrResponse;
import com.fan.base.http.entity.ResultResponse;
import com.fan.base.http.ex.ApiException;
import com.fan.base.http.ex.ResultException;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            //ResultResponse 只解析code字段进行约定异常处理
            ResultResponse resultResponse = gson.fromJson(response, ResultResponse.class);
            if (resultResponse.getErrorCode() == -1) {
                return gson.fromJson(response, type);
            } else if (resultResponse.getErrorCode() == ResponseCode.SUCCESS.getValue()) {
                return gson.fromJson(response, type);
            } else if (resultResponse.getErrorCode() == ResponseCode.AUTH_FAILURE.getValue()) {
                throw new ApiException(ResponseCode.AUTH_FAILURE);
            } else {
                //ErrResponse 将msg解析为异常消息文本
                ErrResponse errResponse = gson.fromJson(response, ErrResponse.class);
                throw new ResultException(resultResponse.getErrorCode(), errResponse.getErrorMessage());
            }
        } finally {
            value.close();
        }
    }
}
