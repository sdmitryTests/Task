package hse.projects.taskone.entities;

import java.util.List;

public class Building {
    private final int number;
    private final List<Aparts> aparts;

    private Building(int number, List<Aparts> aparts) {
        this.number = number;
        this.aparts = aparts;
    }

    public int getNumber() {
        return number;
    }

    public List<Aparts> getAparts() {
        return aparts;
    }

    @Override
    public String toString() {
        return "\n\tДом " + number +
                "\n\tКвартиры : " + aparts;
    }

    public static class Builder {
        private int number;
        private List<Aparts> aparts;

        public Builder withNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder withAparts(List<Aparts> aparts) {
            this.aparts = aparts;
            return this;
        }

        public Building build() {
            return new Building(number, aparts);
        }
    }
}
