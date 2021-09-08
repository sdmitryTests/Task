package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;

import java.util.List;

public class AnimalDeserializer implements Deserializer<Animal> {
    @Override
    public Animal fromJson(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); // обрезаем до первого значения (name)
        Animal tmp = new Animal(sb.substring(0, sb.indexOf("\""))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до второго значения (type)
        tmp.setType(sb.substring(0, sb.indexOf("\"")));
        return tmp;
    }

    @Override
    public List<Animal> fromJsonList(String str) {
        return null;
    }
}
