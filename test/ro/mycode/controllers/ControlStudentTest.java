package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.User;

import static org.junit.jupiter.api.Assertions.*;

class ControlStudentTest extends ControlEnrolment {

    @Test
    public void createStudent() {
        ControlStudent controlStudent = new ControlStudent();
        User user = new User(23,"Stefan","Marinescu","stefanmarinescu@gmail.com",18,"elev");
        int initialSize = controlStudent.getSize();

        controlStudent.createStudent(user);

        assertEquals(initialSize+1,controlStudent.getSize());

    }

    @Test
    public void deleteStudent() {
        ControlStudent controlStudent = new ControlStudent();
        int initialsize = controlStudent.getSize();
        controlStudent.deleteStudent("David");

        assertEquals(initialsize-1,controlStudent.getSize());
    }

    @Test
    public void updateFnameTest(){
        ControlStudent controlStudent = new ControlStudent();
        controlStudent.updateFName("Alexandru","Marcu");
        assertEquals(false,controlStudent.findFirstName("David","Alexandru"));
        assertEquals(true,controlStudent.findFirstName("Marcu","Alexandru"));
    }

    @Test
    public void updateLNameTest(){
        ControlStudent controlStudent = new ControlStudent();
        controlStudent.updateLName("David","Cosmin");
        assertEquals(false,controlStudent.findbyLastName("Alexandru","alexandrudavid@gmail.com"));
        assertEquals(true,controlStudent.findbyLastName("David","alexandrudavid@gmail.com"));
    }

    @Test
    public void testUpdateEmail(){
        ControlStudent controlStudent = new ControlStudent();

        controlStudent.updateEmail("David","daviddavid@gmail.com");
        assertEquals(false,controlStudent.findByEmail("David","alexandrudavid@gmail.com"));
        assertEquals(true,controlStudent.findByEmail("David","daviddavid@gmail.com"));


    }

    @Test
    public void testUpdateAge(){
        ControlStudent controlStudent = new ControlStudent();
        controlStudent.updateAge("David",26);
        assertEquals(false,controlStudent.findByAge("David",22));
        assertEquals(true,controlStudent.findByAge("David",26));

    }
    @Test
    public void verifyEmailTest(){
        ControlStudent controlStudent = new ControlStudent();


        assertEquals(true,controlStudent.findByEmail("Craciun","davidcraciun@gmail.com"));
    }




}