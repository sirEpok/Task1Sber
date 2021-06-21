package ru.sb.task1.exercise1;

import ru.sb.task1.entity.Person;

public class Main1 {
    public static void main(String[] args) {
        String firstName = args[0];//Сделано таким образом, т.к. известно что будет 2 входных параметра
        String lastName = args[1];
        Person p1 = new Person(firstName, lastName);
        System.out.println(p1.toString());
    }
}
