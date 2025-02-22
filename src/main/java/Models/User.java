package Models;
import Services.FileStorage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
public class User {
    private int UserId;
    private String UserRole;
    private String Password;
    private String UserName;
    private String Name;
    private String email;
    private String Contact;
    private String Gender;
    private String DateOfBirth;
    private String Address;
    private int Age;
    public User(){}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public User(@JsonProperty("UserId") int UserId,
                @JsonProperty("UserRole") String UserRole,
                @JsonProperty("UserName") String UserName,
                @JsonProperty("Password") String Password,
                @JsonProperty("Name") String Name,
                @JsonProperty("email") String email,
                @JsonProperty("Contact") String Contact,
                @JsonProperty("Gender") String Gender,
                @JsonProperty("DateOfBirth") String DateOfBirth,
                @JsonProperty("Address") String Address,
                @JsonProperty("Age") int Age) {
        this.Age = Age;
        this.Address = Address;
        this.Contact = Contact;
        this.UserId = UserId;
        this.UserName = UserName;
        this.email = email;
        this.Password = Password;
        this.DateOfBirth = DateOfBirth;
        this.UserRole = UserRole;
        this.Gender = Gender;
        this.Name = Name;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setUserRole(String userRole) {
        UserRole = userRole;
    }
    public void setContact(String contact) {
        Contact = contact;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getPassword() {
        return Password;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }
    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public int getUserId() {
        return UserId;
    }
    public String getContact() {
        return Contact;
    }
    public String getEmail() {
        return email;
    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }
    public String getAddress() {
        return Address;
    }
    public String getGender() {
        return Gender;
    }
    public int getAge() {
        return Age;
    }
    public String getName() {
        return Name;
    }
    public String getUserRole() {
        return UserRole;
    }
    public static User createUser(){
        Scanner x=new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name=x.nextLine();
        System.out.print("Enter Email: ");
        String email=x.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact=x.nextLine();
        System.out.print("Enter address: ");
        String address=x.nextLine();
        System.out.print("Enter Dob: ");
        String Dob=x.nextLine();
        System.out.print("Enter Gender: ");
        String gender=x.nextLine();
        System.out.print("Enter Age: ");
        int age=x.nextInt();
        x.nextLine();
        System.out.print("UserId: ");
        int id= FileStorage.getNextUserId();
        System.out.println(id);
        System.out.print("Set UserName: ");
        String username=x.nextLine();
        System.out.print("Set Password:");
        String password=x.nextLine();
        System.out.print("Enter User Role:");
        String userRole=x.nextLine();
        User newUser;
        if(userRole.equalsIgnoreCase("Patient")){
            int patientId=FileStorage.getNextPatientId();
            newUser= new Patient(id, userRole, username, password, name, email, contact, gender, Dob, address, age,patientId);
        }
        else if(userRole.equalsIgnoreCase("Doctor")){
            int DoctorId=FileStorage.getNextDoctorId();
            newUser= new Doctor(id, userRole, username, password, name, email, contact, gender, Dob, address, age,DoctorId);
        }
        else if(userRole.equalsIgnoreCase("Admin")){
            int AdminId=FileStorage.getNextAdminId();
            newUser= new Admin(id, userRole, username, password, name, email, contact, gender, Dob, address, age,AdminId);
        }
        else {
            newUser= new User(id, userRole, username, password, name, email, contact, gender, Dob, address, age);
        }
        FileStorage.SaveWithRole(newUser);
        return newUser;
    }
    public void Welcome() {
        System.out.println("Hi "+Name+"! Welcome to the Medical Appointment System");
    }
    @Override
    public String toString() {
        return "User{ " +
                "UserId=" + UserId +
                ", Name='" + Name + '\'' +
                ", Email='" + email + '\'' +
                ", Role='" + UserRole + '\'' +
                " }";
    }

}
