package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonSerializer implements Serializer<Person> {
    @Override
    public String toJson(Person obj) {
        AnimalSerializer as = new AnimalSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"firstName\":\"" + obj.getFirstName() + "\"," + "\"lastName\":\"" + obj.getLastName() + "\"," +
                "\"money\":" + obj.getMoney() + "," + "\"pets\":[");
        if (obj.getPets().size() > 0) {
            for (int i = 0; i < obj.getPets().size(); i++) {
                val.append(as.toJson(obj.getPets().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Person> lstObj) {
        StringBuilder val = new StringBuilder("[");
        for (Person person : lstObj) {
            val.append(this.toJson(person));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
