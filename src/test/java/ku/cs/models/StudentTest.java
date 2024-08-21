package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//method ที่ใช้เอาไว้เปรียบเทียบการเท่ากันของค่าสองค่า

/*@BeforEach คือทำเมธอดนี้ก่อนจึงจะทำอันอื่นทุกครั้ง*/
class StudentTest {
    private Student s;
    @BeforeEach
    void setUp() {
       s = new Student("6xxxxxxxx", "StudentTest");
    }
    @Test
    void testAddScore(){
        //Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals(0, s.getScore());
        s.addScore(40.5);
        //ค่า expected is a value that we want to know and after that is an actual value
        assertEquals(40.5, s.getScore());
        s.addScore(10);
        //ถ้าสมมติผิดก็จะขึ้นเป็น
        //assertEquals(60, s.getScore());
        /* test fail
           Expected :60.0
           Actual   :50.5*/
        //ถ้าถูกจะขึ้นเป็น
        assertEquals(50.5, s.getScore());
        /*test passed*/

        //เช็คกรณีที่บวกด้วยค่าติดลบ
        s.addScore(-10);
        /*assertEquals(40.5, s.getScore(), "Score should not decrease with negative values");
        test failed
        org.opentest4j.AssertionFailedError: Score should not decrease with negative values ==>
            Expected :40.5
            Actual   :50.5
        */
        assertEquals(50.5, s.getScore());
    }
    //การทำงานของแต่ละเทสทำงานแยกกันเมื่อทำงานเสร็จก็จะเคลียร์ข้อมูลในเมโมรี่ทิ้ง
    @Test
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("Test changing name")
    void testChangeName() {
        Student s = new Student("6xxxxxxxx", "OldName");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());

        s.changeName("  ");
        assertEquals("NewName", s.getName(), "Name should not change if the new name is empty or only whitespace");
    }

    @Test
    @DisplayName("Test ID comparison")
    void testIsId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxx"));
        assertFalse(s.isId("7xxxxxxxx"), "ID comparison should return false for different IDs");
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 75.5);
        String expectedString = "{id: '6xxxxxxxx', name: 'StudentTest', score: 75.5}";
        assertEquals(expectedString, s.toString());
    }



    /*@Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }*/
}