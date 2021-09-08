package hse.projects.taskone.entities;

import java.util.ArrayList;
import java.util.List;

public class Aparts {
    private int number;
    private List<Person> residents = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public Aparts(int num) {
        this.number = num;
    }

    public void addResident(Person p) {
        this.residents.add(p);
    }

    public List<Person> getResidents() {
        return residents;
    }

    public void setResidents(List<Person> residents) {
        this.residents = residents;
    }

    public Person get(int index) {
        return this.residents.get(index);
    }

    @Override
    public String toString() {
        return "\n\t\tНомер: " + number +
                "\n\t\tЖители: " + residents;
    }
}
