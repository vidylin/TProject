package com.gzligo.ebizzcardstranslator.net.retrofit;

import com.gzligo.ebizzcardstranslator.base.AppManager;

import java.io.File;

import okhttp3.Cache;

/**
 * Created by Lwd on 2017/5/23.
 */

public class CacheHelper {
    private Cache mCache;
    //设置缓存目录
    private static File cacheFile;
    private static long maxSize = 8*1024*1024;

    private CacheHelper(){
        //初始化 cacheFile
        cacheFile = new File(AppManager.get().getApplication().getCacheDir().getAbsolutePath(), "mycache");
    }

    private static CacheHelper helper;

    public static CacheHelper getInstance(){
        if(helper==null){
            synchronized (CacheHelper.class){
                if(helper==null){
                    helper = new CacheHelper();
                }
            }
        }
        return helper;
    }

    //返回缓存对象
    public Cache getCache(){
        if(mCache ==null)
            mCache = new Cache(cacheFile, maxSize);
        return mCache;
    }
}
