package tasks.task3.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeLeaveCalculator {
    public List<Short> getDefaulterEmployeeIDList(List<Employee> employeeList) {
        return employeeList.stream().filter(Employee -> Employee.getLeaveTaken() < 25)
                .distinct()
                .map(Employee::getEmployeeId)
                .toList();
    }

    private String getDetails(Employee employee) {
        return employee.getEmployeeName() + "-" + employee.getLeaveTaken();
    }

    public ArrayList<String> getNumberOfLeaves(List<Employee> employeeList) {
        return employeeList.stream()
                .map(this::getDetails)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
