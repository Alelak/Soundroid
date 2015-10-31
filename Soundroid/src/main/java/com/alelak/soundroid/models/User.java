package com.alelak.soundroid.models;

import com.google.gson.annotations.SerializedName;

/**
 * <a href="https://developers.soundcloud.com/docs/api/reference#users">HTTP API Reference</a>
 */
public class User {
    @SerializedName("id")
    public int id;
    @SerializedName("permalink")
    public String permalink;
    @SerializedName("username")
    public String username;
    @SerializedName("uri")
    public String uri;
    @SerializedName("permalink_url")
    public String permalink_url;
    @SerializedName("avatar_url")
    public String avatar_url;
    @SerializedName("country")
    public String country;
    @SerializedName("full_name")
    public String full_name;
    @SerializedName("city")
    public String city;
    @SerializedName("description")
    public String description;
    @SerializedName("discogs_name")
    public String discogs_name;
    @SerializedName("myspace_name")
    public String myspace_name;
    @SerializedName("website")
    public String website;
    @SerializedName("website_title")
    public String website_title;
    @SerializedName("online")
    public boolean online;
    @SerializedName("track_count")
    public int track_count;
    @SerializedName("playlist_count")
    public int playlist_count;
    @SerializedName("followers_count")
    public int followers_count;
    @SerializedName("followings_count")
    public int followings_count;
    @SerializedName("public_favorites_count")
    public int public_favorites_count;

}
