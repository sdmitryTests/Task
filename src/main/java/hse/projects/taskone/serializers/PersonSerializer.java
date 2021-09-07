package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonSerializer implements Serializer<Person> {
    @Override
    public String toJson(Person obj) {
        AnimalSerializer as = new AnimalSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"firstName\":\"" + obj.getFirstName() + "\"," + "\"lastName\":\"" + obj.getLastName() + "\"," +
                "\"money\":" + obj.getMoney() + "," + "\"pets\":[");
        if (obj.getPets().size() > 0) {
            for (int i = 0; i < obj.getPets().size(); i++) {
                val.append(as.toJson(obj.getPets().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public Person fromJson(String str) {
        AnimalSerializer as = new AnimalSerializer();
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
            animalList.add(as.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpPers.setPets(animalList);
        return tmpPers;
    }
}
