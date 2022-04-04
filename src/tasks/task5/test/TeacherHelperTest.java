package tasks.task5.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5.code.Teacher;
import tasks.task5.code.TeacherHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TeacherHelperTest {

    TeacherHelper teacherHelper;

    @BeforeEach
    void setUp() {
        teacherHelper = new TeacherHelper();
    }

    @AfterEach
    void tearDown() {
    }

    private Teacher createFakeTeacher() {
        Faker faker = new Faker(new Locale("en-IND"));
        List<String> subjects = new ArrayList<>();
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            subjects.add(faker.book().genre());
        }
        return new Teacher(String.valueOf(faker.number().randomNumber()), faker.name().fullName(),
                (double) faker.number().randomNumber(), subjects);
    }

    private List<Teacher> createFaKeListOfTeachers(int number) {
        List<Teacher> teacherList = new ArrayList<>();

        for (int index = 0; index < number; index++) {
            teacherList.add(createFakeTeacher());
        }
        return teacherList;
    }

    @Test
    void findSubjectTeacher() {
    }

    @Test
    void getBusyTeachers() {
    }
}