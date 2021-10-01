package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Street;
import hse.projects.taskone.serializers.StreetSerializer;

import java.io.*;

public class FileIO {
    public void write(String filePath, Street street, boolean append) {
        try {
            StreetSerializer streetSerializer = new StreetSerializer();
            FileOutputStream jsonObjectWriter = new FileOutputStream(filePath, append);
            jsonObjectWriter.write(streetSerializer.toJson(street).getBytes());
            jsonObjectWriter.write("\n".getBytes());
        } catch (IOException e) {
            System.out.println("File error: cannot write an object in the file");
        }
    }

    public String read(String filePath) throws Exception {
        StringBuilder jsonObject = new StringBuilder();
        File file = new File(filePath);
        FileInputStream jsonObjectReader = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(jsonObjectReader, 200);
        int ch;
        while ((ch=bufferedInputStream.read()) != -1) {
            jsonObject.append((char)ch);
        }
        return jsonObject.toString().replaceAll("\n", "");
    }
}
