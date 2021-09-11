package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Animal;
import hse.projects.taskone.entities.Street;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public void Write(Street street) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("streets.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
