package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Street;

import java.util.ArrayList;
import java.util.List;

public class StreetDeserializer extends JsonArraySplitter implements Deserializer<Street> {
    @Override
    public Street fromJson(String str) {
        BuildingDeserializer bd = new BuildingDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 2); //обрезаем до первого значения (streetName)
        String streetName = sb.substring(0, sb.indexOf("\"")); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до списка домов
        Street tmpS = new Street(streetName);
        tmpS.setBuildings(bd.fromJsonList(sb.toString()));
        return tmpS;
    }

    @Override
    public List<Street> fromJsonList(String str) {
        List<Street> streetsList = new ArrayList<>();
        List<String> strLst = this.toStringList(str);
        for (String string : strLst) {
            streetsList.add(this.fromJson(string));
        }
        return streetsList;
    }

}
