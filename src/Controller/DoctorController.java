package Controller;
import Model.Doctor;
import java.util.*;

public class DoctorController {
    private List<Doctor> doctorList;

    public DoctorController(){
        doctorList=new ArrayList<>();
    }

    public boolean validDoctor(int id,String password){
        for(Doctor doctor:doctorList){
            if(doctor.getDoctorId()==id && doctor.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void addDoctor(int id,String password,String name,int age,String email,String contact,String specialization,int slot){
        Doctor doctor=new Doctor(id,password,name,age,email,contact,specialization,slot);
        doctorList.add(doctor);
        System.out.println("Doctor Successfully Added");
    }

    public void viewDoctors(){
        for(Doctor doctor:doctorList){
            System.out.println(doctor);
        }
    }

    public void viewDoctorWithId(int id){
        for(Doctor doctor:doctorList){
            if(doctor.getDoctorId()==id){
                System.out.println(doctor);
                return;
            }
        }
        System.out.println("No Doctor Exist with the given id");
    }

    public void deleteDoctorWithId(int id){
        Iterator<Doctor> i=doctorList.iterator();
        while(i.hasNext()){
            Doctor doctor=i.next();
            if(doctor.getDoctorId()==id) {
                doctorList.remove(doctor);
                return;
            }
        }
        System.out.println("No Doctor exist with that id");
    }

    public void updateSlot(int id,int slot){
        for(Doctor doctor:doctorList){
            if(doctor.getDoctorId()==id){
                doctor.setSlot(slot);
                return;
            }
        }
        System.out.println("No doctor exist with that id");
    }
}
