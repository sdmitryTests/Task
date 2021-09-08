package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.PersonSerializer;

import java.util.ArrayList;
import java.util.List;

public class ApartDeserializer implements Deserializer<Aparts> {
    @Override
    public Aparts fromJson(String str) {
        PersonDeserializer pd = new PersonDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка жителей
        List<Person> residentList = new ArrayList<>();
        Aparts tmpA = new Aparts(number);
        while (sb.indexOf(":") >= 0){
            residentList.add(pd.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpA.setResidents(residentList);
        return tmpA;
    }

    @Override
    public List<Aparts> fromJsonList(String str) {
        return null;
    }
}
