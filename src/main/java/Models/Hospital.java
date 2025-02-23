package Models;

public class Hospital {
  private int HospitalId;
  private String HospitalName;
  private String Location;
  private String Contact;

  public Hospital(){}
  public Hospital(int HospitalId,String HospitalName,String Location,String Contact){
      this.HospitalId=HospitalId;
      this.HospitalName=HospitalName;
      this.Location=Location;
      this.Contact=Contact;
  }

  public void setHospitalId(int hospitalId){HospitalId=hospitalId;}
  public void setHospitalName(String hospitalName){HospitalName=hospitalName;}
  public void setLocation(String location){Location=location;}
  public void setContact(String contact){Contact=contact;}

  public int getHospitalId(){return HospitalId;}
  public String getHospitalName(){return HospitalName;}
  public String getLocation(){return Location;}
  public String getContact(){return Contact;}

  public String toString(){
      return "HospitalId: "+HospitalId+", HospitalName: "+HospitalName+", Location: "+Location+", Contact: "+Contact;
  }
}
