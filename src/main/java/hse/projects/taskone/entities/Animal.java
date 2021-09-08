package hse.projects.taskone.entities;

import java.util.Locale;

public class Animal {

    private String name;
    private Type type = null;

    public Animal(String name) {
        this.name = name;
    }

    public boolean setType(String anType) {
        for (Type o : Type.values()) {
            if (o.toString().equals(anType.toLowerCase(Locale.ROOT))) {
                this.type = o;
                return true;
            }
        }
        return false;
    }

    public String getType() {
        if (type != null) {
            return this.type.toString();
        } else return "Err";
    }

    private enum Type {
        DOG, CAT, TURTLE, HAMSTER;

        public String toString() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\tКличка: " + this.name + "\n\t\t\t\tТип: " + this.type.toString();
    }
}
