package advancedJava;

import java.util.*;

public class CollectionsHomework {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        System.out.println(evenIndexes(integers));

        List<Integer> integers2 = List.of(5, 5, 2, 2, 2, 2);
        System.out.println(withoutDuplicates(integers2));

        List<String> listOfStrings = List.of("ala", "ma", "kota");
        System.out.println(mapFromList(listOfStrings));

        Person person = new Person("Jan", "Nowak");
        HashMap<String, Person> mapOfPeselsAndLastNames = new HashMap<>();
        mapOfPeselsAndLastNames.put("12345678",person);
        countTheSameLastNames(mapOfPeselsAndLastNames);

    }

    /*Napisz metodę, która przyjmie Listę intów i zwróci Listę, która zawiera
elementy o parzystych indeksach.*/
    public static ArrayList<Integer> evenIndexes(ArrayList<Integer> arrayList) {

        ArrayList<Integer> evenIndexes = new ArrayList<Integer>();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (i % 2 == 0)
                evenIndexes.add(i);
        }
        return evenIndexes;
    }

    /*Napisz metodę, która przyjmie Listę (np. intów) i zwróci listę, która nie zawiera
duplikatów.*/
    public static List<Integer> withoutDuplicates(List<Integer> arrayList) {
        List<Integer> newListWithoutDuplicates = new ArrayList<Integer>();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            Integer current = arrayList.get(i);
            if (!newListWithoutDuplicates.contains(current)) {
                newListWithoutDuplicates.add(current);
            }
        }

        return newListWithoutDuplicates;
    }

    /*Napisz metodą, która przyjmie Listę stringów i zwróci mapę, której kluczami są
indeksy, natomiast wartościami elementy listy.*/
    public static Map<Integer, String> mapFromList(List<String> stringList) {
        HashMap<Integer, String> mapOfIndexesAndElements = new HashMap<Integer, String>();
        Integer index = 0;
        String value = "";
        for (int i = 0; i < stringList.size(); i++) {
            index = i;
            value = stringList.get(i);
            mapOfIndexesAndElements.put(index, value);
        }
        return mapOfIndexesAndElements;
    }

    /*Napisz metodę, która przyjmie Mapę, gdzie kluczami jest PESEL człowieka,
natomiast wartością typ Person(imię, nazwisko) i zwróci mapę, której kluczami
jest obiekt String reprezentujący nazwisko, natomiast wartością liczba mówiąca
ile razy osoba o danym nazwisku występuje w mapie zadanej w parametrze.*/
    public static HashMap<String, Integer> countTheSameLastNames(HashMap<String, Person> mapOfPeselsAndPersons) {
        HashMap<String, Integer> mapOfSameLastNames = new HashMap<String, Integer>();
        String lastName = mapOfPeselsAndPersons.get(mapOfPeselsAndPersons).getLastName();
        Integer sameLastNameCounter = 0;
        mapOfSameLastNames.put(lastName, sameLastNameCounter);

        for (int i = 0; i < mapOfPeselsAndPersons.size(); i++) {
            lastName.compareTo(mapOfPeselsAndPersons.get(mapOfPeselsAndPersons).lastName);

        }
        for(Map.Entry<String,Person> entry : mapOfPeselsAndPersons.entrySet()){
            System.out.println("key: " + entry.getKey() + " wartosc: " + entry.getValue());
            //if()
        }
        return mapOfSameLastNames;
    }

    static class Person {
        private String name;
        private String lastName;

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public int compareTo(Person person){
            return this.name.compareTo(person.name);
        }
    }
}