package hse.projects.taskone.entities;

import java.util.*;

public class Street {
    private final String streetName;
    private final List<Building> buildings;

    public Street(String streetName, List<Building> buildings) {
        this.streetName = streetName;
        this.buildings = buildings;
    }

    public String getStreetName() {
        return streetName;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public String toString() {
        return ("\nУлица " + streetName +
                "\nДома: " + buildings)
                .replaceAll("\\[", "")
                .replaceAll("]", "");
    }

    public static class Builder {
        private String streetName;
        private List<Building> buildings;

        public Builder withName(String name) {
            this.streetName = name;
            return this;
        }

        public Builder withBuildings(List<Building> buildings) {
            this.buildings = buildings;
            return this;
        }

        public Street build() {
            return new Street(streetName, buildings);
        }
    }
}
