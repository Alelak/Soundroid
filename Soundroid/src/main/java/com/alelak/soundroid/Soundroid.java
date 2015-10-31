package com.alelak.soundroid;

import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class Soundroid {
    private static SoundcloudService soundcloudService;
    private static String client_id;

    /**
     * Initialize Soundroid
     *
     * @param context   Application context.
     * @param client_id Soundcloud client id.
     */
    public static void init(@NonNull Context context, @NonNull final String client_id) {
        Soundroid.client_id = client_id;
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl newHttpUrl = request.httpUrl().newBuilder().addQueryParameter("client_id", client_id).build();
                Request newRequest = request.newBuilder().url(newHttpUrl).addHeader("Accept", "application/json").build();
                return chain.proceed(newRequest);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.soundcloud.com/")
                .client(okHttpClient)
                .build();

        soundcloudService = retrofit.create(SoundcloudService.class);
    }

    public static String getClient_id() {
        return client_id;
    }
    
    public static SoundcloudService getSoundcloudService() {
        return soundcloudService;
    }
}
