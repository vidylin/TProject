package com.gzligo.ebizzcardstranslator.net.httputil;

import com.gzligo.ebizzcardstranslator.net.retrofit.Api;
import com.gzligo.ebizzcardstranslator.net.retrofit.RetrofitHelper;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Lwd on 2017/5/23.
 */

public class HttpUtils {
    private static Api api ;
    private static boolean isTestHost = false; //是否在测试环境下
    private static String TEST_HOST = "https://dev-app.hisir.net/app_server/";//这是e名片的测试服务器，暂时不能用
    private static String HOST = "https://srv-app-trans.hisir.net/translator_server/";//正式服务器
    private static String BASE_URL = isTestHost?TEST_HOST:HOST;

    //订阅事件
    private static<T> void setSubscriber(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //获取服务对象
    private static Api getService(){
        if(api==null) {
            api = RetrofitHelper.getInstance()
                    .getRetrofit(BASE_URL)
                    .create(Api.class);
        }
        return api;
    }

    //注册用户
    public static void requestRegister(String cc_code,String password,String phone, String nickname,String code, String portrait, Observer observer){
        setSubscriber(getService().register(cc_code,password,phone,nickname,code,portrait),observer);
    }

    //用户登录
    public static void requestLogin(String username,String password,String scope, String client_id,String grant_type,Observer observer){
        setSubscriber(getService().login(username,password,scope,client_id,grant_type),observer);
    }

}
