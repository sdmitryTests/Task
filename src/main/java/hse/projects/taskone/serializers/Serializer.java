package hse.projects.taskone.serializers;

import java.util.List;

public interface Serializer<T> {
    String toJson(T obj);

    String toJsonList(List<T> lstObj);
}
