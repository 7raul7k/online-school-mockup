package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Student;
import ro.mycode.models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlUserTest {

    @Test
    public void test1(){
     ControlUser controlUser = new ControlUser();
     controlUser.describeUser();
    }
    @Test
    public void toSaveTest(){
        ControlUser controlUser = new ControlUser();

        System.out.println(controlUser.toSave());

    }

    @Test
    public void addUser(){

        ControlUser controlUser = new ControlUser();
        int size = controlUser.sizeUser();
        User user = new User(231,"Ionescu","Denis","denisionescu@gmail.com",23,"student");
        controlUser.createUser(user);
        assertEquals(size+1,controlUser.sizeUser());
    }

    @Test
    public void deleteUser(){
        ControlUser controlUser = new ControlUser();
        int size = controlUser.sizeUser();
        controlUser.deleteUser("David");
        assertEquals(size-1, controlUser.sizeUser());
    }
}
