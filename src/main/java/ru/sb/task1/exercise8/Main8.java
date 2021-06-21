package ru.sb.task1.exercise8;

import ru.sb.task1.entity.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main8 {
    private static List<Person> personList = new ArrayList<>();
    private static TreeSet<Person> personTreeSet = new TreeSet(Person.COMPARE_BY_PERSON);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
    }

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;
    }

    private static class Menu {
        private List<MenuItem> items = new ArrayList<>();
        private Service service = new Service();


        public Menu(Scanner scanner) {
            MenuItem menuItem = new MenuItem();
            menuItem.name = "1.Add";
            menuItem.exec = personList -> {
                String firstName = scanner.next();
                String lastName = scanner.next();
                service.addPerson(new Person(firstName, lastName));
            };
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "2.Show";
            menuItem.exec = personList -> service.showPerson();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "3.Show sotred unique person";
            menuItem.exec = personList -> service.showSortedUniquePerson();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "4.Save to file";
            menuItem.exec = personList -> {
                service.saveToFile(personList);
            };
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "5.Read to file";
            menuItem.exec = personList -> {
                service.readToFile();
            };
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "5.Exit";
            menuItem.exec = personList -> System.exit(0);
            items.add(menuItem);

//            menuItem = new MenuItem();
//            menuItem.name = "clear";
//            menuItem.exec = personList -> service.clearDataInMemory(personList);
//            items.add(menuItem);



            items.forEach(element -> System.out.println(element.name));

            while (true) {
                String command = scanner.nextLine();
                for (MenuItem item : items) {
                    if (item.name.equalsIgnoreCase(command)) {
                        try {
                            item.exec.exec(personList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Service {
        private void addPerson(Person person) {
            personList.add(person);
        }

        private void showPerson() {
            System.out.println(personList.toString());
        }

        private void showSortedUniquePerson() {
            for (Person p : personList) {
                personTreeSet.add(p);
            }
            System.out.println(personTreeSet.toString());
        }

        private void saveToFile(List<Person> personList) {
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
}

