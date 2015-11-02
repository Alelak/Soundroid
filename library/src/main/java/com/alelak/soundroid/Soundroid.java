package com.alelak.soundroid;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alelak.soundroid.interceptors.AuthInterceptor;
import com.squareup.okhttp.OkHttpClient;

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
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new AuthInterceptor(Soundroid.client_id));
        final Retrofit retrofit = new Retrofit.Builder()
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
        if (soundcloudService == null)
            throw new IllegalStateException("You must initialize Soundroid before calling getSoundcloudService()");
        return soundcloudService;
    }
}
