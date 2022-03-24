package tasks.task2.code;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestResultGenerator {
    public Set<String> getDetailsOfFailedStudents(HashSet<Student> studentSet) {
        return studentSet.stream().filter(Student -> Student.getMarks() < 30.0)
                .map(this::getDetails)
                .collect(Collectors.toSet());
    }

    private String getDetails(Student student) {
        return student.getName() + "-" + student.getGuardianContactNumber();
    }


    public Set<Student> sortStudentsForRanking(HashSet<Student> studentSet) {
        return studentSet.stream().sorted()
                .sorted(Comparator.comparingInt(Student::getRollNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
