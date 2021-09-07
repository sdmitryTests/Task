package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class ApartSerializer implements Serializer<Aparts> {
    @Override
    public String toJson(Aparts obj) {
        PersonSerializer ps = new PersonSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"number\":" + obj.getNumber() + ",\"residents\":[");
        if (obj.getResidents().size() > 0) {
            for (int i = 0; i < obj.getResidents().size(); i++) {
                val.append(ps.toJson(obj.getResidents().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public Aparts fromJson(String str) {
        PersonSerializer ps = new PersonSerializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка жителей
        List<Person> residentList = new ArrayList<>();
        Aparts tmpA = new Aparts(number);
        while (sb.indexOf(":") >= 0){
            residentList.add(ps.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpA.setResidents(residentList);
        return tmpA;
    }
}
