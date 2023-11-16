package com.example.illinialertapp;

public class Incident {
    private String id;
    private String title;
    private String description;
    private double latitude;
    private double longitude;
    private String date; // You can use more specific date types if needed
    private String smallDescription; // Field for small description

    // Constructor
    public Incident(String id, String title, String description, double latitude, double longitude, String date, String smallDescription) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.smallDescription = smallDescription;
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

    public void setSmallDescription(String smallDescription) { // Setter for small description
        this.smallDescription = smallDescription;
}
}