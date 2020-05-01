package student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private String mainLanguage;

    public Student(String firstName, String lastName, String mainLanguage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainLanguage = mainLanguage;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + mainLanguage;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Jan", "Nowak", "PL");
        Student student2 = new Student("Emilia", "K", "PL");
        Student student3 = new Student("Nikola", "Tesla", "ENG");

        List<Integer> student1grades = List.of(2,3,3,2);
        List<Integer> student2grades = List.of(4,4,3,5);
        List<Integer> student3grades = List.of(5,4,3,2);

        Map<Student,List<Integer>> studentsMap = new HashMap<>();
        studentsMap.put(student1,student1grades);
        studentsMap.put(student2,student2grades);
        studentsMap.put(student3,student3grades);

        studentsMap.entrySet().forEach(s->{
            System.out.println(s.getKey().toString() + " 0- " + s.getValue());
        });

        System.out.println("średnia kazdego osobno");
        studentsMap.values().forEach(e-> System.out.println(StudentService.calculateAverage(e)));
        System.out.println("srednia wszystkich");
        System.out.println(StudentService.calculateTotalAverage(studentsMap));

        System.out.println("najlepszy student");
        StudentService.findBestStudent(studentsMap);

    }
}
