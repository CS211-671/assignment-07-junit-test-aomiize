package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList s;

    @BeforeEach
    void setUp() {
        s = new StudentList();
    }

    @Test
    void testAddNewStudentWithoutScore() {
        s.addNewStudent("6xxxxxxxx1", "a");
        assertEquals(1, s.getStudents().size());

        Student student = s.getStudents().get(0);
        assertEquals("6xxxxxxxx1", student.getId());
        assertEquals("a", student.getName());
        assertEquals(0, student.getScore());
    }

    @Test
    @DisplayName("Test adding a new student with a score")
    void testAddNewStudentWithScore() {
        s.addNewStudent("6xxxxxxxx2", "b", 75.5);
        assertEquals(1, s.getStudents().size());

        Student student = s.getStudents().get(0);
        assertEquals("6xxxxxxxx2", student.getId());
        assertEquals("b", student.getName());
        assertEquals(75.5, student.getScore());
    }

    @Test
    @DisplayName("Test finding a student by ID")
    void testFindStudentById() {
        s.addNewStudent("6xxxxxxxx3", "c");
        Student found = s.findStudentById("6xxxxxxxx3");
        assertNotNull(found);
        assertEquals("c", found.getName());
    }

    @Test
    @DisplayName("Test finding a student by ID that doesn't exist")
    void testFindStudentByIdNotFound() {
        Student found = s.findStudentById("6xxxxxxx70");
        assertNull(found);
    }

    @Test
    @DisplayName("Test giving a score to a student by ID")
    void testGiveScoreToId() {
        s.addNewStudent("6xxxxxxxx4", "d");
        s.giveScoreToId("6xxxxxxxx4", 20.0);

        Student student = s.findStudentById("6xxxxxxxx4");
        assertEquals(20.0, student.getScore());
    }

    @Test
    @DisplayName("Test viewing the grade of a student by ID")
    void testViewGradeOfId() {
        s.addNewStudent("6xxxxxxxx5", "e", 85.0);
        String grade = s.viewGradeOfId("6xxxxxxxx5");
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("Test viewing the grade of a student by ID that doesn't exist")
    void testViewGradeOfIdNotFound() {
        String grade = s.viewGradeOfId("6xxxxxxxx70");
        assertNull(grade);
    }
}
