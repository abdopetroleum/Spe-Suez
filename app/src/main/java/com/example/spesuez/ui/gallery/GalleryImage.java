package com.example.spesuez.ui.gallery;

import java.io.Serializable;

public class GalleryImage implements Serializable {
    private String name;
    private String info;
    private String url;
    private String span_count="6";

    public int getSpan_count() {
        return Integer.parseInt(span_count);
    }

    public void setSpan_count(String span_count) {
        this.span_count = span_count;
    }

    public GalleryImage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
