package com.techsajib.amaderbbaria.Newspaper;

public class NewspaperModel {

    private String url;
    private String name;
    private String version;
    private String editor;
    private String number;
    private String email;
    private String web;
    private String address;

    public NewspaperModel(String url, String name, String version, String editor, String number, String email, String web, String address) {
        this.url = url;
        this.name = name;
        this.version = version;
        this.editor = editor;
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

    public String getVersion() {
        return version;
    }

    public String getEditor() {
        return editor;
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
