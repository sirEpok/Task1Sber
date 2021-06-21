package ru.sb.task1.exercise5;

import ru.sb.task1.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;
        String firstName;
        String lastName;
        System.out.println("Menu:");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Exit");

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
}
