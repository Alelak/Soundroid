package com.alelak.soundroidsample;

import android.app.Application;

import com.alelak.soundroid.Soundroid;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Soundroid.init(this, "02gUJC0hH2ct1EGOcYXQIzRFU91c72Ea");
    }
}
