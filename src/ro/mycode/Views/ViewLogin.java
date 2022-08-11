package ro.mycode.Views;

import ro.mycode.controllers.absolete;
import ro.mycode.models.User;

import java.util.Scanner;

public class ViewLogin {

    private absolete controlStudent;
    Scanner scanner;

    public ViewLogin(){
        this.controlStudent= new absolete();
        this.scanner= new Scanner(System.in);

    }
    public void menu(){
        System.out.println("Apasati tasta 1 pentru a va loga ");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
    }
    public void play(){
        boolean running = true;
        while (running){
            menu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1 : loginStudent();
                break;
                case 2 : registerStudent();
                break;

            }
        }

    }
    public void loginStudent(){
        System.out.println("Introduceti emailul: ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String parola = scanner.nextLine();


         User user = this.controlStudent.studentLogin(email,parola);

         if(user !=null){

             ViewStudent viewStudent=  new ViewStudent(user);

             viewStudent.play();
         }
    }
    public void registerStudent(){

        System.out.println("Introduceti numele studentului");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele studentului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti emailul ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String parola = scanner.nextLine();
        System.out.println("Introduceti varsta");
        int varsta = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti tipul: student/profesor:");
        String tip = scanner.nextLine();

        if(controlStudent.verifyEmail(email) == true){
            System.out.println("Acest email exista");
        }else{
            User user = new User(controlStudent.generateID(),nume,prenume,email,varsta,tip);
            controlStudent.createStudent(user);
            System.out.println("V-ati inregistrat cu succes!");
        }

    }
}
