package com.techsajib.amaderbbaria.Office;

public class OfficeModel {

    private String url;
    private String name;
    private String number;
    private String email;
    private String web;
    private String address;

    public OfficeModel(String url, String name, String number, String email, String web, String address) {
        this.url = url;
        this.name = name;
        this.number = number;
        this.email = email;
        this.web = web;
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getWeb() {
        return web;
    }

    public String getAddress() {
        return address;
    }
}
