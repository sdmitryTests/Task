package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;

import java.util.ArrayList;
import java.util.List;

public class BuildingSerializer implements Serializer<Building> {
    @Override
    public String toJson(Building obj) {
        ApartSerializer as = new ApartSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"number\":" + obj.getNumber() + ",\"aparts\":[");
        if (obj.getAparts().size() > 0) {
            for (int i = 0; i < obj.getAparts().size(); i++) {
                val.append(as.toJson(obj.getAparts().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public Building fromJson(String str) {
        ApartSerializer as = new ApartSerializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка квартир
        List<Aparts> apartList = new ArrayList<>();
        Building tmpB = new Building(number);
        while (sb.indexOf(":") >= 0){
            apartList.add(as.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpB.setAparts(apartList);
        return tmpB;
    }
}
