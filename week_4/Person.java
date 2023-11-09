package TU_Java.week_4;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private LocalDate birth;
    private int age;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
        this.age = LocalDate.now().getYear() - birth.getYear();
    }

    public static void main(String[] args) {
        final String inputFilePath = "C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_4\\info.txt";
        final String path2 = "C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_4\\Output.txt";

        List<Person> peopleList = readPeopleFromFile(inputFilePath);

        if (!peopleList.isEmpty()) {
            System.out.println("People from the file:");
            for (Person person : peopleList) {
                System.out.println("Name: " + person.name);
                System.out.println("Birth Date: " + person.birth);
                System.out.println("Age: " + person.age);
                System.out.println();
            }
        } else {
            System.out.println("No people found in the file.");
        }

        try (FileOutputStream fileOutput = new FileOutputStream(path2)) {
            for (Person person : peopleList) {
                String personInfo = "Name: " + person.name + "\n" +
                        "Birth Date: " + person.birth + "\n" +
                        "Age: " + person.age + "\n\n";
                fileOutput.write(personInfo.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> readPeopleFromFile(String inputFilePath) {
        List<Person> peopleList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    LocalDate birth = LocalDate.parse(parts[1].trim());
                    peopleList.add(new Person(name, birth));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFilePath);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return peopleList;
    }

}
