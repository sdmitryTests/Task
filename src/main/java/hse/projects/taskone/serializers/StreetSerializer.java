package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Street;

import java.util.ArrayList;
import java.util.List;

public class StreetSerializer implements Serializer<Street> {
    @Override
    public String toJson(Street obj) {
        BuildingSerializer bs = new BuildingSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"streetName\":\"" + obj.getStreetName() + "\",\"buildings\":[");
        if (obj.getBuildings().size() > 0) {
            for (int i = 0; i < obj.getBuildings().size(); i++) {
                val.append(bs.toJson(obj.getBuildings().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public Street fromJson(String str) {
        BuildingSerializer bs = new BuildingSerializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до первого значения (streetName)
        String streetName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до списка домов
        List<Building> buildingList = new ArrayList<>();
        Street tmpS = new Street(streetName);
        while (sb.indexOf(":") >= 0){
            buildingList.add(bs.fromJson(sb.toString())); // сериализуем всех питомцев и добавляем в массив
            sb.delete(0, sb.indexOf("}") + 1);
        }
        tmpS.setBuildings(buildingList);
        return tmpS;
    }
}
