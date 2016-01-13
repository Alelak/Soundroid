package com.alelak.soundroid.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private final String client_id;

    public AuthInterceptor(final String client_id) {
        this.client_id = client_id;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl newHttpUrl = request.url().newBuilder().addQueryParameter("client_id", client_id).build();
        Request newRequest = request.newBuilder().url(newHttpUrl).addHeader("Accept", "application/json").build();
        return chain.proceed(newRequest);
    }
}
