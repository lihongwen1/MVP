package com.chenxuan.net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class CxResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CxResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BasicResponse basicResponse = gson.fromJson(response, BasicResponse.class);
        // 这里只是为了检测code是否!=1,所以只解析HttpStatus中的字段,因为只要code和message就可以了
        if (basicResponse.getErrorCode() != BasicResponseCode.SUCCESS) {
            value.close();
            //抛出一个RuntimeException, 这里抛出的异常会到subscribe的onError()方法中统一处理
            throw new ApiException(basicResponse.getErrorCode(), basicResponse.getErrorMsg());
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }
    }
}
