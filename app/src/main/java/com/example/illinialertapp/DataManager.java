package com.example.illinialertapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DataManager {

    public static List<Incident> getHardcodedIncidents() {
        List<Incident> incidents = new ArrayList<>();

        incidents.add(new Incident(
                "ID1",
                "Shots Fired",
                "Shots fired at Second and Green in Champaign. Continue to avoid area.",
                40.11024,
                -88.23706,
                "2021-08-22",
                "Shots reported. Area is currently unsafe. Avoid the vicinity.",
                "Shooting"
        ));

        // Armed robbery at Sixth St/Daniel St
        incidents.add(new Incident(
                "ID2",
                "Armed Robbery",
                "Armed robbery reported at Sixth St/Daniel St. Use caution and avoid the area.",
                40.12262,
                -88.23047,
                "2021-12-13",
                "Robbery alert. Ensure personal safety and report any suspicious activity.",
                "Robbery"
        ));

        // Fire at 901 S Fourth St, Champaign
        incidents.add(new Incident(
                "ID3",
                "Fire",
                "Fire reported at 901 S Fourth St, Champaign. Continue to avoid area while fire apparatus on scene.",
                40.10766,
                -88.23376,
                "2022-11-03",
                "Fire reported. Avoid the area and allow access to emergency services.",
                "FireAccident"
        ));

        // Stabbing at 100 block of East Green St
        incidents.add(new Incident(
                "ID4",
                "Stabbing",
                "Stabbing reported at 100 block of East Green St. Avoid area.",
                38.99989,
                -110.161,
                "2023-03-24",
                "Stabbing incident reported. Area is currently unsafe. Avoid the vicinity.",
                "Stabbing"
        ));

        // Hazard at 1101 Springfield Av Urbana
        incidents.add(new Incident(
                "ID5",
                "Hazard",
                "Hazard reported at 1101 Springfield Av Urbana. Please continue to avoid the area during cleanup.",
                40.1125,
                -88.22313,
                "2023-08-30",
                "Hazardous condition reported. Avoid area during cleanup operations.",
                "Chemical Hazard"
        ));

        // Shots fired at Third/Green, Champaign
        incidents.add(new Incident(
                "ID6",
                "Shots Fired",
                "Shots fired at Third/Green, Champaign. Leave area if safe to do so.",
                40.11025,
                -88.2354,
                "2023-10-29",
                "Shots reported in the area. Leave immediately if safe to do so.",
                "Shooting"
        ));
        // More incidents can be added here

        return incidents;
    }

    public static Map<String, Integer> getTypeCount()
        {
         Map<String, Integer> typeCount = new HashMap<>();
         for (Incident incident : getHardcodedIncidents())
         {
             String type = incident.getType();
             typeCount.put(type, typeCount.getOrDefault(type, 0)+1);
         }
         return typeCount;
        }
    }
