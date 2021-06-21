package ru.sb.task1.exercise3;

import ru.sb.task1.entity.Person;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord;
        String lastWord;

        while (true) {
            firstWord = scan.next();
            if(firstWord.equals("exit")) {
                break;
            }
            lastWord = scan.next();
            System.out.println(new Person(firstWord, lastWord));
        }
    }
}
