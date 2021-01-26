package com.techsajib.amaderbbaria.FamousPeople;

public class FamousPeopleModel {

    private String url;
    private String title;
    private String details;
    private String authorname;
    private String authorpicture;

    public FamousPeopleModel(String url, String title, String details, String authorname, String authorpicture) {
        this.url = url;
        this.title = title;
        this.details = details;
        this.authorname = authorname;
        this.authorpicture = authorpicture;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String getAuthorpicture() {
        return authorpicture;
    }
}
