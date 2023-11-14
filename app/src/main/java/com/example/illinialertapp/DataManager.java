package com.example.illinialertapp;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static List<Incident> getHardcodedIncidents() {
        List<Incident> incidents = new ArrayList<>();

        // Add some hardcoded incidents
        incidents.add(new Incident("1", "Theft at Central Park", "A bike was reported stolen near the entrance of Central Park.", 40.785091, -73.968285, "2023-03-15"));
        incidents.add(new Incident("2", "Vandalism in Downtown", "Public property was vandalized with graffiti.", 34.052235, -118.243683, "2023-03-16"));
        incidents.add(new Incident("3", "Car Break-In at Mall Parking", "A car break-in was reported in the mall parking lot.", 37.774929, -122.419416, "2023-03-17"));
        // More incidents can be added here

        return incidents;
    }
}