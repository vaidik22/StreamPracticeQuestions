package tasks.task3.code;

import java.util.Objects;

public class Employee {
    private short employeeId;
    private String employeeName;
    private double employeeSalary;
    private byte leaveTaken;

    public Employee() {
        this.employeeId = (short) 191500892;
        this.employeeName = "Vaidik Nigam";
        this.employeeSalary = 30_000;
        this.leaveTaken = 0;
    }

    public Employee(short employeeId, String employeeName, double employeeSalary, byte leaveTaken) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.leaveTaken = leaveTaken;
    }

    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public byte getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(byte leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Double.compare(employee.employeeSalary, employeeSalary) == 0 && leaveTaken == employee.leaveTaken && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, employeeSalary, leaveTaken);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", leaveTaken=" + leaveTaken +
                '}';
    }
}

