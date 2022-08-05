package ro.mycode.models;

public class Enrolment {
    private int id;
    private int studentID;
    private int courseID;

    public Enrolment(int id,int studentID,int courseID){

        this.id = id;
        this.studentID = studentID;
        this.courseID = courseID;

    }
    public Enrolment(String text){

        String[] proprietati = text.split(",");

        this.id = Integer.parseInt(proprietati[0]);
        this.studentID = Integer.parseInt(proprietati[1]);
        this.courseID = Integer.parseInt(proprietati[2]);

    }

    public String showEnrolment(){

        String text= "";

        text+= "ID: " + id;
        text+= "\n Student ID: " + studentID;
        text+= "\n Course ID: " + courseID;
        text+= "\n======================================\n";

        return  text;

    }

    public int getId() {

        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentID() {

        return studentID;

    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
