package tasks.task2.main;

import tasks.task2.code.Student;
import tasks.task2.code.TestResultGenerator;

import java.util.HashSet;
import java.util.Set;

public class Task2Main {
    public static void main(String[] args) {
        Student student1 = new Student((byte) 30, "Prajjwal",
                8273159427L, 34.0);
        Student student2 = new Student((byte) 35, "Sachin",
                1611161164L, 8.0);
        Student student3 = new Student((byte) 49, "Vaidik",
                56116166651L, 30.0);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);

        TestResultGenerator generator = new TestResultGenerator();

        HashSet<String> failedStudentsSet = generator.getDetailsOfFailedStudents(studentSet);
        failedStudentsSet.forEach(System.out::println);

        HashSet<Student> studentSet2 = new HashSet<>();
        studentSet2.add(student1);
        studentSet2.add(student2);
        studentSet2.add(student3);

        Set<Student> studentsSortedSet = generator.sortStudentsForRanking(studentSet2);
        studentsSortedSet.forEach(System.out::println);
    }
}