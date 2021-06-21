package ru.sb.task1.exercise2;

import ru.sb.task1.entity.Person;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        System.out.println(new Person(firstName, lastName));
    }
}
