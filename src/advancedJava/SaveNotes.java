package advancedJava;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*Napisz program, który pobiera od użytkownika notatkę, a następnie zapisuje ją do pliku tekstowego. Użytkownik podczas startu programu powinien mieć
również możliwość zobaczenia wszystkich swoich notatek w konsoli.*/
public class SaveNotes {
    public static void main(String[] args) throws IOException {

        String fileName = "notatki.txt";

        FileWriter fw = new FileWriter(fileName,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice!=3) {
            System.out.println("Co chcesz zrobic?\n1. Dodaj notatke \n2. Wyswietl notatki \n3. Opusc program");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNote(bufferedWriter);
                    break;
                case 2:
                    showNotes();
                    break;
                default:
                    break;
            }
        }
    }

    public static void addNote(BufferedWriter bufferedWriter) throws IOException {

        LocalDateTime actualTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = actualTime.format(dateFormat);

        System.out.println("Wpisz swoja notatke na dzien " + formattedDate);
        Scanner s = new Scanner(System.in);

        try {
            String note = s.nextLine();
            bufferedWriter.write(formattedDate + ": \n" + note+"\n");
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna dostac sie do pliku " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Nie mozna zapisac pliku " + e.getMessage());
        }
    }

    public static void showNotes() throws IOException {
        String line = null;
        String fileName = "notatki.txt";
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fr);
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        }catch (FileNotFoundException ex){
            System.out.println("Cant open file " + fileName);
        }catch (IOException ex){
            System.out.println("Error reading file " + fileName);
        }
    }
}