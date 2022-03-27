package tasks.task5.code;

import java.util.List;
import java.util.Objects;

public class Teacher {
    private final String teacherID;
    private final String teacherName;
    private Double teacherSalary;
    private List<String> subjects;

    public Teacher() {
        this.teacherName = "Divyansh Bharadwaj";
        this.teacherID = String.valueOf(132465);
        this.teacherSalary = 100000.0;
        for (List<String> subject : List.of(subjects)) {
            subject.add("Java");
        }


    }

    public Teacher(String teacherID, String teacherName, Double teacherSalary, List<String> subjects) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherSalary = teacherSalary;
        this.subjects = subjects;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(Double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherID, teacher.teacherID) && Objects.equals(teacherName, teacher.teacherName) && Objects.equals(teacherSalary, teacher.teacherSalary) && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherID, teacherName, teacherSalary, subjects);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID='" + teacherID + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSalary=" + teacherSalary +
                ", subjects=" + subjects +
                '}';
    }
}
