package com.gzligo.ebizzcardstranslator.net.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Lwd on 2017/5/23.
 */

public class RetrofitHelper {
    private final OkHttpClient mClient;
    private Retrofit mRetrofit;
    private static RetrofitHelper helper;

    private RetrofitHelper(){
        mClient = OkHttpClientHelper.getInstance().getOkHttpClient();
    }

    public static RetrofitHelper getInstance(){
        if(helper==null){
            synchronized (RetrofitHelper.class){
                if(helper==null){
                    helper = new RetrofitHelper();
                }
            }
        }
        return helper;
    }

    //获取Retrofit对象
    public Retrofit getRetrofit(String url){
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(ArbitraryResponseBodyConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mClient)
                    .build();
        }
        return mRetrofit;
    }
}
