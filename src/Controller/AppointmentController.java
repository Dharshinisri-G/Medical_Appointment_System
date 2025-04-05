package Controller;
import Model.Appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class AppointmentController {
    static DoctorController dc;
    private List<Appointment> appointmentList;
    static final Scanner x=new Scanner(System.in);
    public AppointmentController(DoctorController dc){
        appointmentList=new ArrayList<>();
        this.dc =dc;
    }

    public void addAppointment(int appointmentid,int doctorid,int patientid,String date){
        if(isValid(doctorid,date)){
        Appointment appointment=new Appointment(appointmentid,doctorid,patientid,date);
        appointmentList.add(appointment);
        System.out.println("Appointment Successfully Booked!");
        }else{
            System.out.println("Slot has already filled on that Date.Try with other date..");
        }
    }

    public boolean isValid(int id, String date){
        int count=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getDoctorId()==id && appointment.getDate().equals(date))
                count++;
        }
        return count<dc.slotOfDoctor(id);
    }

    public void viewAppointments(){
        int count=0;
        for(Appointment appointment:appointmentList){
            System.out.println(appointment);
            count++;
        }
        if(count==0) System.out.println("No Appointments Booked");
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

    public void viewAppointmentsOnDate(String date){
        int count=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getDate().equals(date)) {
                System.out.println(appointment);
                count++;
            }
        }
        if(count==0) System.out.println("No appointments available on that Date");
    }

    public void viewAppointmentsDateForDoctor(int doctorid,String date){
        int count=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getDoctorId()==doctorid && appointment.getDate().equals(date)) {
                System.out.println(appointment);
                count++;
            }
        }
        if(count==0) System.out.println("No appointments available on that Date");
    }

    public void viewAppointmentsDateForPatient(int patientid,String date){
        int count=0;
        for(Appointment appointment:appointmentList){
            if(appointment.getPatientId()==patientid && appointment.getDate().equals(date)) {
                System.out.println(appointment);
                count++;
            }
        }
        if(count==0) System.out.println("No appointments available on that Date");
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
        System.out.println("No appointment exist with your id");
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
        System.out.println("No appointment exist with your id");
    }

    public static String getValidDate() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            System.out.print("📅Enter Date: ");
            String date=x.nextLine();
            try{
                LocalDate enteredDate=LocalDate.parse(date,formatter);
                LocalDate tomorrow=LocalDate.now().plusDays(1);
                if(enteredDate.isBefore(tomorrow)){
                    System.out.println("❌ Invalid Date! Enter the upcoming Date");
                }else{
                    return enteredDate.format(formatter);
                }
            }
            catch(Exception e){
                System.out.println("❌ Invalid date format! Please enter in (dd/MM/yyyy) format");
            }
        }
    }

    public static String validDate() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            System.out.print("📅Enter Date: ");
            String date=x.nextLine();
            try{
                LocalDate enteredDate=LocalDate.parse(date,formatter);
                    return enteredDate.format(formatter);
            }
            catch(Exception e){
                System.out.println("❌ Invalid date format! Please enter in (dd/MM/yyyy) format");
            }
        }
    }
}
