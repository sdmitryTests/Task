package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDeserializer extends JsonArraySplitter implements Deserializer<Person> {
    @Override
    public Person fromJson(String str) {
        AnimalDeserializer ad = new AnimalDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); // обрезаем до первого значения (firstName)
        String firstName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до второго значения (lastName)
        String lastName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до третьего значения (money)
        int money = Integer.parseInt(sb.substring(0, sb.indexOf("p") - 2)); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до списка питомцев
        Person tmpPers = new Person(firstName, lastName, money);
        tmpPers.setPets(ad.fromJsonList(sb.toString()));
        return tmpPers;
    }

    @Override
    public List<Person> fromJsonList(String str) {
        List<Person> personList = new ArrayList<>();
        List<String> strLst = this.toStringList(str);
        for (String string : strLst) {
            personList.add(this.fromJson(string));
        }
        return personList;
    }
}
