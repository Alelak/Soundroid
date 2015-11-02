package com.alelak.soundroid.models;

import com.google.gson.annotations.SerializedName;

/**
 * <a href="https://developers.soundcloud.com/docs/api/reference#playlists">HTTP API Reference</a>
 */
public class Playlist {
    @SerializedName("id")
    public int id;
    @SerializedName("created_at")
    public String created_at;
    @SerializedName("user_id")
    public int user_id;
    @SerializedName("user")
    public User user;
    @SerializedName("title")
    public String title;
    @SerializedName("permalink")
    public String permalink;
    @SerializedName("permalink_url")
    public String permalink_url;
    @SerializedName("uri")
    public String uri;
    @SerializedName("sharing")
    public String sharing;
    @SerializedName("embeddable_by")
    public String embeddable_by;
    @SerializedName("purchase_url")
    public String purchase_url;
    @SerializedName("artwork_url")
    public String artwork_url;
    @SerializedName("description")
    public String description;
    @SerializedName("label")
    public User label;
    @SerializedName("duration")
    public long duration;
    @SerializedName("genre")
    public String genre;
    @SerializedName("tag_list")
    public String tag_list;
    @SerializedName("label_id")
    public int label_id;
    @SerializedName("label_name")
    public String label_name;
    @SerializedName("release")
    public int release;
    @SerializedName("release_day")
    public int release_day;
    @SerializedName("release_month")
    public int release_month;
    @SerializedName("release_year")
    public int release_year;
    @SerializedName("streamable")
    public boolean streamable;
    @SerializedName("downloadable")
    public boolean downloadable;
    @SerializedName("ean")
    public String ean;
    @SerializedName("playlist_type")
    public String playlist_type;
}
