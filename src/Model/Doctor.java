package Model;

public class Doctor {
    private int doctorId;
    private String password;
    private String name;
    private int age;
    private String email;
    private String contact;
    private String specialization;
    private int slot;

    public Doctor(int doctorId,String password,String name,int age,String email,String contact,String specialization,int slot){
        this.doctorId=doctorId;
        this.password=password;
        this.name=name;
        this.age=age;
        this.email=email;
        this.contact=contact;
        this.specialization=specialization;
        this.slot=slot;
    }

    public int getDoctorId(){return doctorId;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
    public String getContact(){return contact;}
    public String getSpecialization(){return specialization;}
    public int getSlot(){return slot;}
    public String getPassword(){return password;}

    public void setDoctorId(int doctorId){this.doctorId=doctorId;}
    public void setName(String name){this.name=name;}
    public void setAge(int age){this.age=age;}
    public void setEmail(String email){this.email=email;}
    public void setContact(String contact){this.contact=contact;}
    public void setSpecialization(String specialization){this.specialization=specialization;}
    public void setSlot(int slot){this.slot=slot;}
    public void setPassword(String password){this.password=password;}

    public String toString(){
        return "DoctorId: "+doctorId+" | Name: "+name+" | Age: "+age+" | Email: "+email+" | Contact: "+contact+" | Specialization: "+specialization+" | Slot: "+slot;
    }
}
