package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;
import hse.projects.taskone.serializers.ApartSerializer;

import java.util.ArrayList;
import java.util.List;

public class BuildingDeserializer implements Deserializer<Building> {
    @Override
    public Building fromJson(String str) {
        ApartDeserializer ad = new ApartDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка квартир
        List<Aparts> apartList = new ArrayList<>();
        Building tmpB = new Building(number);
        while (sb.indexOf(":") >= 0){
            apartList.add(ad.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpB.setAparts(apartList);
        return tmpB;
    }

    @Override
    public List<Building> fromJsonList(String str) {
        return null;
    }
}
