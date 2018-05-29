package com.example.hasee.retrofitdoem;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Context mcontext = this;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initRetrofit();
        //request();
        requestpost();
    }
    private void initView(){
        textView = (TextView)findViewById(R.id.iv_show);
    }
    /**
     * 普通的请求
     */
//    private void initRetrofit(){
////        //获取Retrofit对象 设置地址
////        Retrofit retrofit = new Retrofit.Builder()
////                .baseUrl(Constant.URL_BASE)
////                .build();
////        RequestServices requestServices = retrofit.create(RequestServices.class);
////
////        Call<ResponseBody>call = requestServices.getString();
////
////        call.enqueue(new Callback<ResponseBody>() {
////            @Override
////            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
////                if (response.isSuccessful()){
////                    try {
////                        Log.d("233",response.body().toString());
////                        String result = response.body().string();
////                        textView.setText(result);
////                    }catch (IOException e){
////                        e.printStackTrace();
////                    }
////                }
////            }
////
////            @Override
////            public void onFailure(Call<ResponseBody> call, Throwable t) {
////                Log.d("233","失败");
////
////            }
////        });
////    }
/**
 * get金山词霸的
 */
//    public void request(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://fy.iciba.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        // 步骤5:创建 网络请求接口 的实例
//        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
//
//        Call<Translation> call = request_interface.getCall();
//
//        call.enqueue(new Callback<Translation>() {
//            @Override
//            public void onResponse(Call<Translation> call, Response<Translation> response) {
//                response.body().show();
//            }
//
//            @Override
//            public void onFailure(Call<Translation> call, Throwable t) {
//
//            }
//        });
//
//    }
    /**
     * 这个是post的
     */
    public void requestpost(){
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequest_Interface postRequestInterface = retrofit.create(PostRequest_Interface.class);

        Call<Translation1> call = postRequestInterface.getCall("i love you");

        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                String s = response.body().getTranslateResult().get(0).get(0).getTgt();
                textView.setText(s);
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {

            }
        });
    }
}
