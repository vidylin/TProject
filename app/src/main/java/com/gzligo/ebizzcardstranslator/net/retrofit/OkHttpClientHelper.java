package com.gzligo.ebizzcardstranslator.net.retrofit;

import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Lwd on 2017/5/23.
 */

public class OkHttpClientHelper {
    private final Cache cache;
    private OkHttpClient mClient;
    private static OkHttpClientHelper clientHelper;
    private final  static  long TIMEOUT = 10000;  //超时时间

    private OkHttpClientHelper(){
        cache = CacheHelper.getInstance().getCache();
    }

    public static OkHttpClientHelper getInstance(){
        if(clientHelper==null){
            synchronized (OkHttpClientHelper.class){
                if(clientHelper==null){
                    clientHelper = new OkHttpClientHelper();
                }
            }
        }
        return clientHelper;
    }

    public OkHttpClient getOkHttpClient(){
        if(mClient ==null) {
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .cache(cache)
                    //添加请求头
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                           return chain.request().newBuilder().addHeader("Authorization","").build();
//                        }
//                    })
                    .build();
        }
        return mClient;
    }
}
