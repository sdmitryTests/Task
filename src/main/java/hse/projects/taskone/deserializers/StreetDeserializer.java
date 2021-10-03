package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.BuildingSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreetDeserializer implements Deserializer<Street> {
    @Override
    public Street fromJson(String str) {
        BuildingDeserializer buildingDeserializer = new BuildingDeserializer();
        String streetName = "";
        List<Building> buildings = null;
        JsonObjectMapper streetMapper = new JsonObjectMapper();
        Map<String, String> streetJsonMapped = streetMapper.jsonObjectToMap(str);
        for (String key : streetJsonMapped.keySet()){
            switch (key) {
                case "streetName" -> streetName = streetJsonMapped.get(key);
                case "buildings" -> buildings = buildingDeserializer.fromJsonList(streetJsonMapped.get(key));
            }
        }
        if (buildings == null || streetName.length() == 0) {
            throw new IllegalStateException("Not enough fields");
        }
        return new Street.Builder().withName(streetName).withBuildings(buildings).build();
    }

    @Override
    public List<Street> fromJsonList(String str) {
        JsonArraySplitter streetSplitter = new JsonArraySplitter(str);
        List<Street> splittedStreets = new ArrayList<>();
        List<String> strLst = streetSplitter.splitJsonArray();
        for (String string : strLst) {
            splittedStreets.add(this.fromJson(string));
        }
        return splittedStreets;
    }
}
