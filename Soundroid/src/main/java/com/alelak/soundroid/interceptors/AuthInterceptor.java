package com.alelak.soundroid.interceptors;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    private final String client_id;

    public AuthInterceptor(final String client_id) {
        this.client_id = client_id;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl newHttpUrl = request.httpUrl().newBuilder().addQueryParameter("client_id", client_id).build();
        Request newRequest = request.newBuilder().url(newHttpUrl).addHeader("Accept", "application/json").build();
        return chain.proceed(newRequest);
    }
}
