package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
         List<Student> students = List.of(
            new Student("Michael",  3.5, 10),
            new Student("Skylar",   2.7, 47),
            new Student("Ahmed",    3.3, 5),
            new Student("Courtney", 3.7, 16),
            new Student("Quinn",    1.4, 23),
            new Student("Alex",     4.0, 31)
        );

        System.out.printf(
            "Supplied Students (Original):\n%s\n\n",
            getStudentsAsLines(students)
        );

        List<Student> studentsAbove3p0 = StudentAnalyzer.filter(students,
            s -> s.getGpa() > 3.0
        );

        System.out.printf(
            "Students with a GPA above 3.0:\n%s\n\n",
            getStudentsAsLines(studentsAbove3p0)
        );

        // Using List.of() creates an immutable List which will crash the program when sorted.
        // ArrayLists can be modified and do not throw UnsupportedOperationExceptions.
        List<Student> studentsByNameDesc = new ArrayList<>(students);

        // One would typically use Comparator.comparing(...).reversed()
        // However, I must use a lambda.
        StudentAnalyzer.sort(studentsByNameDesc,
            (s1, s2) -> -s1.getName().compareTo(s2.getName())
        );

        System.out.printf(
            "Students by Name, Descending:\n%s\n\n",
            getStudentsAsLines(studentsByNameDesc)
        );

        double gpaAvg = StudentAnalyzer.averageGpa(students);

        System.out.printf("Average student GPA: %.2f\n", gpaAvg);
    }

    /* NOTE: Method made for the sake of demonstration.
     * Would typically place it inside another class, but the class was never explicitly given,
     * so I am trying to cover my grounds by putting it here.
     */

    /**
     * Parses a Student List into a multi-line string, with each line
     * containing a Student::toString representation.
     */
    private static String getStudentsAsLines(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Cannot supply an empty or null Student List.");
        }

        return students.stream()
            .map(Student::toString) // Get students as strings
            .collect(Collectors.joining("\n"));
    }
}