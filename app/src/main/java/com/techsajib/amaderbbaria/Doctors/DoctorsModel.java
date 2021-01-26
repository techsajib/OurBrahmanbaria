package com.techsajib.amaderbbaria.Doctors;

public class DoctorsModel {

    //datamodel constructor initialization
    private String url;
    private String name;
    private String title;
    private String specialist;
    private String chamber;
    private String time;
    private String number;
    private String address;

    public DoctorsModel(String url, String name, String title, String specialist, String chamber, String time, String number, String address) {
        this.url = url;
        this.name = name;
        this.title = title;
        this.specialist = specialist;
        this.chamber = chamber;
        this.time = time;
        this.number = number;
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String getChamber() {
        return chamber;
    }

    public String getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }
}
