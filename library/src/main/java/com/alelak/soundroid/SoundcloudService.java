package com.alelak.soundroid;

import com.alelak.soundroid.models.Comment;
import com.alelak.soundroid.models.Group;
import com.alelak.soundroid.models.Playlist;
import com.alelak.soundroid.models.Track;
import com.alelak.soundroid.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SoundcloudService {

    @GET("/users/{id}")
    Call<User> getUser(@Path("id") int id);

    @GET("/users/{id}/tracks")
    Call<List<Track>> getUserTracks(@Path("id") int id);

    @GET("/users/{id}/playlists")
    Call<List<Playlist>> getUserPlaylists(@Path("id") int id);

    @GET("/users/{id}/followings")
    Call<List<User>> getUserFollowings(@Path("id") int id);

    @GET("/users/{id}/followings/{following_id}")
    Call<User> getUserFollowing(@Path("id") int id, @Path("following_id") int following_id);

    @GET("/users/{id}/followers")
    Call<User> getUserFollowers(@Path("id") int id);

    @GET("/users/{id}/followers/{follower_id}")
    Call<User> getUserFollower(@Path("id") int id, @Path("follower_id") int follower_id);

    @GET("/users/{id}/comments")
    Call<List<Comment>> getUserComments(@Path("id") int id);

    @GET("/users/{id}/favorites")
    Call<List<Track>> getUserFavorites(@Path("id") int id);

    @GET("/users/{id}/favorites/{favorite_id}")
    Call<Track> getUSerFavorite(@Path("id") int id, @Path("favorite_id") int favorite_id);

    @GET("/users/{id}/groups")
    Call<Track> getUserGroups(@Path("id") int id);

    @GET("/users")
    Call<List<User>> searchUsers(@Query("q") String q, @Query("limit") int limit);

    @GET("/tracks/{id}")
    Call<Track> getTrack(@Path("id") int id);

    @GET("/tracks/{id}/comments")
    Call<List<Comment>> getTrackComments(@Path("id") int id);

    @GET("/tracks/{id}/comments/{comment_id}")
    Call<Comment> getTrackComment(@Path("id") int id, @Path("comment_id") int comment_id);

    @GET("/tracks/{id}/favoriters")
    Call<List<User>> getTrackFavoriters(@Path("id") int id);

    @GET("/tracks/{id}/favoriters/{favoriter_id}")
    Call<User> getTrackFavoriter(@Path("id") int id, @Path("favoriter_id") int favoriter_id);

    @GET("/tracks")
    Call<List<Track>> searchTracks(@Query("q") String q, @Query("limit") int limit);

    @GET("/tracks")
    Call<List<Track>> searchTracksByGenres(@Query("genres") String genres, @Query("limit") int limit);

    @GET("/tracks")
    Call<List<Track>> searchTracksByTags(@Query("tags") String tags, @Query("limit") int limit);

    @GET("/groups/{id}")
    Call<Group> getGroup(@Path("id") int id);

    @GET("/groups/{id}/moderators")
    Call<List<User>> getGroupModerators(@Path("id") int id);

    @GET("/groups/{id}/members")
    Call<List<User>> getGroupMembers(@Path("id") int id);

    @GET("/groups/{id}/contributors")
    Call<List<User>> getGroupContributors(@Path("id") int id);

    @GET("/groups/{id}/users")
    Call<List<User>> getGroupUsers(@Path("id") int id);

    @GET("/groups/{id}/tracks")
    Call<List<Track>> getGroupTracks(@Path("id") int id);

    @GET("/groups")
    Call<List<Group>> searchGroups(@Path("q") int q, @Query("limit") int limit);


    @GET("/comments/{id}")
    Call<Comment> getComment(@Path("id") int id);

    @GET("/playlists/{id}")
    Call<Playlist> getPlaylist(@Path("id") int id);

    @GET("/playlists")
    Call<List<Playlist>> searchPlayLists(@Query("q") String q, @Query("limit") int limit);

}
