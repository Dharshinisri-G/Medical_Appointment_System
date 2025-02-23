package Models;

import Services.FileStorage;

public class Appointment {
    private int AppointmentId;
    private int PatientId;
    private int DoctorId;
    private String Date;
    private String Time;
    private String Status;
    public Appointment(){}
    public Appointment(int AppointmentId,int PatientId,int DoctorId,String Date,String Time,String Status){
        this.AppointmentId=AppointmentId;
        this.Date=Date;
        this.Status=Status;
        this.PatientId=PatientId;
        this.DoctorId=DoctorId;
        this.Time=Time;
    }

    public int getAppointmentId() {return AppointmentId;}
    public int getPatientId(){return PatientId;}
    public int getDoctorId(){return DoctorId;}
    public String getDate(){return Date;}
    public String getTime(){return Time;}
    public String getStatus(){return Status;}

  //  public void setAppointmentId(){int AppointmentId= FileStorage.getNextAppointmentId();}
    public void setPatientId(int patientId){PatientId=patientId;}
    public void setDoctorId(int doctorId){DoctorId=doctorId;}
    public void setDate(String date){Date=date;}
    public void setTime(String time){Time=time;}
    public void setStatus(String status){Status=status;}

    public String toString(){
        return "AppointmentId: "+AppointmentId+", PatientId: "+PatientId+", DoctorId: "+DoctorId+", Date: "+Date+", Time: "+Time+", Status: "+Status;
    }
}
