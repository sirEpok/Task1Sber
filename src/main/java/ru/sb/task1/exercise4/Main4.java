package ru.sb.task1.exercise4;

import ru.sb.task1.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String firstName;
        String lastName;

        while (true) {
            firstName = scan.next();
            if (firstName.equals("exit")) {
                break;
            }
            lastName = scan.next();
            personList.add(new Person(firstName, lastName));
        }

        personList.sort(Person.COMPARE_BY_PERSON);

        System.out.println(personList.toString());
    }
}
