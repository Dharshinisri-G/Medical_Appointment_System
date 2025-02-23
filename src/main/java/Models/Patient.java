package Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Patient extends User {
    private int PatientID;
    public Patient(){}
    public Patient(@JsonProperty("UserId") int UserId,
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
                   @JsonProperty("PatientID") int PatientID){
        super(UserId,UserRole,UserName,Password,Name,email,Contact,Gender,DateOfBirth,Address,Age);
        this.PatientID=PatientID;
    }
    public int getPatientID(){return PatientID;}
    public void setPatientID(int patientID){PatientID=patientID;}
    public String toString(){
        return super.toString()+"PatientID :"+PatientID;
    }
}
