package com.techsajib.amaderbbaria.Leader;

public class LeaderModel {

    private String url;
    private String mayor;
    private String chairman;
    private String vicechairman;
    private String womenchairman;

    public LeaderModel(String url, String mayor, String chairman, String vicechairman, String womenchairman) {
        this.url = url;
        this.mayor = mayor;
        this.chairman = chairman;
        this.vicechairman = vicechairman;
        this.womenchairman = womenchairman;
    }

    public String getUrl() {
        return url;
    }

    public String getMayor() {
        return mayor;
    }

    public String getChairman() {
        return chairman;
    }

    public String getVicechairman() {
        return vicechairman;
    }

    public String getWomenchairman() {
        return womenchairman;
    }
}
