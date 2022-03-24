package tasks.task2.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task2.code.TestResultGenerator;

import java.util.HashSet;

class TestResultGeneratorTest {
    private TestResultGenerator creator;
    @BeforeEach
    void setUp() {
        creator = new TestResultGenerator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    short getDetailsOfFailedStudents() {
        Assertions.assertEquals(getDetailsOfFailedStudents(), creator.getDetailsOfFailedStudents(new HashSet<>()));
        return 0;
    }

    @Test
    short sortStudentsForRanking() {
        return 0;
    }
}