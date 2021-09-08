package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class ApartSerializer implements Serializer<Aparts> {
    @Override
    public String toJson(Aparts obj) {
        PersonSerializer ps = new PersonSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"number\":" + obj.getNumber() + ",\"residents\":[");
        if (obj.getResidents().size() > 0) {
            for (int i = 0; i < obj.getResidents().size(); i++) {
                val.append(ps.toJson(obj.getResidents().get(i)) + ",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Aparts> lstObj) {
        StringBuilder val = new StringBuilder("[");
        for (Aparts apart : lstObj) {
            val.append(this.toJson(apart));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
