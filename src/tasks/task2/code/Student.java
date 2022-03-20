package tasks.task2.code;

import java.util.Objects;

public class Student {
    private final byte classRollNumber;
    private final String name;
    private final long guardianContactNumber;
    private double marks;

    public Student(byte classRollNumber, String name, long guardianContactNumber, double marks) {
        this.classRollNumber = classRollNumber;
        this.name = name;
        this.guardianContactNumber = guardianContactNumber;
        this.marks = marks;
    }

    public byte getClassRollNumber() {
        return classRollNumber;
    }

    public String getName() {
        return name;
    }

    public long getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return classRollNumber == student.classRollNumber && guardianContactNumber == student.guardianContactNumber && Double.compare(student.marks, marks) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classRollNumber, name, guardianContactNumber, marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "classRollNumber=" + classRollNumber +
                ", name='" + name + '\'' +
                ", guardianContactNumber=" + guardianContactNumber +
                ", marks=" + marks +
                '}';
    }
}
