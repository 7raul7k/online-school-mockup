package ro.mycode.models;

public class Course {
    private int id;
    private String name;
    private String department;

    private String numeProfesor;
    private String prenumeProfesor;
    public Course(int id ,String name,String department){

        this.id = id ;
        this.name = name;
        this.department = department;

    }
    public Course(){}
    public Course(String text){
        String[] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.name = proprietati[1];
        this.department = proprietati[2];
        this.numeProfesor = proprietati[3];
        this.prenumeProfesor = proprietati[4];

    }

    public String showCourse(){

        String text = "";

        text+= "Name of Course: " + name ;
        text+= "\n Department: " + department;
        text+= "\n Nume profesor:" + numeProfesor;
        text+= "\n Prenume profesor" + prenumeProfesor;
        text+="\n ===================================================\n";

        return text;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }

    public String getPrenumeProfesor() {
        return prenumeProfesor;
    }

    public void setPrenumeProfesor(String prenumeProfesor) {
        this.prenumeProfesor = prenumeProfesor;
    }

    public String toSave(){
        return id + "," + name + "," + department + ",";
    }
}
