package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnimalDeserializer implements Deserializer<Animal> {
    @Override
    public Animal fromJson(String str) {
        String name = null;
        String type = null;
        JsonObjectMapper animalMapper = new JsonObjectMapper();
        Map<String, String> animalJsonMapped = animalMapper.jsonObjectToMap(str);
        for (String key : animalJsonMapped.keySet()){
            switch (key) {
                case "name" -> name = animalJsonMapped.get(key);
                case "type" -> type = animalJsonMapped.get(key);
            }
        }
        if (type == null || name == null) {
            throw new IllegalStateException("Not enough fields");
        }
        return new Animal.Builder().withName(name).withType(type).build();
    }

    @Override
    public List<Animal> fromJsonList(String str) {
        JsonArraySplitter animalSplitter = new JsonArraySplitter(str);
        List<Animal> animalList = new ArrayList<>();
        List<String> strLst = animalSplitter.splitJsonArray();
        for (String string : strLst) {
            animalList.add(this.fromJson(string));
        }
        return animalList;
    }
}
