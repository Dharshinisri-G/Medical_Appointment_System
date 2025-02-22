package Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Admin extends User {
    private int AdminID;
    public Admin(){}
    public Admin(@JsonProperty("UserId") int UserId,
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
                  @JsonProperty("AdminID") int AdminID){
        super(UserId,UserRole,UserName,Password,Name,email,Contact,Gender,DateOfBirth,Address,Age);
        this.AdminID=AdminID;
    }
    public int getAdminID(){return AdminID;}
    public void setAdminID(int AdminID){this.AdminID=AdminID;}
    public String toString(){
        return super.toString()+"AdminID :"+AdminID;
    }
}