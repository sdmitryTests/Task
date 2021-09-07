package hse.projects.taskone.IO;

public interface TaskIO<T> {

    void print(T obj);

    T read();
}
