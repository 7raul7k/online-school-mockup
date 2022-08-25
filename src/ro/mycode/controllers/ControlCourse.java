package ro.mycode.controllers;
import ro.mycode.models.Course;
import ro.mycode.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCourse {

    private ArrayList<Course> courseList;

    public ControlCourse() {

        this.courseList = new ArrayList<>();
        this.loadCourse();

    }

    public int coursesize() {
        return courseList.size();
    }

    public void loadCourse() {

        try {

            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\course.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                this.courseList.add(new Course(scanner.nextLine()));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String showCourse() {

        String text = "";

        for (int i = 0; i < courseList.size(); i++) {

            text += courseList.get(i).getId() + " ";
            text += courseList.get(i).getName() + "\n";

        }
        return text;
    }


    public int findbyName(String name) {
        int pos = 0;
        for (int i = 0; i < courseList.size(); i++) {
            if (this.courseList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addCourse(Course newCourse) {
        int pos = findbyName(newCourse.getName());
        if (pos == -1) {
            this.courseList.add(newCourse);
        }

    }

    public void deleteCourse(String name) {
        int pos = findbyName(name);
        if (pos == 0) {
            this.courseList.remove(pos);

        }

    }

    public Course returnCourseById(int courseID) {
        for (int i = 0; i < courseList.size(); i++) {

            if (courseList.get(i).getId() == courseID) {
                return courseList.get(i);

            }
        }
        return null;


    }

    public int courseGenerateID() {

        return this.courseList.isEmpty() ? 1 : this.courseList.get(this.courseList.size() - 1).getId() + 1;

    }

    public Course returnIDbyName(String name) {
        return findbyName(name) != -1 ? this.courseList.get(findbyName(name)) : null;

    }

    public Course findCoursebyName(String name) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getName().equals(name)) {
                return courseList.get(i);

            }
        }
        return null;

    }

    public boolean findCourseName(String name) {
        for (Course m : courseList) {
            if (m.getName().equals(name)) {
                return true;
            }

        }
        return false;

    }

    public String toString() {
        String text = "";
        for (int i = 0; i <= courseList.size(); i++) {
            text += courseList.get(i).toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\OOP\\OnlineSchool\\src\\ro\\mycode\\resources\\course.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

