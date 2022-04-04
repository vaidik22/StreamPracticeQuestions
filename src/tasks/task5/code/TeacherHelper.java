package tasks.task5.code;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeacherHelper {
    public List<Teacher> findSubjectTeacher(List<Teacher> allTeachers, String subjectName) {
        return allTeachers.stream()
                .filter(e -> e.getSubjects().contains(subjectName))
                .toList();
    }


    public Set<Teacher> getBusyTeachers(List<Teacher> allTeachers) {
        Predicate<Teacher> predicate = teacher -> teacher.getSubjects().size() >= 3;
        return allTeachers.stream().filter(predicate)
                .peek(e -> e.setTeacherSalary(e.getTeacherSalary() + e.getTeacherSalary() * 0.05))
                .collect(Collectors.toSet());
    }
}

