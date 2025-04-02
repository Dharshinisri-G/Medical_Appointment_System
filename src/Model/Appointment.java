package Model;

public class Appointment {
    private int appointmentId;
    private int doctorId;
    private int patientId;
    private String date;

    public Appointment(int appointmentId,int doctorId,int patientId,String date){
        this.appointmentId=appointmentId;
        this.doctorId=doctorId;
        this.patientId=patientId;
        this.date=date;
    }

    public int getAppointmentId(){return appointmentId;}
    public int getPatientId(){return patientId;}
    public int getDoctorId(){return doctorId;}
    public String getDate(){return date;}

    public void setAppointmentId(int appointmentId){this.appointmentId=appointmentId;}
    public void setPatientId(int patientId){this.patientId=patientId;}
    public void setDoctorId(int doctorId){this.doctorId=doctorId;}
    public void setDate(String date){this.date=date;}

    public String toString(){
        return "AppointmentId: "+appointmentId+" | DoctorId: "+doctorId+" | PatientId: "+patientId+" | Date: "+date;
    }
}
