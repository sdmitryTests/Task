package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Building;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.ApartSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingDeserializer extends Separator implements Deserializer<Building> {
    @Override
    public Building fromJson(String str) {
        ApartDeserializer apartDeserializer = new ApartDeserializer();
        int number = -1;
        List<Aparts> aparts = null;
        JsonObjectMapper buildingMapper = new JsonObjectMapper();
        Map<String, String> buildingJsonMapped = buildingMapper.jsonObjectToMap(str);
        for (String key : buildingJsonMapped.keySet()){
            switch (key) {
                case "number" -> number = Integer.parseInt(buildingJsonMapped.get(key));
                case "aparts" -> aparts = apartDeserializer.fromJsonList(buildingJsonMapped.get(key));
            }
        }
        if (aparts == null || number == -1) {
            throw new IllegalStateException("Not enough fields");
        }
        return new Building.Builder().withNumber(number).withAparts(aparts).build();
    }

    @Override
    public List<Building> fromJsonList(String str) {
        JsonArraySplitter buildingSplitter = new JsonArraySplitter(str);
        List<Building> splittedBuildings = new ArrayList<>();
        List<String> strLst = buildingSplitter.splitJsonArray();
        for (String string : strLst) {
            splittedBuildings.add(this.fromJson(string));
        }
        return splittedBuildings;
    }

}
