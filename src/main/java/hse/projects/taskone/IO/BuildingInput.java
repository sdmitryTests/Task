package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuildingInput {
    Scanner consoleInput;

    public BuildingInput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public List<Building> readBuildings() {
        ApartsInput apartsInput = new ApartsInput(consoleInput);
        int buildingNumber;
        List<Aparts> aparts;
        List<Building> buildings = new ArrayList<>();
        while (buildings.size() == 0 || askNextBuilding()) {
            try {
                buildingNumber = askNumber();
                consoleInput.nextLine();
                aparts = apartsInput.readAparts();
                buildings.add(new Building.Builder().withNumber(buildingNumber).withAparts(aparts).build());
            } catch (NoSuchElementException ex) {
                System.out.println("Wrong number format, the building wasn't added");
                consoleInput.nextLine();
            }
        }
        return buildings;
    }

    private int askNumber() throws NoSuchElementException {
        System.out.print("Enter number of building: ");
        return consoleInput.nextInt();
    }

    private boolean askNextBuilding() {
        System.out.print("To enter another building, type '1', else type any symbol: ");
        return consoleInput.nextLine().equals("1");
    }
}
