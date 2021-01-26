package com.techsajib.amaderbbaria.Bank;

public class BankModel {

    private String name;
    private String branch;
    private String routing;
    private String swift;
    private String number;
    private String email;
    private String web;
    private String time;
    private String address;

    public BankModel(String name, String branch, String routing, String swift, String number, String email, String web, String time, String address) {
        this.name = name;
        this.branch = branch;
        this.routing = routing;
        this.swift = swift;
        this.number = number;
        this.email = email;
        this.web = web;
        this.time = time;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getRouting() {
        return routing;
    }

    public String getSwift() {
        return swift;
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

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }
}
