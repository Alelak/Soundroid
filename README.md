Soundroid
=========
  
Unofficial SoundCloud API Wrapper for Android.

# Usage

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

## License

```
Copyright 2015 Alladin El Akhrass

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

