package edu.sjsu.izzymoriguchi.travelmap;

import java.util.ArrayList;

/**
 *  Model class that represents the data of each trip
 */
public class Trip {
    private String nameOfTrip;

    public Trip(String nameOfTrip) {
        this.nameOfTrip = nameOfTrip;
    }

    public String getNameOfTrip() {
        return nameOfTrip;
    }

    public static ArrayList<Trip> createContactsList() {
        ArrayList<Trip> contacts = new ArrayList<Trip>();
        return contacts;
    }
}
