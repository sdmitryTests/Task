package hse.projects.taskone.serializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class ApartSerializer implements Serializer<Aparts> {
    @Override
    public String toJson(Aparts aparts) {
        PersonSerializer ps = new PersonSerializer();
        StringBuilder val = new StringBuilder();
        val.append("{\"number\":").append(aparts.getNumber()).append(",\"residents\":[");
        if (aparts.getResidents().size() > 0) {
            for (int i = 0; i < aparts.getResidents().size(); i++) {
                val.append(ps.toJson(aparts.getResidents().get(i))).append(",");
            }
            val.deleteCharAt(val.length() - 1);
        }
        val.append("]}");
        return val.toString();
    }

    @Override
    public String toJsonList(List<Aparts> apartsList) {
        StringBuilder val = new StringBuilder("[");
        for (Aparts apart : apartsList) {
            val.append(this.toJson(apart));
            val.append(",");
        }
        val.deleteCharAt(val.length()-1);
        val.append("]");
        return val.toString();
    }

}
