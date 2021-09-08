package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.AnimalSerializer;

import java.util.ArrayList;
import java.util.List;

public class PersonDeserializer implements Deserializer<Person> {
    @Override
    public Person fromJson(String str) {
        AnimalDeserializer ad = new AnimalDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); // обрезаем до первого значения (firstName)
        String firstName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до второго значения (lastName)
        String lastName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до третьего значения (money)
        int money = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка питомцев
        List<Animal> animalList = new ArrayList<>();
        Person tmpPers = new Person(firstName, lastName, money);
        while (sb.indexOf(":") >= 0){
            animalList.add(ad.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpPers.setPets(animalList);
        return tmpPers;
    }

    @Override
    public List<Person> fromJsonList(String str) {
        return null;
    }
}
