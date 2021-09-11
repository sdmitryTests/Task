package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalDeserializer extends JsonArraySplitter implements Deserializer<Animal> {
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
    public List<Animal> fromJsonList(String animalJsonArray) {
        JsonArraySplitter jsonArraySplitter = new JsonArraySplitter(animalJsonArray);
        List<String> splittedJsonArray = jsonArraySplitter.splitJsonArray();
        List<Animal> animals = splittedJsonArray.stream().map(this::fromJson).collect(Collectors.toList());
        return animals;
    }

}
