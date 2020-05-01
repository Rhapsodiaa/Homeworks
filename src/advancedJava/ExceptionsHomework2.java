package advancedJava;

import java.util.Scanner;

import static advancedJava.ExceptionsHomework.checkPassword;

public class ExceptionsHomework2 {
    //2. Napisz metodę main, która pobierze od użytkownika stringa i sprawdzi, czy
//podane hasło jest poprawne. Jeżeli metoda checkPassword rzuci wyjątek, należy go
//obsłużyc w bloku try-catch.
    /*Jeżeli chodzi o metodę main, to tak jak napisałaś powinna korzystać z metody checkPassword (wywoływać ją z hasłem wpisanym przez użytkownika z konsoli,
    które jest pobierane od niego przez użycie klasy Scanner).
Warto stworzyć swoje klasy wyjątków i rzucać różne w jeżeli hasło jest za krótkie, nie zwiera znaku specjalnego, albo dużej litery.
Wyjątki powinny być "wyłapywane" w metodzie main za pomocą bloku try-catch.*/

    public static void main(String[] args) {
        System.out.println("Wpisz haslo");
        Scanner scanner = new Scanner(System.in);
        String userPassword = scanner.nextLine();

        try{
            checkPassword(userPassword);
        }catch (IllegalArgumentException e){
            System.out.println("Haslo musi posiadać przynajmniej jedną wielką literę!");
        }catch (IncorrectNumberOfSigns e){
            System.out.println("Haslo musi byc dluzsze niz 8 znakow!");
        }catch(IncorrectNumberOfSpecialSigns e){
            System.out.println("Haslo musi posiadać przynajmniej jeden znak specjalny!");
        }
    }

    public static class IncorrectNumberOfSigns extends Exception{
        public IncorrectNumberOfSigns(String errorMessage){
            super(errorMessage);
        }
    }

    public static class IncorrectNumberOfSpecialSigns extends Exception{
        public IncorrectNumberOfSpecialSigns(String errorMessage){
            super(errorMessage);
        }
    }
}
