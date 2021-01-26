package com.techsajib.amaderbbaria.MP;

public class MPModel {

    private String area;
    private String image;
    private String name;
    private String title;
    private String party;
    private String upozila;
    private String des;

    public MPModel(String area, String image, String name, String title, String party, String upozila, String des) {
        this.area = area;
        this.image = image;
        this.name = name;
        this.title = title;
        this.party = party;
        this.upozila = upozila;
        this.des = des;
    }

    public String getArea() {
        return area;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getParty() {
        return party;
    }

    public String getUpozila() {
        return upozila;
    }

    public String getDes() {
        return des;
    }
}
