package hse.projects.taskone.entities;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private int money;
    private List<Animal> pets = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Animal> getPets() {
        return pets;
    }

    public void setPets(List<Animal> pets) {
        this.pets = pets;
    }

    public Person(String firstname, String lastname, int money) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.money = money;
    }

    public void addPet(Animal pet) {
        this.pets.add(pet);
    }
}
