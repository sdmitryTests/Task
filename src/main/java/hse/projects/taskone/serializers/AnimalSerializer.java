package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Animal;

import java.util.List;

public class AnimalSerializer implements Serializer<Animal> {
    @Override
    public String toJson(Animal animal) {
        return "{\"name\":\"" + animal.getName() + "\",\"type\":\"" + animal.getType() + "\"}";
    }

    @Override
    public String toJsonList(List<Animal> animalList) {
        StringBuilder val = new StringBuilder("[");
        for (Animal animal : animalList) {
            val.append(this.toJson(animal));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
