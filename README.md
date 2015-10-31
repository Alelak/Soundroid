Soundroid
=========
  
Unofficial SoundCloud API Wrapper for Android.

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
    public void onResponse(Response<List<Track>> response, Retrofit retrofit) {
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
