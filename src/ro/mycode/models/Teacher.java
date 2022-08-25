package ro.mycode.models;

public class Teacher extends User{
    private String domeniu;

    public Teacher(int id, String firstName, String lastName, String email, int age,String tip,String domeniu){
        super(id, firstName, lastName, email, age, tip);
        this.domeniu = domeniu;
    }

    public Teacher(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.domeniu = proprietes[6];
    }

    @Override
    public String descriere(){
        String text="";
        text += "ID: " + super.getId();
        text += "\nFirst name: " + super.getFirstName();
        text += "\nLast name: " + super.getLastName();
        text += "\n Email: " + super.getEmail();
        text += "\n Age: " + super.getAge();
        text += "\n Tip: " + super.getTip();
        text += "\n===========================================\n";
        return text;
    }

    @Override
    public String toSave(){
        return super.getId() + "," + super.getFirstName() + "," + super.getLastName() + "," + super.getEmail() + "," + super.getAge() + "," + super.getTip();

    }



}
