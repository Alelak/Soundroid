package com.alelak.soundroid;

import android.content.Context;

import com.alelak.soundroid.interceptors.AuthInterceptor;

import okhttp3.OkHttpClient;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class Soundroid {
    private static final String ENDPOINT = "https://api.soundcloud.com/";
    private static SoundcloudService soundcloudService;
    private static String client_id;


    /**
     * Initialize Soundroid
     *
     * @param context   Application context.
     * @param client_id Soundcloud client id.
     */
    public static void init(Context context, final String client_id) {
        if (context == null)
            throw new IllegalArgumentException("context cannot be null");
        if (client_id == null)
            throw new IllegalArgumentException("client_id cannot be null");

        Soundroid.client_id = client_id;
        final OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(new AuthInterceptor(Soundroid.client_id))
                .build();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ENDPOINT)
                .client(okHttpClient)
                .build();

        soundcloudService = retrofit.create(SoundcloudService.class);
    }

    public static String getClient_id() {
        return client_id;
    }

    public static SoundcloudService getSoundcloudService() {
        if (soundcloudService == null)
            throw new IllegalStateException("You must initialize Soundroid before calling getSoundcloudService()");
        return soundcloudService;
    }
}
