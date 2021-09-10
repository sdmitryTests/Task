package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;
import hse.projects.taskone.serializers.ApartSerializer;

import java.util.ArrayList;
import java.util.List;

public class BuildingDeserializer extends Separator implements Deserializer<Building> {
    @Override
    public Building fromJson(String str) {
        ApartDeserializer ad = new ApartDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до списка квартир
        Building tmpB = new Building(number);
        tmpB.setAparts(ad.fromJsonList(sb.toString()));
        return tmpB;
    }

    @Override
    public List<Building> fromJsonList(String str) {
        List<Building> buildingsList = new ArrayList<>();
        List<String> strLst = this.toStringList(str);
        for (String string : strLst) {
            buildingsList.add(this.fromJson(string));
        }
        return buildingsList;
    }

}
