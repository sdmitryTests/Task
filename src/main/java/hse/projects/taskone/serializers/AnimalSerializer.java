package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Animal;

public class AnimalSerializer implements Serializer<Animal> {
    @Override
    public String toJson(Animal obj) {
        return "{\"name\":\"" + obj.getName() + "\",\"type\":\"" + obj.getType() + "\"}";
    }

    @Override
    public Animal fromJson(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); // обрезаем до первого значения (name)
        String name = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до второго значения (type)
        return new Animal(name, sb.substring(0, sb.indexOf("\"")));
    }
}
