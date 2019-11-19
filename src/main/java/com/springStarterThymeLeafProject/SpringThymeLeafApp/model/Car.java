package com.springStarterThymeLeafProject.SpringThymeLeafApp.model;

public class Car {
    private String name;
    private String brand;
    private String year;

    public Car() {

    }

    public Car(String name, String brand, String year) {
        this.name = name;
        this.brand = brand;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }
}
