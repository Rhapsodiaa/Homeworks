package advancedJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsHomework {
    public static void main(String[] args) {
        List<String> strings = List.of("takie","tam","beda","WIELKIMI","literami","i","wyrzuci","krotsze","od","trzech");

        System.out.println(convertToUpperCase(strings));

        Person[] persons = {
                new Person("Jola",52),
                new Person("Franek",17),
                new Person("Zosia",21),
                new Person("Zosia",21)
        };

        List<Person> personList = Arrays.asList(persons);
        System.out.println(getAdultPeopleNames(personList));

    }

    /*1. Napisz metodę, która przyjmie w parametrze listę stringów i za pomocą Java Stream zamieni wszystkie
 napisy na duże litery oraz wyfiltruje słowa krótsze niż 3 znaki i zwróci listę z wynikiem.*/
    public static List<String> convertToUpperCase(List<String> stringList){

        List<String> newStringList = new ArrayList<String>();

        stringList.stream()
                .filter(s -> s.length()>3)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        return newStringList;
    }

    /*2. Mając daną klasę Person(name, age), napisz metodę, która zwróci imiona wszystkich osób (bez powtórzeń), których wiek jest większy od 18.*/
    public static List<String> getAdultPeopleNames(List<Person> persons){
        List<String> names = new ArrayList<String>();


        persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p->p.getName())
                .distinct()
                .collect(Collectors.toList());

        return names;
    }

    static class Person{
        static String name;
        static int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static String getName() {
            return name;
        }

        public static int getAge() {
            return age;
        }
    }
}