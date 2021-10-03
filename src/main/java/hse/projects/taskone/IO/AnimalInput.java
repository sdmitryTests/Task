package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalInput {
    Scanner consoleInput;

    public AnimalInput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public List<Animal> readAnimals() {
        String animalName;
        String animalType;
        List<Animal> animalList = new ArrayList<>();
        while (animalList.size() == 0 || askNextAnimal()) {
            animalName = askAnimalName();
            animalType = askAnimalType();
            try {
                animalList.add(new Animal.Builder().withName(animalName).withType(animalType).build());
            } catch (IllegalArgumentException ex) {
                System.out.println("Wrong animal type");
            }
        }
        return animalList;
    }

    private String askAnimalName() {
        System.out.print("Enter animal name: ");
        return consoleInput.nextLine();
    }

    private String askAnimalType() {
        System.out.print("Enter animal type: ");
        return consoleInput.nextLine();
    }

    private boolean askNextAnimal() {
        System.out.print("To enter another animal, type '1', else type any symbol: ");
        return consoleInput.nextLine().equals("1");
    }
}
