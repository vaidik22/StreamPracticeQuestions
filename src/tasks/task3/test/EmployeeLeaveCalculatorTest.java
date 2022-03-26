package tasks.task3.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task3.code.Employee;
import tasks.task3.code.EmployeeLeaveCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class EmployeeLeaveCalculatorTest {
    private EmployeeLeaveCalculator employeeLeaveCalculator;

    @BeforeEach
    void setUp() {
        employeeLeaveCalculator = new EmployeeLeaveCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    private Employee createFakeEmployee() {
        Faker faker = new Faker(new Locale("en-IND"));
        return new Employee((short) faker.number().numberBetween(100, 999), faker.name().fullName(),
                faker.number().randomDouble(2, 30000, 50000),
                (byte) faker.number().numberBetween(0, 30));
    }

    private List<Employee> createListOfFakeEmployees(int number) {
        List<Employee> employeeList = new ArrayList<>();
        for (int index = 0; index < number; index++) {
            employeeList.add(createFakeEmployee());
        }
        return employeeList;
    }

    @Test
    void getDefaulterEmployeeIDList() {
        var fakeEmployeeList = createListOfFakeEmployees(10);
        var expected = fakeEmployeeList.stream().filter(e -> e.getLeaveTaken() > 25)
                .distinct()
                .map(Employee::getEmployeeId).toList();
        var actual = employeeLeaveCalculator.getDefaulterEmployeeIDList(fakeEmployeeList);
        Assertions.assertEquals(expected, actual, "any non defaulter");
    }

    @Test
    void getNumberOfLeaves() {
        var fakeEmployeeList = createListOfFakeEmployees(10);
        var expected = fakeEmployeeList.stream()
                .map(employee -> employee.getEmployeeName().concat("-").concat(String.valueOf(employee.getLeaveTaken())))
                .toList();
        var actual = employeeLeaveCalculator.getNumberOfLeaves(fakeEmployeeList);
        Assertions.assertEquals(expected, actual, "wrong info");
    }
}