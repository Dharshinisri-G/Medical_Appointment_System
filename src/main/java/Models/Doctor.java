package Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Doctor extends User {
    private int DoctorID;
    public Doctor(){}
    public Doctor(@JsonProperty("UserId") int UserId,
                   @JsonProperty("UserRole") String UserRole,
                   @JsonProperty("UserName") String UserName,
                   @JsonProperty("Password") String Password,
                   @JsonProperty("Name") String Name,
                   @JsonProperty("email") String email,
                   @JsonProperty("Contact") String Contact,
                   @JsonProperty("Gender") String Gender,
                   @JsonProperty("DateOfBirth") String DateOfBirth,
                   @JsonProperty("Address") String Address,
                   @JsonProperty("Age") int Age,
                   @JsonProperty("DoctorID") int DoctorID){
        super(UserId,UserRole,UserName,Password,Name,email,Contact,Gender,DateOfBirth,Address,Age);
        this.DoctorID=DoctorID;
    }
    public int getDoctorID(){return DoctorID;}
    public void setDoctorID(int DoctorID){this.DoctorID=DoctorID;}
    public String toString(){
        return super.toString()+"DoctorID :"+DoctorID;
    }
}