package com.techsajib.amaderbbaria.Education;

public class EducationModel {
    private String url;
    private String name;
    private String establish;
    private String principal;
    private String type;
    private String student;
    private String mobile;
    private String email;
    private String web;
    private String address;

    public EducationModel(String url, String name, String establish, String principal, String type, String student, String mobile, String email, String web, String address) {
        this.url = url;
        this.name = name;
        this.establish = establish;
        this.principal = principal;
        this.type = type;
        this.student = student;
        this.mobile = mobile;
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

    public String getEstablish() {
        return establish;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getType() {
        return type;
    }

    public String getStudent() {
        return student;
    }

    public String getMobile() {
        return mobile;
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
