package hse.projects.taskone.IO;

import hse.projects.taskone.deserializers.StreetDeserializer;
import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.StreetSerializer;

import java.io.*;
import java.util.List;

public class FileIO {
    public void write(String filePath, Street street, boolean append) throws IOException {
        StreetSerializer streetSerializer = new StreetSerializer();
        FileOutputStream jsonObjectWriter = new FileOutputStream(filePath, append);
        jsonObjectWriter.write(streetSerializer.toJson(street).getBytes());
        jsonObjectWriter.write("\n".getBytes());
    }

    public List<Street> read(String filePath) throws IOException {
        StreetDeserializer streetDeserializer = new StreetDeserializer();
        StringBuilder jsonObject = new StringBuilder();
        File file = new File(filePath);
        FileInputStream jsonObjectReader = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(jsonObjectReader, 200);
        int ch;
        while ((ch = bufferedInputStream.read()) != -1) {
            jsonObject.append((char) ch);
        }
        return streetDeserializer.fromJsonList(jsonObject.toString().replaceAll("\n", ""));
    }
}
