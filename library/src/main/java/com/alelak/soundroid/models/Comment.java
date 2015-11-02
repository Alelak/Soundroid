package com.alelak.soundroid.models;

import com.google.gson.annotations.SerializedName;
/**
 * <a href="https://developers.soundcloud.com/docs/api/reference#comments">HTTP API Reference</a>
 */
public class Comment {
    @SerializedName("id")
    public int id;
    @SerializedName("uri")
    public String uri;
    @SerializedName("created_at")
    public String created_at;
    @SerializedName("body")
    public String body;
    @SerializedName("timestamp")
    public long timestamp;
    @SerializedName("user_id")
    public int user_id;
    @SerializedName("user")
    public User user;
    @SerializedName("track_id")
    public int track_id;
}
