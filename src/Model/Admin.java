package Model;

public class Admin {
    //private static Admin instance;
    private int adminId;
    private String password;
    private String name;
    private int age;
    private String email;
    private String contact;

    public Admin(int adminId,String password,String name,int age,String email,String contact){
        this.adminId=adminId;
        this.password=password;
        this.name=name;
        this.age=age;
        this.email=email;
        this.contact=contact;
    }


    public int getAdminId(){return adminId;}
    public String getPassword(){return password;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
    public String getContact(){return contact;}

    public void setAdminId(int adminId){this.adminId=adminId;}
    public void setName(String name){this.name=name;}
    public void setAge(int age){this.age=age;}
    public void setEmail(String email){this.email=email;}
    public void setPassword(String password){this.password=password;}
    public void setContact(String contact){this.contact=contact;}

    public String toString(){
        return "AdminId: "+adminId+" | Name: "+name+" | Age: "+age+" | Contact: "+contact+" | Email: "+email;
    }
}
