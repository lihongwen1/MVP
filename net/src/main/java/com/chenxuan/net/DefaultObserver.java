package com.chenxuan.net;

import android.net.ParseException;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author cx
 */
public abstract class DefaultObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            onException(ExceptionReason.PARSE_ERROR);
        } else if (e instanceof ApiException) {
            onFail(e.getMessage());
        } else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
        onFinish();
    }

    @Override
    public void onComplete() {

    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    protected abstract void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为success约定
     */
    private void onFail(String message) {
        ToastUtils.showShort(message);
    }

    private void onFinish() {

    }

    /**
     * 请求异常
     */
    private void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.showShort("连接错误");
                break;
            case CONNECT_TIMEOUT:
                ToastUtils.showShort("连接超时");
                break;
            case BAD_NETWORK:
                ToastUtils.showShort("网络错误");
                break;
            case PARSE_ERROR:
                ToastUtils.showShort("解析错误");
                break;
            case UNKNOWN_ERROR:
            default:
                ToastUtils.showShort("未知错误");
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    private enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}