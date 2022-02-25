package com.dikku.mvvm_app_demonstration.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class VolumeImageLink {

    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("thumbnail")
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
