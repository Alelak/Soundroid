package com.alelak.soundroid.models;

import com.google.gson.annotations.SerializedName;

/**
 * <a href="https://developers.soundcloud.com/docs/api/reference#tracks">HTTP API Reference</a>
 */
public class Track {
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
    public String release;
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
    @SerializedName("state")
    public String state;
    @SerializedName("license")
    public String license;
    @SerializedName("track_type")
    public String track_type;
    @SerializedName("waveform_url")
    public String waveform_url;
    @SerializedName("download_url")
    public String download_url;
    @SerializedName("stream_url")
    public String stream_url;
    @SerializedName("video_url")
    public String video_url;
    @SerializedName("bpm")
    public int bpm;
    @SerializedName("commentable")
    public boolean commentable;
    @SerializedName("isrc")
    public String isrc;
    @SerializedName("key_signature")
    public String key_signature;
    @SerializedName("comment_count")
    public int comment_count;
    @SerializedName("download_count")
    public int download_count;
    @SerializedName("playback_count")
    public int playback_count;
    @SerializedName("favoritings_count")
    public int favoritings_count;
    @SerializedName("original_format")
    public String original_format;
    @SerializedName("original_content_size")
    public int original_content_size;

}
