package tasks.task2.code;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private byte RollNumber;
    private final String name;
    private final long guardianContactNumber;
    private double marks;

    public Student(byte classRollNumber) {
        this.name = "Nobita Nobi";
        this.guardianContactNumber = 123456789L;
        this.marks = 0.0;

    }

    public Student(byte RollNumber, String name, long guardianContactNumber, double marks) {
        this.RollNumber = RollNumber;
        this.name = name;
        this.guardianContactNumber = guardianContactNumber;
        this.marks = marks;
    }

    public byte getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(byte rollNumber) {
        RollNumber = rollNumber;
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
        return RollNumber == student.RollNumber && guardianContactNumber == student.guardianContactNumber && Double.compare(student.marks, marks) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RollNumber, name, guardianContactNumber, marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "RollNumber=" + RollNumber +
                ", name='" + name + '\'' +
                ", guardianContactNumber=" + guardianContactNumber +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.marks, o.marks);
    }
}