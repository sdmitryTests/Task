package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ApartsInput {
    Scanner consoleInput;

    public ApartsInput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public List<Aparts> readAparts() {
        PersonInput personInput = new PersonInput(consoleInput);
        int apartNumber;
        List<Person> residents;
        List<Aparts> aparts = new ArrayList<>();
        while (aparts.size() == 0 || askNextApart()) {
            try {
                apartNumber = askNumber();
                consoleInput.nextLine();
                residents = personInput.readResidents();
                aparts.add(new Aparts.Builder().withNumber(apartNumber).withResidents(residents).build());
            } catch (NoSuchElementException ex) {
                System.out.println("Wrong number format, the apart wasn't added");
                consoleInput.nextLine();
            }
        }
        return aparts;
    }

    private int askNumber() throws NoSuchElementException {
        System.out.print("Enter number of apart: ");
        return consoleInput.nextInt();
    }

    private boolean askNextApart() {
        System.out.print("To enter another apart, type '1', else type any symbol: ");
        return consoleInput.nextLine().equals("1");
    }
}
