package edu.sdccd.cisc191;

public class Student {
    private final String name;
    private final double gpa;
    private final int id;

    public Student(String name, double gpa, int id) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student must have a valid name.");
        } else {
            this.name = name;
        }

        if (gpa < 0f || gpa > 4f) {
            throw new IllegalArgumentException("Student GPA must be between 0.0-4.0.");
        } else {
            this.gpa = gpa;
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than one.");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getGpa() {
        return this.gpa;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        // E.g. Student{id=1, name='John', gpa=2.5}
        return String.format(
            "%s{id=%d, name='%s', gpa=%.2f}",
            this.getClass().getSimpleName(), this.id, this.name, this.gpa
        );
    }
}
