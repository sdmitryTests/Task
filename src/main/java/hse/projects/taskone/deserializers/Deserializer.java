package hse.projects.taskone.deserializers;

import java.util.List;

public interface Deserializer<T> {

    T fromJson(String str);

    List<T> fromJsonList(String str);
}
