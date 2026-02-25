package edu.sdccd.cisc191;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAnalyzer {
    static List<Student> filter(List<Student> students, StudentFilter filter) {
        return students.stream()
            .filter(filter::test)
            .toList();
    }

    static void sort(List<Student> students, Comparator<Student> comparator) {
        students.sort(comparator);
    }

    static double averageGpa(List<Student> students) {
        return students.isEmpty() ? 0d : students.stream() // Return zero if List is empty
            .collect(Collectors.averagingDouble(Student::getGpa));
    }
}
