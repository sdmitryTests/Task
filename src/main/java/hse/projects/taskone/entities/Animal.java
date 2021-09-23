package hse.projects.taskone.entities;

import java.util.Locale;

public class Animal {

    private enum Type {
        DOG, CAT, TURTLE, HAMSTER;

        public String toString() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }

    private final String name;
    private final Type type;

    private Animal(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\tКличка: " + this.name + "\n\t\t\t\tТип: " + this.type.toString();
    }

    public static class Builder {
        private String name;
        private Type type;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = Type.valueOf(type.toUpperCase(Locale.ROOT));
            return this;
        }

        public Animal build() {
            return new Animal(name, type);
        }
    }
}
