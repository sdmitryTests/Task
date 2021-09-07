package hse.projects.taskone.serializers;

public interface Serializer<T> {
    String toJson(T obj);

    T fromJson(String str);

}
