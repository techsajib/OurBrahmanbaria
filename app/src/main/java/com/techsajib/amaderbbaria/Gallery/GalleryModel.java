package com.techsajib.amaderbbaria.Gallery;

public class GalleryModel {

    private String url;
    private String authoricon;
    private String authorname;
    private String location;
    private String details;

    public GalleryModel(String url, String authoricon, String authorname, String location, String details) {
        this.url = url;
        this.authoricon = authoricon;
        this.authorname = authorname;
        this.location = location;
        this.details = details;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthoricon() {
        return authoricon;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String getLocation() {
        return location;
    }

    public String getDetails() {
        return details;
    }
}
