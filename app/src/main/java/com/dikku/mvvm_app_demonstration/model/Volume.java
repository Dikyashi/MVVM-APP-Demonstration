package com.dikku.mvvm_app_demonstration.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class Volume {

    @SerializedName("kind")
    private String kind;

    @SerializedName("id")
    private String id;

    @SerializedName("etag")
    private String etag;

    @SerializedName("selfLink")
    private String selfLink;

    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
