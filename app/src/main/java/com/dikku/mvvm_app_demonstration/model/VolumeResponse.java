package com.dikku.mvvm_app_demonstration.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class VolumeResponse {

    @SerializedName("kind")
    private String kind;

    @SerializedName("totalItems")
    private int totalItems;

    @SerializedName("items")
    private List<Volume> items = null;

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }
}
