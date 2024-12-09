package com.gmail.axelwerst;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, 4.5));
        students.add(new Student("Bob", 22, 3.8));
        students.add(new Student("Charlie", 19, 4.9));
        students.add(new Student("Diana", 21, 4.0));
        students.add(new Student("Ethan", 23, 3.6));

        List<Student> lowGradeStudents = students.stream()
                .filter(student -> student.getGrade() < 4.0)
                .collect(Collectors.toList());
        System.out.println("Студенти з середньою оцінкою менше 4.0:");
        lowGradeStudents.forEach(System.out::println);


        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getGrade));
        System.out.println("\nСтудент з найвищою оцінкою:");
        topStudent.ifPresent(System.out::println);

        long countOlderThan20 = students.stream()
                .filter(student -> student.getAge() > 20)
                .count();
        System.out.println("\nКількість студентів старших за 20 років: " + countOlderThan20);

        List<String> sortedNames = students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("\nІмена студентів, відсортовані за середньою оцінкою у спадному порядку:");
        sortedNames.forEach(System.out::println);

        boolean hasPerfectGrade = students.stream()
                .anyMatch(student -> student.getGrade() == 5.0);
        System.out.println("\nЧи є студент із середньою оцінкою 5.0: " + hasPerfectGrade);

        System.out.println("\nІмена студентів із оцінкою більше ніж 4.0:");
        students.stream()
                .filter(student -> student.getGrade() > 4.0)
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
