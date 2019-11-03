package com.yaroshevich.trophies.model;

public class TrophyImage {

    private  String url;
    private  boolean isPreview;


    public TrophyImage(String url, boolean isPreview) {
        this.url = url;
        this.isPreview = isPreview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPreview() {
        return isPreview;
    }

    public void setPreview(boolean preview) {
        isPreview = preview;
    }
}
