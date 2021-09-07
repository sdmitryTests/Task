package hse.projects.taskone.entities;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int number;
    private List<Aparts> aparts = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public void addApart(Aparts a) {
        this.aparts.add(a);
    }

    public Aparts get(int index) {
        return this.aparts.get(index);
    }

    public List<Aparts> getAparts() {
        return aparts;
    }

    public void setAparts(List<Aparts> aparts) {
        this.aparts = aparts;
    }

    public Building(int num) {
        this.number = num;
    }
}
