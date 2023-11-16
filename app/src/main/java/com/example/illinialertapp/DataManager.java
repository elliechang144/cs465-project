package com.example.illinialertapp;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static List<Incident> getHardcodedIncidents() {
        List<Incident> incidents = new ArrayList<>();

        // Add some hardcoded incidents
        incidents.add(new Incident(
                "1",
                "Theft at Central Park",
                "A bike was reported stolen near the entrance of Central Park.",
                40.785091,
                -73.968285,
                "2023-03-15",
                "Stolen Bike - Be cautious in this area."
        ));

        incidents.add(new Incident(
                "2",
                "Lost Pet Near Riverside",
                "A small brown dog was lost near Riverside Walk.",
                40.800675,
                -73.970578,
                "2023-03-16",
                "Missing Dog - Please report if seen."
        ));

        incidents.add(new Incident(
                "3",
                "Vandalism at Local School",
                "Graffiti was found on the walls of Lincoln High School.",
                40.773670,
                -73.959880,
                "2023-03-17",
                "School Property Damage - Investigation ongoing."
        ));

        incidents.add(new Incident(
                "4",
                "Car Break-In Downtown",
                "A car break-in was reported on 5th Avenue last night.",
                40.774528,
                -73.965083,
                "2023-03-18",
                "Vehicle Security Alert - Valuables were stolen."
        ));

        incidents.add(new Incident(
                "5",
                "Suspicious Activity in Subway",
                "Reports of suspicious behavior observed at the subway station.",
                40.779492,
                -73.955078,
                "2023-03-19",
                "Stay Alert - Report any unusual activities."
        ));
        // More incidents can be added here

        return incidents;
    }
}