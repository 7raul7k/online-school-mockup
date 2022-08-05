package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Enrolment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlEnrolmentTest extends ControlEnrolment {


    @Test
    public void returnEnrolment(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.returnAllEnrolments(1001);

    }
    @Test
    public void addTest(){
        ControlEnrolment controlEnrolment = new ControlEnrolmentTest();
        Enrolment enrolment = new Enrolment(enrolmentGenerateID(),1001,1007);
        int size = controlEnrolment.Size();
        controlEnrolment.addEnrolment(enrolment);
        assertEquals(size+1,controlEnrolment.Size());

    }

    @Test
    public void removeTest(){
        ControlEnrolment controlEnrolment = new ControlEnrolmentTest();
        int size = controlEnrolment.Size();
        controlEnrolment.removeEnrolment(44,1004);
        assertEquals(size-1,controlEnrolment.Size());
    }

    @Test
    public void updateStudentIDTest(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();

        controlEnrolment.updateStudentID(11,1100);

        assertEquals(false,controlEnrolment.findbyIDStudent(1,11));
        assertEquals(true,controlEnrolment.findbyIDStudent(1,1100));


    }

    @Test
    public void updateCourseID(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.updateCourseID(33,1001,1003);
        assertEquals(false,controlEnrolment.findCourseID(33,1001));
        assertEquals(true,controlEnrolment.findCourseID(33,1003));


    }

    @Test
   public void coursewithmorestudent(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.coursewithMostStudents();
    }

    @Test
    public void coursewithfeweststudents(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.courseswithFewestStudents();
    }

    @Test

    public void courseWithMostStudents(){
        ControlEnrolment controlEnrolment = new ControlEnrolment();
        int studenti = controlEnrolment.coursewithMostStudents();

        assertEquals(studenti,controlEnrolment.coursewithMostStudents());

    }







}