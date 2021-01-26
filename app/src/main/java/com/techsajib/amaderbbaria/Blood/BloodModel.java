package com.techsajib.amaderbbaria.Blood;

public class BloodModel {

    private String url;
    private String emergency;
    private String details;
    private String name;
    private String number;
    private String bloodgroup;
    private String location;

    public BloodModel(String url, String emergency, String details, String name, String number, String bloodgroup, String location) {
        this.url = url;
        this.emergency = emergency;
        this.details = details;
        this.name = name;
        this.number = number;
        this.bloodgroup = bloodgroup;
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public String getEmergency() {
        return emergency;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getLocation() {
        return location;
    }
}
