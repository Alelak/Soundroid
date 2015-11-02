package com.alelak.soundroid.models;

import com.google.gson.annotations.SerializedName;
/**
 * <a href="https://developers.soundcloud.com/docs/api/reference#groups">HTTP API Reference</a>
 */
public class Group {
    @SerializedName("id")
    public int id;
    @SerializedName("uri")
    public String uri;
    @SerializedName("created_at")
    public String created_at;
    @SerializedName("permalink")
    public String permalink;
    @SerializedName("permalink_url")
    public String permalink_url;
    @SerializedName("artwork_url")
    public String artwork_url;
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
    @SerializedName("short_description")
    public String short_description;
    @SerializedName("creator")
    public User creator;
}
