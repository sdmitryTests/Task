package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.AnimalSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonDeserializer implements Deserializer<Person> {
    @Override
    public Person fromJson(String str) {
        AnimalDeserializer animalDeserializer = new AnimalDeserializer();
        String firstName = null;
        String lastName = null;
        int money = -1;
        List<Animal> pets = null;
        JsonObjectMapper personMapper = new JsonObjectMapper();
        Map<String, String> personJsonMapped = personMapper.jsonObjectToMap(str);
        for (String key : personJsonMapped.keySet()){
            switch (key) {
                case "firstName" -> firstName = personJsonMapped.get(key);
                case "lastName" -> lastName = personJsonMapped.get(key);
                case "money" -> money = Integer.parseInt(personJsonMapped.get(key));
                case "pets" -> pets = animalDeserializer.fromJsonList(personJsonMapped.get(key));
            }
        }
        if (firstName == null || lastName == null || money == -1 || pets == null) {
            throw new IllegalStateException("Not enough fields");
        }
        return new Person.Builder().withFirstName(firstName).withLastName(lastName)
                .withMoney(money).withPets(pets).build();
    }

    @Override
    public List<Person> fromJsonList(String str) {
        JsonArraySplitter personSplitter = new JsonArraySplitter(str);
        List<Person> splittedResidents = new ArrayList<>();
        List<String> strLst = personSplitter.splitJsonArray();
        for (String string : strLst) {
            splittedResidents.add(this.fromJson(string));
        }
        return splittedResidents;
    }
}
