package com.techsajib.amaderbbaria.FireService;

public class FireServiceModel {

    //datamodel constructor initialization
    private String name;
    private String number;
    private String time;
    private String web;
    private String address;
    private String service;

    public FireServiceModel(String name, String number, String time, String web, String address, String service) {
        this.name = name;
        this.number = number;
        this.time = time;
        this.web = web;
        this.address = address;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }

    public String getWeb() {
        return web;
    }

    public String getAddress() {
        return address;
    }

    public String getService() {
        return service;
    }
}
