package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;

import java.util.*;

public class PersonInput {
    Scanner consoleInput;

    public PersonInput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public List<Person> readResidents() {
        AnimalInput animalInput = new AnimalInput(consoleInput);
        String firstName;
        String lastName;
        int money;
        List<Animal> animals;
        List<Person> residents = new ArrayList<>();
        while (residents.size() == 0 || askNextPerson()) {
            firstName = askFirstName();
            lastName = askLastName();
            try {
                money = askMoney();
                consoleInput.nextLine();
                animals = animalInput.readAnimals();
                residents.add(new Person.Builder().withFirstName(firstName)
                        .withLastName(lastName).withMoney(money).withPets(animals).build());
            } catch (NoSuchElementException ex) {
                System.out.println("Wrong money format, the person wasn't added");
                consoleInput.nextLine();
            }
        }
        return residents;
    }

    private String askFirstName() {
        System.out.print("Enter first name: ");
        return consoleInput.nextLine();
    }

    private String askLastName() {
        System.out.print("Enter last name: ");
        return consoleInput.nextLine();
    }

    private int askMoney() throws NoSuchElementException {
        System.out.print("Enter money: ");
        return consoleInput.nextInt();
    }

    private boolean askNextPerson() {
        System.out.print("To enter another resident, type '1', else type any symbol: ");
        return consoleInput.nextLine().equals("1");
    }
}
