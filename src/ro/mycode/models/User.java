package ro.mycode.models;

import com.sun.tools.jconsole.JConsoleContext;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;

    private String tip;

    public User(int id, String firstName, String lastName, String email, int age,String tip) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.tip = tip;

    }


    public User(String text){

        String[] proprietati=text.split(",");

        this.id=Integer.parseInt(proprietati[0]);
        this.firstName = proprietati[1];
        this.lastName = proprietati[2];
        this.email =  proprietati[3];
        this.age = Integer.parseInt(proprietati[4]);
        this.tip = proprietati[5];

    }
    public String descriere(){

        String text ="";
        text+="First name: " + firstName;
        text+="\nLast Name: " + lastName;
        text+= "\nEmail: " + email;
        text+= "\nAge: " + age;
        text+= "\nTip: " + tip;
        text+= "\n==================================== \n";
        return text;

    }
    public User(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.email+2022;
    }

    public void setPassword(String text){ this.password = password;}

    public void setTip(String tip){ this.tip = tip;}
    public String getTip(){return tip;}
    public String toSave(){
        return  firstName + "," + lastName + "," + email + "," + age + "," + id;
    }

}