package com.example.hasee.retrofitdoem;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 自定义的接口
 * 封装URL和请求数据
 */

public interface RequestServices {
    @GET("basil2style")
        //定义返回的方法，返回的响应体使用了ResponseBody
    Call<ResponseBody> getString();
}
