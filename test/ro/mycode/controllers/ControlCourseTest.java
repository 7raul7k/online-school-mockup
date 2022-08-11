package ro.mycode.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Course;

import static org.junit.jupiter.api.Assertions.*;

class ControlCourseTest extends ControlCourse {

    @Test
    void testCoursesize() {
        ControlCourse controlCourse = new ControlCourse();
        int size = controlCourse.coursesize();
        assertEquals(size,controlCourse.coursesize());
    }

    @Test
    public void testAddCourse() {
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(controlCourse.courseGenerateID(),"Programare in Java","Informatica");
        int size = controlCourse.coursesize();
        controlCourse.addCourse(course);
        assertEquals(size+1,controlCourse.coursesize());

    }

    @Test
    public void testDeleteCourse() {
        ControlCourse controlCourse = new ControlCourse();
        int size = controlCourse.coursesize();
        controlCourse.deleteCourse("Analiza Matematica");

         assertEquals(size-1,controlCourse.coursesize());
    }




    @Test
    public void findbynameTest(){
        ControlCourse controlCourse = new ControlCourse();
        assertEquals(true,controlCourse.findCourseName("Limba engleza"));
        assertEquals(false,controlCourse.findCourseName("Limba franceza"));

    }

    @Test
    public void returnCourseByIdTest() {
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(1006, "Limba engleza", "Engleza");
        int id = course.getId();


        assertEquals(id, controlCourse.returnCourseById(1006).getId());
        assertEquals(null,controlCourse.returnCourseById(1123));
    }

    @Test
    public void returnIDByNameTest(){
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(1006, "Limba engleza", "Engleza");
        assertEquals(null,returnIDbyName("Limba franceza"));
        assertEquals(course.getId(),returnIDbyName("Limba engleza").getId());

    }
    @Test
    public void findCourseByNameTest(){
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(1006, "Limba engleza", "Engleza");
        assertEquals(course.getId(),controlCourse.findCoursebyName("Limba engleza").getId());
        assertEquals(null,controlCourse.findCoursebyName("Limba franceza"));
    }




}