package ro.mycode.controllers;

import org.junit.jupiter.api.Test;

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
}
