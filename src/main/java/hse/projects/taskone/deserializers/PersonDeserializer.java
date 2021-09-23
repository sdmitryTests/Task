package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.AnimalSerializer;

import java.util.ArrayList;
import java.util.List;

public class PersonDeserializer extends Separator implements Deserializer<Person> {
    @Override
    public Person fromJson(String str) {
        AnimalDeserializer animalDeserializer = new AnimalDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); // обрезаем до первого значения (firstName)
        String firstName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до второго значения (lastName)
        String lastName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до третьего значения (money)
        int money = Integer.parseInt(sb.substring(0, sb.indexOf("p") - 2)); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до списка питомцев
        List<Animal> serializedPets = animalDeserializer.fromJsonList(sb.toString());
        return new Person.Builder().withFirstName(firstName).withLastName(lastName)
                .withMoney(money).withPets(serializedPets).build();
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
