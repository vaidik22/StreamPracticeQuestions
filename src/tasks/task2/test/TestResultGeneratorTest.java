package tasks.task2.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task2.code.Student;
import tasks.task2.code.TestResultGenerator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Set.of;

class TestResultGeneratorTest {
    private TestResultGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new TestResultGenerator();
    }

    @AfterEach
    void tearDown() {
    }

    private Student createFakeStudent() {
        Faker faker = new Faker(new Locale("en-IND"));
        return new Student((byte) faker.number().numberBetween(1, 80), faker.name().fullName(),
                Long.parseLong(faker.number().digits(10)), faker.number().numberBetween(0, 100));
    }

    private Set<Student> createSetOfFakeStudents(int number) {
        Set<Student> fakeStudentSet = new HashSet<>();
        for (int index = 0; index < number; index++) {
            fakeStudentSet.add(createFakeStudent());
        }
        return fakeStudentSet;
    }

    @Test
    void createEmptySetOfFailedStudents() {
        var expected = Set.of();
        Set<Student> studentSet = of();
        var actual = generator.getDetailsOfFailedStudents(studentSet);
        Assertions.assertEquals(expected, actual, "Method should be able to create empty set");
    }

    @Test
    void getDetailsOfFailedStudents() {
        var fakeStudentSet = createSetOfFakeStudents(10);
        var expected = fakeStudentSet.stream().filter(student -> student.getMarks() < 33.0)
                .map(student -> student.getName().concat("-").concat(String.valueOf(student.getGuardianContactNumber())))
                .collect(Collectors.toCollection(HashSet::new));
        var actual = generator.getDetailsOfFailedStudents(fakeStudentSet);
        Assertions.assertEquals(expected, actual, "May be they are not failed");
    }

    private HashSet<Student> createHashSetOfFakeStudents(int number) {
        HashSet<Student> fakeStudentSet = new HashSet<>();
        for (int index = 0; index < number; index++) {
            fakeStudentSet.add(createFakeStudent());
        }
        return fakeStudentSet;
    }

    @Test
    void sortStudentsForRanking() {
        var fakeStudentSet = createHashSetOfFakeStudents(10);
        Comparator<Student> markSorting = Comparator.comparingDouble(Student::getMarks);
        var expected = generator.sortStudentsForRanking(fakeStudentSet).stream()
                .sorted(markSorting).collect(Collectors.toSet());
        var actual = generator.sortStudentsForRanking(fakeStudentSet);
        Assertions.assertEquals(expected, actual, "Not sorted Set");
    }
}