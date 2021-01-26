package com.techsajib.amaderbbaria.Organization;

public class OrganizationModel {

    private String url;
    private String title;
    private String details;

    public OrganizationModel(String url, String title, String details) {
        this.url = url;
        this.title = title;
        this.details = details;
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
}
