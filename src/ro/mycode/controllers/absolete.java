package ro.mycode.controllers;

import ro.mycode.models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class absolete {
    private ArrayList<User> listUsers;

    public absolete() {

        this.listUsers = new ArrayList<>();
        this.load();

    }

    public void load() {

        try {

            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\students.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {


                this.listUsers.add(new User(scanner.nextLine()));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void showStudent() {

        for (int i = 0; i < listUsers.size(); i++) {

            System.out.println(listUsers.get(i).descriere());

        }

    }

    public int findbyName(String lname) {

        for (int i = 0; i < listUsers.size(); i++) {

            if (this.listUsers.get(i).getLastName().equals(lname)) {

                return i;

            }

        }

        return -1;


    }

    public void createStudent(User newUser) {

        int pos = findbyName(newUser.getFirstName());

        if (pos == -1) {

            this.listUsers.add(newUser);

        }

    }

    public void deleteStudent(String name) {

        int pos = findbyName(name);

        if (pos != -1) {

            this.listUsers.remove(pos);

        }

    }

    public void updateFName(String lastName, String newfName) {

        for (User m : listUsers) {

            if (m.getLastName().equals(lastName)) {

                m.setFirstName(newfName);


            }

        }

    }

    public void updateLName(String fname, String newlName) {

        for(User m : listUsers){

           if (m.getFirstName().equals(fname)){

               m.setLastName(newlName);

           }

        }

    }


    public void updateEmail(String fname, String newEmail) {

        for(User m : listUsers){

            if(m.getFirstName().equals(fname)){

                m.setEmail(newEmail);

            }

        }

        }


    public void updateAge(String fName, int newAge) {
       for(User m : listUsers ){

           if(m.getFirstName().equals(fName)){

               m.setAge(newAge);

           }

       }

        }


    public User studentLogin(String email, String password) {

        for (int i = 0; i < listUsers.size(); i++) {

            if (listUsers.get(i).getEmail().equals(email) && listUsers.get(i).getPassword().equals(password)) {

                return listUsers.get(i);

            }

        }

        return null;
    }

    public int generateID() {

        return this.listUsers.isEmpty() ? 1 : this.listUsers.get(this.listUsers.size() - 1).getId() + 1;

    }


    public boolean verifyEmail(String email) {

        for (int i = 0; i < listUsers.size(); i++) {

            if (listUsers.get(i).getEmail().equals(email)) {

                return true;

            }

        }

        return false;

    }

    public boolean findFirstName(String fName, String lname) {

        for (int i = 0; i <= listUsers.size() - 1; i++) {

            if (listUsers.get(i).getFirstName().equals(fName) && listUsers.get(i).getLastName().equals(lname)) {

                return true;

            }

        }

        return false;

    }

    public int getSize() {

        return listUsers.size();

    }

    public boolean findbyLastName(String lname,String email ){

        for(User m : listUsers){

            if(m.getLastName().equals(lname)){

                return true;

            }

        }

        return false;

    }
    public boolean findByEmail(String fname,String mail){

        for(User m : listUsers){

        if(m.getFirstName().equals(fname) && m.getEmail().equals(mail))

        {

            return true;
        }


    }

    return false;

    }
public boolean findByAge(String fName,int age){

        for(User m : listUsers){

            if(m.getFirstName().equals(fName) && m.getAge() == age){

                return true;

            }

        }

        return false;

}

public boolean verifyLogin(String email,String password) {

    User user = studentLogin(email, password);

    for (int i = 0; i <= listUsers.size() -1 ; i++) {
        if(listUsers.get(i).getEmail().equals(email) && listUsers.get(i).getPassword().equals(password)) {

                return true;

            }

    }

    return false;

}

}

