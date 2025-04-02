package Controller;
import Model.Appointment;

import java.util.*;
public class AppointmentController {
    private List<Appointment> appointmentList;

    public AppointmentController(){
        appointmentList=new ArrayList<>();
    }

    public void addAppointment(int appointmentid,int doctorid,int patientid,String date){
        Appointment appointment=new Appointment(appointmentid,doctorid,patientid,date);
        appointmentList.add(appointment);
        System.out.println("Appointment Successfully Booked!");
    }

    public void viewAppointments(){
        for(Appointment appointment:appointmentList){
            System.out.println(appointment);
        }
    }

    public void viewAppointmentsWithId(int id){
        for(Appointment appointment:appointmentList){
            if(appointment.getAppointmentId()==id){
                System.out.println(appointment);
                return;
            }
        }
        System.out.println("No appointment exist with that id");
    }

    public void deleteAppointmentWithId(int id){
        Iterator<Appointment> i=appointmentList.iterator();
        while(i.hasNext()){
            Appointment appointment=i.next();
            if(appointment.getAppointmentId()==id){
                appointmentList.remove(appointment);
                return;
            }
        }
        System.out.println("No appointment exist with that id");
    }

    public void updateAppointmentWithId(int id,String date){
        for(Appointment appointment:appointmentList){
            if(appointment.getAppointmentId()==id){
                appointment.setDate(date);
                return;
            }
        }
        System.out.println("No appointment exist with that id");
    }

    public void viewAppointmentsWithPatientId(int id) {
        int c=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getPatientId()==id) {
                System.out.println(appointment);
                c++;
            }
        }
        if(c>0)
        return;
        System.out.println("No appointment exist with that id");
    }

    public void viewAppointmentsWithDoctorId(int id) {
        int c=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getDoctorId()==id) {
                System.out.println(appointment);
                c++;
            }
        }
        if(c>0)
            return;
        System.out.println("No appointment exist with that id");
    }
}
