package ro.mycode.Views;

import ro.mycode.controllers.ControlCourse;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.models.Course;
import ro.mycode.models.Enrolment;
import ro.mycode.models.User;

import java.util.ArrayList;
import java.util.Scanner;


public class ViewProfesor {
    private ControlCourse controlCourse;
    private ControlEnrolment enrolment;

    Scanner scanner = new Scanner(System.in);
    private User user;
    public ViewProfesor(){
        this.user = new User();
        this.controlCourse = new ControlCourse();
        this.enrolment = new ControlEnrolment();
    }
    public void menu(){
        System.out.println("Apasati 1 pentru a vedea studentii inscrisi la curs");
        System.out.println("Apasati 2 pentru a creea un curs");
        System.out.println("Apasati 3 pentru a sterge un curs");
    }
    public void play(){
        boolean running = true;
        while (running){
            menu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1: studentiPrezentiCurs();
                break;
                case 2: crearecursNou();
                break;
                case 3: stergerecurs();
                break;
            }
        }
    }
    public void studentiPrezentiCurs(){
        System.out.println("Numele cursului");
        String  courseName= scanner.nextLine();
        Course course=controlCourse.findCoursebyName(courseName);
        ArrayList<Enrolment> student = enrolment.returnEnrolmentbyCourse(course.getId());
        for(Enrolment e : student){
            System.out.println(this.controlCourse.returnCourseById(e.getStudentID()));
        }

    }
    public void crearecursNou(){}
    public void stergerecurs(){}
}
