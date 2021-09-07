package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Animal;

public class AnimalIO implements TaskIO<Animal> {

    @Override
    public void print(Animal obj) {
        System.out.println("        Кличка: " + obj.getName());
        System.out.println("        Тип: " + obj.getType() + "\n");
    }

    @Override
    public Animal read() {
        return null;
    }
}
