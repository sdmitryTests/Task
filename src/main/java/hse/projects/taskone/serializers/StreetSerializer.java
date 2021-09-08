package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Person;
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
    public String toJsonList(List<Street> lstObj) {
        StringBuilder val = new StringBuilder("[");
        for (Street street : lstObj) {
            val.append(this.toJson(street));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }
}
