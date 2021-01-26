package com.techsajib.amaderbbaria.Library;

public class LibraryModel {

    private String name;
    private String establish;
    private String book;
    private String member;
    private String librarian;
    private String number;
    private String location;

    public LibraryModel(String name, String establish, String book, String member, String librarian, String number, String location) {
        this.name = name;
        this.establish = establish;
        this.book = book;
        this.member = member;
        this.librarian = librarian;
        this.number = number;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getEstablish() {
        return establish;
    }

    public String getBook() {
        return book;
    }

    public String getMember() {
        return member;
    }

    public String getLibrarian() {
        return librarian;
    }

    public String getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }
}
