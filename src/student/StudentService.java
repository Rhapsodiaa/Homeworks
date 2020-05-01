package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentService {
    static double calculateAverage(List<Integer> grades){
        int sum = 0;
        for(Integer i : grades){
            sum+=i;
        }
        return sum / grades.size();
    }

    static double calculateTotalAverage(Map<Student, List<Integer>> studentToGrades){
        int sum = 0;
        int amount = 0;
        for(List<Integer> s : studentToGrades.values()){
            sum+=calculateAverage(s);
            amount ++;
        }
        return sum/amount;
    }

    //tu sie zacielam
    static Student findBestStudent(Map<Student, List<Integer>> studentToGrades){
        for(Map.Entry<Student, List<Integer>> entry : studentToGrades.entrySet()) {

            if (entry.getValue().equals(2))
                return entry.getKey();
        }
                    /*for (Map.Entry<K, V> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();*/
        //metoda zwraca studenta z najlepszą średnią
        return null;
    }
}