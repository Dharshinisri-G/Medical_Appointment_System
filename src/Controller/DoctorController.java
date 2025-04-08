package Controller;
import Model.Doctor;
import java.util.*;

public class DoctorController {
    private List<Doctor> doctorList;
    static final Scanner x=new Scanner(System.in);
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
        int count=0;
        for(Doctor doctor:doctorList){
            System.out.println(doctor);
            count++;
        }
        if(count==0) System.out.println("No Doctors available.");
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
            if(i.next().getDoctorId()==id) {
                i.remove();
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

    public int slotOfDoctor(int id){
        for(Doctor doctor:doctorList){
            if(doctor.getDoctorId()==id)
                return doctor.getSlot();
        }
        return -1;
    }

    public int isDoctorAvailable(){
        while(true){
            System.out.print("🩺Choose Doctor:");
            int id=x.nextInt();
            for(Doctor doctor:doctorList){
                if(doctor.getDoctorId()==id)
                    return id;
            }
            System.out.println("❌ Invalid Id.Enter a valid Doctor Id.");
        }
    }

}
