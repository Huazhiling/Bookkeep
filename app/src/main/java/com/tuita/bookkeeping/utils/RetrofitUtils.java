package com.tuita.bookkeeping.utils;


import com.blankj.utilcode.util.LogUtils;
import com.tuita.bookkeeping.BuildConfig;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static final Object obj = new Object();
    private static final ConcurrentHashMap<String,Retrofit> map = new ConcurrentHashMap<>();

    private static Retrofit getInstance(String baseUrl){
        if(map.get(baseUrl) == null){
            synchronized (obj){
                if(map.get(baseUrl) == null){
                    map.put(baseUrl,createRetrofit(baseUrl));
                }
            }
        }
        return map.get(baseUrl);
    }

    private static Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(createOkhttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient createOkhttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(message ->
                        LogUtils.e("Retrofit",message)).setLevel(HttpLoggingInterceptor.Level.BODY))
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public static <T> T client(Class<T> clazz){
        return getInstance(BuildConfig.BASE_URL).create(clazz);
    }

    public static <T> T client(Class<T> clazz,String baseUrl){
        return getInstance(baseUrl).create(clazz);
    }

}
