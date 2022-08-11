package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.User;

import static org.junit.jupiter.api.Assertions.*;

class absoleteTest extends ControlEnrolment {

    @Test
    public void createStudent() {
        absolete controlStudent = new absolete();
        User user = new User(23,"Stefan","Marinescu","stefanmarinescu@gmail.com",18,"elev");
        int initialSize = controlStudent.getSize();

        controlStudent.createStudent(user);

        assertEquals(initialSize+1,controlStudent.getSize());

    }

    @Test
    public void deleteStudent() {
        absolete controlStudent = new absolete();
        int initialsize = controlStudent.getSize();
        controlStudent.deleteStudent("David");

        assertEquals(initialsize-1,controlStudent.getSize());
    }

    @Test
    public void updateFnameTest(){
        absolete controlStudent = new absolete();
        controlStudent.updateFName("Alexandru","Marcu");
        assertEquals(false,controlStudent.findFirstName("David","Alexandru"));
        assertEquals(true,controlStudent.findFirstName("Marcu","Alexandru"));
    }

    @Test
    public void updateLNameTest(){
        absolete controlStudent = new absolete();
        controlStudent.updateLName("David","Cosmin");
        assertEquals(false,controlStudent.findbyLastName("Alexandru","alexandrudavid@gmail.com"));
        assertEquals(true,controlStudent.findbyLastName("David","alexandrudavid@gmail.com"));
    }

    @Test
    public void testUpdateEmail(){
        absolete controlStudent = new absolete();

        controlStudent.updateEmail("David","daviddavid@gmail.com");
        assertEquals(false,controlStudent.findByEmail("David","alexandrudavid@gmail.com"));
        assertEquals(true,controlStudent.findByEmail("David","daviddavid@gmail.com"));


    }

    @Test
    public void testUpdateAge(){
        absolete controlStudent = new absolete();
        controlStudent.updateAge("David",26);
        assertEquals(false,controlStudent.findByAge("David",22));
        assertEquals(true,controlStudent.findByAge("David",26));

    }
    @Test
    public void verifyEmailTest(){
        absolete controlStudent = new absolete();
        assertEquals(true,controlStudent.verifyEmail("davidcraciun@gmail.com"));
        assertEquals(false,controlStudent.verifyEmail("eduardeduard@gmail.com"));


        assertEquals(true,controlStudent.findByEmail("Craciun","davidcraciun@gmail.com"));
    }





}