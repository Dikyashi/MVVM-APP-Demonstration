package com.dikku.mvvm_app_demonstration.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class VolumeInfo {

    @SerializedName("title")
    private String title;

    @SerializedName("authors")
    private List<String> authors = null;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("description")
    private String description;

    @SerializedName("pageCount")
    private String pageCount;

    @SerializedName("printType")
    private String printType;

    @SerializedName("smallThumbnail")
    private VolumeImageLink smallThumbnail;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public VolumeImageLink getSmallThumbnail() {
        return smallThumbnail;
    }
}
