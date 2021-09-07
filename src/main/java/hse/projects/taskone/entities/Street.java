package hse.projects.taskone.entities;

import java.util.*;

public class Street {
    private String streetName;
    private List<Building> buildings = new ArrayList<>();

    public Street(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public void AddBuilding(Building b) {
        this.buildings.add(b);
    }

}
