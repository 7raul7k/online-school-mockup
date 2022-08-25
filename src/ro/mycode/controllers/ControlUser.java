package ro.mycode.controllers;

import ro.mycode.models.Student;
import ro.mycode.models.Teacher;
import ro.mycode.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {
    ArrayList<User> users;
    public ControlUser(){
        this.users = new ArrayList<>();
        this.load();
    }
    public void load(){
        try {
            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\students.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text = scanner.nextLine();
                switch (text.split(",")[5]){
                    case "student":
                        this.users.add(new Student(text));
                        break;
                    case "profesor":
                        this.users.add(new Teacher(text));
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void describeUser(){
        for (User m : users){
            if(m instanceof Student){
                System.out.println(m.descriere());
            }else if(m instanceof Teacher){
                System.out.println(m.descriere());
            }
        }
    }

    public int findUserbyName(String name){
        for (int i = 0; i <= users.size()-1;i++){
            if(users.get(i).getFirstName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void createUser(User newUser ){
        int pos = findUserbyName(newUser.getFirstName());
        if(pos == -1){
            this.users.add(newUser);
        }

    }
    public int sizeUser(){
        return users.size();
    }

    public void deleteUser(String fName){
        int pos = findUserbyName(fName);
        if(pos != -1){
            this.users.remove(pos);
        }
    }

    public String toSave(){


        String text="";
        for(int i = 0 ; i <users.size();i++){

            text+=users.get(i).toSave()+"\n";

        }

        return text;

    }

    public void save(){
       try {
         File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\students.txt");
         FileWriter fileWriter = new FileWriter(file);
           PrintWriter printWriter = new PrintWriter(fileWriter);
           printWriter.print(this);
           printWriter.close();

           }catch (Exception e){

           e.printStackTrace();

       }

        }

    }
