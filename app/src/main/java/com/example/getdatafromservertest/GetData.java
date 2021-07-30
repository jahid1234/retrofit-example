package com.example.getdatafromservertest;

public class GetData {
    String name;
    String about;
    Integer birthYear;

    public GetData(String name, String about, Integer birthYear) {
        this.name = name;
        this.about = about;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public Integer getBirthYear() {
        return birthYear;
    }
}
