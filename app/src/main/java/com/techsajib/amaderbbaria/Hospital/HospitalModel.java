package com.techsajib.amaderbbaria.Hospital;

public class HospitalModel {

    private String url;
    private String name;
    private String type;
    private String director;
    private String seat;
    private String doctor;
    private String number;
    private String email;
    private String address;
    private String details;

    public HospitalModel(String url, String name, String type, String director, String seat, String doctor, String number, String email, String address, String details) {
        this.url = url;
        this.name = name;
        this.type = type;
        this.director = director;
        this.seat = seat;
        this.doctor = doctor;
        this.number = number;
        this.email = email;
        this.address = address;
        this.details = details;
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

    public String getSeat() {
        return seat;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDetails() {
        return details;
    }
}
