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

    }



}