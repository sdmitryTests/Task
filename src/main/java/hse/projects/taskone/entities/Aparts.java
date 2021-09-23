package hse.projects.taskone.entities;

import java.util.List;

public class Aparts {
    private final int number;
    private final List<Person> residents;

    private Aparts(int num, List<Person> residents) {
        this.number = num;
        this.residents = residents;
    }

    public int getNumber() {
        return number;
    }

    public List<Person> getResidents() {
        return residents;
    }

    @Override
    public String toString() {
        return "\n\t\tКвартира " + number +
                "\n\t\tЖители: " + residents;
    }

    public static class Builder {
        private int number;
        List<Person> residents;

        public Builder withNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder withResidents(List<Person> residents) {
            this.residents = residents;
            return this;
        }

        public Aparts build() {
            return new Aparts(number, residents);
        }
    }
}
