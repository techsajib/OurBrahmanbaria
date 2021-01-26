package com.techsajib.amaderbbaria.Tourist;

public class TouristModel {

    private String url;
    private String authoricon;
    private String authorname;
    private String title;
    private String description;

    public TouristModel(String url, String authoricon, String authorname, String title, String description) {
        this.url = url;
        this.authoricon = authoricon;
        this.authorname = authorname;
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
