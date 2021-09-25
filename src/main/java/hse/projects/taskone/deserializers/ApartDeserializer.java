package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartDeserializer implements Deserializer<Aparts> {
    @Override
    public Aparts fromJson(String str) {
        PersonDeserializer personDeserializer = new PersonDeserializer();
        int number = -1;
        List<Person> residents = null;
        JsonObjectMapper apartMapper = new JsonObjectMapper();
        Map<String, String> apartJsonMapped = apartMapper.jsonObjectToMap(str);
        for (String key : apartJsonMapped.keySet()){
            switch (key) {
                case "number" -> number = Integer.parseInt(apartJsonMapped.get(key));
                case "residents" -> residents = personDeserializer.fromJsonList(apartJsonMapped.get(key));
            }
        }
        if (residents == null || number == -1) {
            throw new IllegalStateException("Not enough fields");
        }
        return new Aparts.Builder().withNumber(number).withResidents(residents).build();
    }

    @Override
    public List<Aparts> fromJsonList(String str) {
        JsonArraySplitter apartSplitter = new JsonArraySplitter(str);
        List<Aparts> splittedAparts = new ArrayList<>();
        List<String> strLst = apartSplitter.splitJsonArray();
        for (String string : strLst) {
            splittedAparts.add(this.fromJson(string));
        }
        return splittedAparts;
    }
}
