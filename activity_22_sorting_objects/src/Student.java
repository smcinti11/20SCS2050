/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Motaimport java.util.*;
 * Description: Activity 22 - Student class
 */

public class Student implements Comparable<Student> {

    private int    id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "(" + id + ", '" + name + "')";
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }
}

