package ro.mycode.Views;

import ro.mycode.controllers.ControlCourse;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.models.Course;
import ro.mycode.models.Enrolment;
import ro.mycode.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private ControlCourse controlCourse;
    private ControlEnrolment controlEnrolment;
    Scanner scanner = new Scanner(System.in);
    private User user;
    public ViewStudent(User user){

        this.user = user;
        this.controlCourse= new ControlCourse();
        this.controlEnrolment = new ControlEnrolment();

    }
    public void menu(){

        //toate cursurile la care este inscris
        //sa se inscrie la un curs
        //sa se dezaboneze de  la curs
        // statistici ? cursul cu cei mai multi studenti

        System.out.println("Press 1 to show courses");
        System.out.println("Press 2 to show enrolled course");
        System.out.println("Press 3 to enrolle a course");
        System.out.println("Press 4 to unfollow a course");
        System.out.println("Press 5 to show a course with most students");
        System.out.println("Press 6 to show a course with fewest students");

    }

    public void play(){

        boolean running = true;

        while(running == true){

            menu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){

                case 1:
                    System.out.println(controlCourse.showCourse());
                    break;
                default:menu();
                case 2:enrolledStudentCourse();
                break;
                case 3:enrolleCourse();
                break;
                case 4:unfollowCourse();
                break;
                case 5: mostStudent();
                break;
                case 6: fewestCourses();
                break;
            }
        }
    }

    private void enrolledStudentCourse(){
        System.out.println("Input a student ID");
        int studentID = Integer.parseInt(scanner.nextLine());
        ArrayList<Enrolment> enrolments=controlEnrolment.returnAllEnrolments(studentID);
        for (Enrolment e :enrolments){
            System.out.println(this.controlCourse.returnCourseById(e.getCourseID()).getName());
        }

    }

    private void enrolleCourse(){
        System.out.println("Introduceti numele cursului ");
        String numeCurs = scanner.nextLine();
       Course curs = controlCourse.returnIDbyName(numeCurs);
       controlEnrolment.addEnrolment(new Enrolment(controlEnrolment.enrolmentGenerateID(),this.user.getId(),curs.getId()));

    }

    private void unfollowCourse(){
        System.out.println("Input a student ID");
        int studentID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter course ID");
        int courseID = Integer.parseInt(scanner.nextLine());
        controlEnrolment.removeEnrolment(studentID,courseID);
    }

    private void mostStudent(){

        System.out.println("Courses with most students is " + controlEnrolment.coursewithMostStudents());

    }

   private void fewestCourses(){

        System.out.println("Courses with most students is " + controlEnrolment.courseswithFewestStudents());

    }

}
