package com.example.ero.showimage.models;

public class Model {

    private Integer album;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Integer getAlbum() {
        return album;
    }

    public void setAlbum(Integer album) {
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
