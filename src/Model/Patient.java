package Model;

public class Patient {
    private int patientId;
    private String password;
    private String name;
    private int age;
    private String email;
    private String contact;

    //constructor
    public Patient(int patientId,String password, String name, int age, String email,String contact){
        this.patientId=patientId;
        this.password=password;
        this.name=name;
        this.age=age;
        this.email=email;
        this.contact=contact;
    }

    //getters
    public int getPatientId(){return patientId;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
    public String getContact(){return contact;}
    public String getPassword(){return password;}

    //setters
    public void setPatientId(int patientId){this.patientId=patientId;}
    public void setName(String name){this.name=name;}
    public void setAge(int age){this.age=age;}
    public void setEmail(String email){this.email=email;}
    public void setContact(String contact){this.contact=contact;}
    public void setPassword(String password){this.password=password;}

    // Overriding toString Method
    public String toString(){
        return "Id: "+patientId+" | Name: "+name+" | Age "+age+" | Email: "+email+" | Contact: "+contact;
    }
}
