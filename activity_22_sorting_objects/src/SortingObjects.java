/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Motaimport java.util.*;
 * Description: Activity 22 - SortingObjects class
 */

import java.io.*;
import java.util.*;

public class SortingObjects {

    private static final String NAMES_FILENAME = "names.txt";

    public static LinkedList<Student> merge(LinkedList<Student> left, LinkedList<Student> right) {
        int i = 0, j = 0;
        LinkedList<Student> sorted = new LinkedList<>();
        while (i < left.size() && j < left.size()) {
            Student leftStudent  = left.get(i);
            Student rightStudent = right.get(j);
            if (leftStudent.compareTo(rightStudent) < 0) {
                sorted.append(leftStudent);
                i++;
            }
            else {
                sorted.append(rightStudent);
                j++;
            }
        }
        while (i < left.size()) {
            Student leftStudent  = left.get(i++);
            sorted.append(leftStudent);
        }
        while (j < right.size()) {
            Student rightStudent  = right.get(j++);
            sorted.append(rightStudent);
        }
        left.clear();
        right.clear();
        return sorted;
    }

    public static LinkedList<Student> mergeSort(LinkedList<Student> students) {
        // base case
        if (students.size() <= 1)
            return students;

        // divide
        int middle = students.size() / 2;
        LinkedList<Student> left = new LinkedList<>();
        for (int i = 0; i < middle; i++)
            left.append(students.get(i));
        LinkedList<Student> right = new LinkedList<>();
        for (int i = middle; i < students.size(); i++)
            right.append(students.get(i));
        students.clear();
        left  = mergeSort(left);
        right = mergeSort(right);

        // conquer (merge)
        LinkedList<Student> sorted = merge(left, right);
        return sorted;
    }

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<Student> students = new LinkedList<>();
        Scanner in = new Scanner(new FileInputStream(NAMES_FILENAME));
        int id = 1;
        while (in.hasNextLine()) {
            String name = in.nextLine();
            Student student = new Student(id, name);
            students.append(student);
            id++;
        }
        in.close();
        System.out.println(students);
        students = mergeSort(students);
        System.out.println(students);
    }
}

