package hse.projects.taskone.deserializers;

import hse.projects.taskone.entities.Aparts;
import hse.projects.taskone.entities.Person;
import hse.projects.taskone.serializers.PersonSerializer;

import java.util.ArrayList;
import java.util.List;

public class ApartDeserializer extends Separator implements Deserializer<Aparts> {
    @Override
    public Aparts fromJson(String str) {
        PersonDeserializer pd = new PersonDeserializer();
        StringBuilder sb = new StringBuilder(str);
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до первого значения (number)
        int number = Integer.parseInt(sb.substring(0, sb.indexOf(","))); // записываем значение
        sb.delete(0, sb.indexOf(":") + 1); //обрезаем до списка жителей
        List<Person> serializedResidents = pd.fromJsonList(sb.toString());
        return new Aparts.Builder().withNumber(number).withResidents(serializedResidents).build();
    }

    @Override
    public List<Aparts> fromJsonList(String str) {
        List<Aparts> apartsList = new ArrayList<>();
        List<String> strLst = this.toStringList(str);
        for (String string : strLst) {
            apartsList.add(this.fromJson(string));
        }
        return apartsList;
    }
}
