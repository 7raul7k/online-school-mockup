package ro.mycode.controllers;
import ro.mycode.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {
    private ArrayList<Enrolment> enrolmentList;

    public ControlEnrolment() {

        this.enrolmentList = new ArrayList<>();
        this.loadEnrolment();

    }

    public void loadEnrolment() {

        try {

            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\enrolment.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                this.enrolmentList.add(new Enrolment(scanner.nextLine()));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public ArrayList<Enrolment> returnAllEnrolments(int studentID) {

        ArrayList<Enrolment> enrolments = new ArrayList<>();

        for (int i = 0; i < enrolmentList.size(); i++) {
            if (enrolmentList.get(i).getStudentID() == studentID) {
                enrolments.add(enrolmentList.get(i));
            }
        }
        return enrolments;
    }

    public int findByID(int id) {
        int pos = 0;
        for (int i = 0; i < enrolmentList.size(); i++) {
            if (enrolmentList.get(i).getStudentID() == id) {
                return i;

            }

        }
        return -1;
    }
    public int findByCourse(int studentID,int courseID){
        for(int i = 0;i < enrolmentList.size();i++){
            if(enrolmentList.get(i).getStudentID() == studentID)
            {
                if(enrolmentList.get(i).getCourseID() == courseID){
                    return i;
                }
            }

        }
        return -1;


    }

    public void addEnrolment(Enrolment newEnrolment) {
        int pos = findByID(newEnrolment.getId());
        if (pos == -1) {
            this.enrolmentList.add(newEnrolment);
        }


    }


    public void removeEnrolment(int studentID, int courseID) {

        for(int i = 0;i <= enrolmentList.size()-1 ;i++){

            if(enrolmentList.get(i).getCourseID() == courseID && enrolmentList.get(i).getStudentID() == studentID){

                enrolmentList.remove(i);

            }
        }

    }

public void updateStudentID(int ID,int studentID){
    int pos = findByID(ID);
    if(pos != -1)
    {
        Enrolment m = this.enrolmentList.get(pos);
        m.setStudentID(studentID);


    }


}

public  Enrolment findEnrolmentByStudentCourseId(int studentId,int courseId){

         for(Enrolment enrolment:enrolmentList){

              if(enrolment.getStudentID()==studentId&&enrolment.getCourseID() == courseId){

                  return  enrolment;
              }
         }

         return null;

}
public void updateCourseID(int studentId,int courseId,int newCourseID){


         Enrolment enrolment=findEnrolmentByStudentCourseId(studentId,courseId);

         if(enrolment != null) {

             enrolment.setCourseID(newCourseID);

         }
}



private int[] frecVentaCursuri() {

         int[] frecventaCursuri= new int[100000];

        for(Enrolment e:enrolmentList){

             frecventaCursuri[e.getCourseID()]++;

        }

        return  frecventaCursuri;

}

public int coursewithMostStudents(){

        int[] cursuri = this.frecVentaCursuri();
        int course = 0,max = 0;

        for(int i = 0 ;i < cursuri.length - 1;i++){

            if(cursuri[i] > max){

                course = i;
                max = cursuri[i];

            }

        }

        return course;

    }

public int courseswithFewestStudents(){

        int[] courses = this.frecVentaCursuri();
        int cursuri = 0,max = 99;

        for(int i = 0; i < courses.length - 1 ;i ++){

            if(courses[i] < max && courses[i] > 0){

                max = courses[i];
                cursuri = i;

            }

        }

        return cursuri;
    }

    public int enrolmentGenerateID(){

      return this.enrolmentList.isEmpty()?1:this.enrolmentList.get(this.enrolmentList.size()-1).getStudentID()+1;

    }
    public ArrayList<Enrolment> returnEnrolmentbyCourse(int id){

       ArrayList<Enrolment> enrolments= new ArrayList<>();

        for(Enrolment m : enrolmentList) {

            if(m.getCourseID() == id){

                enrolments.add(m);

            }

        }

        return enrolments;

    }


public int Size(){

        return enrolmentList.size();

    }

public boolean findbyIDStudent(int enrolmentID,int studentID ){

        for (int i = 0; i < enrolmentList.size() ;i++){

            if(enrolmentList.get(i).getStudentID() == studentID && enrolmentList.get(i).getId() == enrolmentID ){

                return true;

            }

        }

        return false;

    }

public boolean findCourseID(int studentID,int courseID){

        for(int i = 0 ;i <= enrolmentList.size() -1 ;i++){

            if(enrolmentList.get(i).getStudentID() == studentID && enrolmentList.get(i).getCourseID() == courseID){

                return true;

            }

        }

        return false;

    }


public boolean findStudentbyCourse(int idStudent,int courseId){

        ArrayList<Enrolment> enrolments = returnEnrolmentbyCourse(courseId);

        for(int i = 0 ; i <= enrolments.size() -1 ;i++){

            if(enrolments.get(i).getStudentID() == idStudent){

                return true;

            }

        }

        return false;

    }
    public String toString(){
        String text ="";
        for (int i = 0 ; i <= enrolmentList.size();i++){
            text += enrolmentList.get(i).toString() +"\n";
        }
        return text;
    }
    public void save(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\enrolment.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}