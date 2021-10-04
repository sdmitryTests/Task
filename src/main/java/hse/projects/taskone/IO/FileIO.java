package hse.projects.taskone.IO;

import hse.projects.taskone.deserializers.StreetDeserializer;
import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.StreetSerializer;

import java.io.*;
import java.util.List;

public class FileIO {
    public void write(String filePath, List<Street> street, boolean append) throws IOException {
        StreetSerializer streetSerializer = new StreetSerializer();
        FileOutputStream jsonObjectWriter = new FileOutputStream(filePath, append);
        jsonObjectWriter.write(streetSerializer.toJsonList(street).getBytes());
        jsonObjectWriter.write("\n".getBytes());
    }

    public List<Street> read(String filePath) throws IOException, IllegalStateException {
        StreetDeserializer streetDeserializer = new StreetDeserializer();
        StringBuilder jsonObject = new StringBuilder();
        File file = new File(filePath);
        if (file.length() != 0) {
            FileInputStream jsonObjectReader = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(jsonObjectReader);
            int ch;
            while ((ch = bufferedInputStream.read()) != -1) {
                jsonObject.append((char) ch);
            }
            return streetDeserializer.fromJsonList(jsonObject.toString().replaceAll("\n", ""));
        } else return null;
    }
}
