package com.gzligo.ebizzcardstranslator.net.retrofit;

import com.gzligo.ebizzcardstranslator.persistence.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Lwd on 2017/5/23.
 */

public interface Api {

    //用户注册
    @FormUrlEncoded
    @POST("account/register")
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8;")
    Observable<String> register(@Field("cc_code") String cc_code, @Field("password") String password, @Field("phone") String phone,
                                @Field("nickname") String nickname, @Field("code") String code, @Field("portrait") String portrait);

    //用户登录
    @FormUrlEncoded
    @POST("oauth/token")
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8")
    Observable<LoginBean> login(@Field("username") String username, @Field("password") String password, @Field("scope") String scope,
                                @Field("client_id") String client_id, @Field("grant_type") String grant_type);

}
