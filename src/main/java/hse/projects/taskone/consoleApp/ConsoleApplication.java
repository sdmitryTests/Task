package hse.projects.taskone.consoleApp;

import hse.projects.taskone.IO.FileIO;
import hse.projects.taskone.IO.StreetInput;
import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.StreetSerializer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication implements Runnable {
    Scanner consoleInput;

    public ConsoleApplication(Scanner scanner) {
        this.consoleInput = scanner;
    }

    public void run(){
        while (checkToContinue()){
            askWriteOrRead();
        }
    }

    private void askWriteOrRead(){
        System.out.println("Type '1' to enter street and write in file \nType '2' to read streets from file");
        if (checkFirstChoose()) {
            writeStreetsToFile();
        } else {
            readStreetsFromFile();
        }
    }

    private void readStreetsFromFile(){
        FileIO fileIO = new FileIO();
        try {
            System.out.println(fileIO.read(getFileName()));
        } catch (IOException ex) {
            System.out.println("Wrong file");
        } catch (IllegalStateException ex) {
            System.out.println("Wrong values in the file");
        }
    }

    private void writeStreetsToFile() {
        FileIO fileIO = new FileIO();
        try {
            fileIO.write(getFileName(), readStreetsFromConsole(), false);
        } catch (IOException ex) {
            System.out.println("Wrong file");
        }
    }

    private List<Street> readStreetsFromConsole(){
        StreetInput streetInput = new StreetInput(consoleInput);
        StreetSerializer streetSerializer = new StreetSerializer();
        return streetInput.readStreets();
    }

    private String getFileName() {
        System.out.print("Enter filename: ");
        return consoleInput.nextLine();
    }

    private boolean checkFirstChoose() {
        return consoleInput.nextLine().equals("1");
    }

    private boolean checkSecondChoose() {
        return consoleInput.nextLine().equals("2");
    }

    private boolean checkToContinue() {
        System.out.println("Type '1' to continue, else type another key");
        return checkFirstChoose();
    }
}
