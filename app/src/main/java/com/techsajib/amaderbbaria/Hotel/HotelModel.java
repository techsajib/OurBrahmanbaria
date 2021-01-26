package com.techsajib.amaderbbaria.Hotel;

public class HotelModel {

    private String url;
    private String name;
    private String type;
    private String director;
    private String number;
    private String address;
    private String service;

    public HotelModel(String url, String name, String type, String director, String number, String address, String service) {
        this.url = url;
        this.name = name;
        this.type = type;
        this.director = director;
        this.number = number;
        this.address = address;
        this.service = service;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDirector() {
        return director;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getService() {
        return service;
    }
}
