package com.example.illinialertapp;

public class Incident {
    private String id;
    private String title;
    private String description;

    private String Type;
    private double latitude;
    private double longitude;
    private String date;
    private String smallDescription;

    private int icon;


    // Constructor
    public Incident(String id, String title, String description, double latitude, double longitude, String date, String smallDescription,  String Type, int icon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.smallDescription = smallDescription;
        this.Type = Type;
        this.icon = icon;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDate() {
        return date;
    }

    public String getSmallDescription() { // Getter for small description
        return smallDescription;
    }

    public int getIcon() { return icon; }


    public String getType(){return Type;}
    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;}
    public void setType(String Type) {this.Type = Type; }

    public void setIcon(int icon) { this.icon = icon; }

}