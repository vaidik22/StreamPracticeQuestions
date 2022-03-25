package tasks.task2.code;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestResultGenerator {

    private String studentDetails(Student student) {
        return student.getName().concat("-").concat(String.valueOf(student.getGuardianContactNumber()));
    }

    public HashSet<String> getDetailsOfFailedStudents(Set<Student> studentSet) {
        return studentSet.stream().filter(student -> student.getMarks() < 33.0)
                .map(this::studentDetails).collect(Collectors.toCollection(HashSet<String>::new));
    }

    public Set<Student> sortStudentsForRanking(HashSet<Student> studentSet) {
        Comparator<Student> markSorting = Comparator.comparingDouble(Student::getMarks);

        return studentSet.stream().sorted(markSorting).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}