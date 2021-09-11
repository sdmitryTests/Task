package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Building;

import java.util.List;

public class BuildingSerializer implements Serializer<Building> {
    @Override
    public String toJson(Building building) {
        ApartSerializer as = new ApartSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"number\":").append(building.getNumber()).append(",\"aparts\":[");
        if (building.getAparts().size() > 0) {
            for (int i = 0; i < building.getAparts().size(); i++) {
                val.append(as.toJson(building.getAparts().get(i))).append(",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Building> buildingList) {
        StringBuilder val = new StringBuilder("[");
        for (Building building : buildingList) {
            val.append(this.toJson(building));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }
}
