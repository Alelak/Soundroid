Soundroid
=========

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Soundroid-orange.svg?style=flat)](http://android-arsenal.com/details/1/2716)
[![Release](https://jitpack.io/v/Alelak/Soundroid.svg)](https://jitpack.io/#Alelak/Soundroid)

Unofficial SoundCloud API Wrapper for Android.

<img src="screenshots/screenshot.png" width="400">

## Initialize
```java
public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Soundroid.init(this, client_id);
  }
}
```
## Example

```java
  Call<List<Track>> call = Soundroid.getSoundcloudService().searchTracksByGenres("House", 20);
  call.enqueue(new Callback<List<Track>>() {
    @Override
    public void onResponse(Response<List<Track>> response) {
      if (response.isSuccess()) {
        tracks.addAll(response.body());
        songAdapter.notifyDataSetChanged();
      }

    }

    @Override
    public void onFailure(Throwable t) {
    }
  });
```

## Download
Gradle:

```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    // ... other dependencies here
    compile'com.github.Alelak:Soundroid:1.1'
}
```
