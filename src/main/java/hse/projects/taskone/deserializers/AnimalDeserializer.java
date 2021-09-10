package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalDeserializer extends Separator implements Deserializer<Animal> {
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
        List<Animal> animalList = new ArrayList<>();
        List<String> strLst = this.toStringList(str);
        for (String string : strLst) {
            animalList.add(this.fromJson(string));
        }
        return animalList;
    }

}
