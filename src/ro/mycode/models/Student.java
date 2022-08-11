package ro.mycode.models;

public class Student extends User {
    private int anStudiu;

    public Student(int id, String firstName, String lastName, String email, int age,String tip,int anStudiu){
        super(id, firstName, lastName, email, age, tip);
        this.anStudiu = anStudiu;
    }

    public Student(String text){
        super(text);
        String[]proprietes = text.split(",");
        this.anStudiu = Integer.parseInt(proprietes[6]);
    }
    @Override
    public String descriere(){
        String text = "";
        text += "ID: " + super.getId();
        text += "\n First name: "+ super.getFirstName();
        text += "\n Last name: " + super.getLastName();
        text += "\n Email: " + super.getEmail();
        text += "\n Age: " + super.getAge();
        text += "\n Tip: " + super.getTip();
        text += "\n===================================\n";
        return text;
    }

    @Override
    public String toSave(){
        return super.getId() + "," + super.getFirstName() + "," + super.getLastName() + "," + super.getEmail() + "," +super.getAge() + "," + super.getTip();
    }

}
