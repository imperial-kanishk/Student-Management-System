package util;

import entities.Student;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void save(ArrayList<Student> students) {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("students.txt"))) {

            for(Student s : students) {

                bw.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getGrade() + "," +
                                String.join("|", s.getSubjects())
                );

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }
}