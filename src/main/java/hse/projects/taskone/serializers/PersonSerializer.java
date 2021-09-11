package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Person;

import java.util.List;

public class PersonSerializer implements Serializer<Person> {
    @Override
    public String toJson(Person person) {
        AnimalSerializer as = new AnimalSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"firstName\":\"").append(person.getFirstName()).append("\",").append("\"lastName\":\"");
        val.append(person.getLastName()).append("\",").append("\"money\":");
        val.append(person.getMoney()).append(",").append("\"pets\":[");
        if (person.getPets().size() > 0) {
            for (int i = 0; i < person.getPets().size(); i++) {
                val.append(as.toJson(person.getPets().get(i))).append(",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Person> personList) {
        StringBuilder val = new StringBuilder("[");
        for (Person person : personList) {
            val.append(this.toJson(person));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
