package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.BuildingSerializer;

import java.util.ArrayList;
import java.util.List;

public class StreetDeserializer implements Deserializer<Street> {
    @Override
    public Street fromJson(String str) {
        BuildingDeserializer bd = new BuildingDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до первого значения (streetName)
        String streetName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка домов
        List<Building> buildingList = new ArrayList<>();
        Street tmpS = new Street(streetName);
        while (sb.indexOf(":") >= 0){
            buildingList.add(bd.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpS.setBuildings(buildingList);
        return tmpS;
    }

    @Override
    public List<Street> fromJsonList(String str) {
        return null;
    }
}