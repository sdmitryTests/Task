package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Person;

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
    public String toJsonList(List<Building> lstObj) {
        StringBuilder val = new StringBuilder("[");
        for (Building building : lstObj) {
            val.append(this.toJson(building));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }
}
