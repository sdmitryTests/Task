package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Street;

import java.util.List;

public class StreetSerializer implements Serializer<Street> {
    @Override
    public String toJson(Street street) {
        BuildingSerializer bs = new BuildingSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"streetName\":\"").append(street.getStreetName()).append("\",\"buildings\":[");
        if (street.getBuildings().size() > 0) {
            for (int i = 0; i < street.getBuildings().size(); i++) {
                val.append(bs.toJson(street.getBuildings().get(i))).append(",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Street> streetList) {
        StringBuilder val = new StringBuilder("[");
        for (Street street : streetList) {
            val.append(this.toJson(street));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }
}
