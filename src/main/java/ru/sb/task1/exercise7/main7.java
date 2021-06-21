package ru.sb.task1.exercise7;

import ru.sb.task1.entity.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class main7 {
    private static List<Person> personList = new ArrayList<>();
    private static TreeSet<Person> personTreeSet = new TreeSet(Person.COMPARE_BY_PERSON);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;
        String firstName;
        String lastName;
        System.out.println("Menu:");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Show sotred unique person");
        System.out.println("4.Save to file");
        System.out.println("5.Exit");

        while (true) {
            word = scan.nextLine();
            switch (word) {
                case "1" :
                    firstName = scan.next();
                    lastName = scan.next();
                    addPerson(new Person(firstName, lastName));
                    break;
                case "2" :
                    showPerson();
                    break;
                case "3" :
                    showSortedUniquePerson();
                    break;
                case "4" :
                    saveToFile(personList);
                    break;
                case "5" :
                    System.exit(0);
            }
        }
    }

    private static void addPerson(Person person) {
        personList.add(person);
    }

    private static void showPerson() {
        System.out.println(personList.toString());
    }

    private static void showSortedUniquePerson() {
        for (Person p : personList) {
            personTreeSet.add(p);
        }
        System.out.println(personTreeSet.toString());
    }

    private static void saveToFile(List<Person> personList) {
        File file = new File("/Users/u19215114/Downloads/Task1Sber/src/main/java/ru/sb/task1/exercise7/File.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(String.valueOf(personList));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
