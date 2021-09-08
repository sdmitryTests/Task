package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Animal;

import java.util.List;

public class AnimalSerializer implements Serializer<Animal> {
    @Override
    public String toJson(Animal obj) {
        return "{\"name\":\"" + obj.getName() + "\",\"type\":\"" + obj.getType() + "\"}";
    }

    @Override
    public String toJsonList(List<Animal> lstObj) {
        StringBuilder val = new StringBuilder("[");
        for (Animal animal : lstObj) {
            val.append(this.toJson(animal));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
