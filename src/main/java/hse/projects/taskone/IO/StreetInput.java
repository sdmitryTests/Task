package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Street;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StreetInput {
    Scanner consoleInput;

    public StreetInput(Scanner scanner) {
        consoleInput = scanner;
    }

    public List<Street> readStreets(){
        BuildingInput buildingInput = new BuildingInput(consoleInput);
        String streetName;
        List<Building> buildings;
        List<Street> streets = new ArrayList<>();
        while (streets.size() == 0 || askNextStreet()){
            streetName = askStreetName();
            buildings = buildingInput.readBuildings();
            streets.add(new Street.Builder().withName(streetName).withBuildings(buildings).build());
        }
        return streets;
    }

    private String askStreetName() {
        System.out.print("Enter street name: ");
        return consoleInput.nextLine();
    }

    private boolean askNextStreet() {
        System.out.print("To enter another street, type '1', else type any symbol: ");
        return consoleInput.nextLine().equals("1");
    }
}
