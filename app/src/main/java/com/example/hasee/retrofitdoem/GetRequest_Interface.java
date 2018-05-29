package com.example.hasee.retrofitdoem;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * get请求的接口
 */
public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    //getCall()是接受网络请求数据的方法
    Call<Translation> getCall();
}
