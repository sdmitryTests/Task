package hse.projects.taskone.entities;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int money;
    private final List<Animal> pets;

    private Person(String firstName, String lastName, int money, List<Animal> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.pets = pets;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoney() {
        return money;
    }

    public List<Animal> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return "\n\t\t\tИмя: " + firstName +
                "\n\t\t\tФамилия: " + lastName +
                "\n\t\t\tКапитал: " + money +
                "\n\t\t\tПитомцы: " + pets;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int money;
        private List<Animal> pets;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMoney(int money) {
            this.money = money;
            return this;
        }

        public Builder withPets(List<Animal> pets) {
            this.pets = pets;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, money, pets);
        }
    }
}
