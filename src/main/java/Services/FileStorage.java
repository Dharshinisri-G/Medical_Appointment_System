package Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import java.io.IOException;
import java.io.File;
import Models.User;
import Models.Patient;
import Models.Doctor;
import Models.Admin;
import java.util.function.Function;
public class FileStorage {
    private static final String user_file="data/users.json";
    private static final String patient_file="data/patients.json";
    private static final String doctor_file="data/doctors.json";
    private static final String admin_file="data/admins.json";
    private static final ObjectMapper ob=new ObjectMapper();
    public static <T> List<T> loadData(String filePath,TypeReference<List<T>> typeReference){
        File f=new File(filePath);
        if(!f.exists())
            return new ArrayList<>();
        try{
            return ob.readValue(f, typeReference);
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public static <T> void saveData(String filePath, List<T> data) {
        try {
            File directory = new File("data");
            if (!directory.exists() && directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            }
            // Ensure pretty printing for JSON
            ob.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (IOException e) {
            System.out.println("Error saving data to " + filePath + ": " + e.getMessage());
        }
    }

    public static List<User> loadUsers(){
        List<User> users = loadData(user_file, new TypeReference<List<User>>() {});
        //System.out.println("Users loaded from users: " + users);
        return users;

    }

    public static <T> int getNextId(List<T> data,Function<T, Integer> getIdFunction) {
        if (data.isEmpty()) {
            return 1;
        }
        int maxId = data.stream().mapToInt(getIdFunction::apply).max().orElse(0);
        return maxId + 1;
    }

    public static int getNextUserId() {
        List<User> Users=loadUsers();
        return getNextId(Users, User::getUserId);
    }

    public static List<Patient> loadPatients() {
        List<Patient> patients = loadData(patient_file, new TypeReference<List<Patient>>() {});
        // Debugging: Print loaded data
        System.out.println("Users loaded from patients: " + patients);
        return patients;
    }
    public static List<Doctor> loadDoctors() {
        List<Doctor> doctors = loadData(doctor_file, new TypeReference<List<Doctor>>() {});
        // Debugging: Print loaded data
        System.out.println("Users loaded from doctors: " + doctors);
        return doctors;
    }
    public static List<Admin> loadAdmins() {
        List<Admin> admins = loadData(admin_file, new TypeReference<List<Admin>>() {});
        // Debugging: Print loaded data
        System.out.println("Users loaded from admins: " + admins);
        return admins;
    }
    public static int getNextPatientId() {
        List<Patient> Patients=loadPatients();
        return getNextId(Patients, Patient::getPatientID);
    }

    public static int getNextDoctorId() {
        List<Doctor> Doctors=loadDoctors();
        return getNextId(Doctors, Doctor::getDoctorID);
    }
    public static int getNextAdminId() {
        List<Admin> Admins=loadAdmins();
        return getNextId(Admins, Admin::getAdminID);
    }


    public static void SaveWithRole(User newUser) {
        List<User> users=loadUsers();
        users.add(newUser);
        saveData(user_file,users);
        if(newUser instanceof Patient){
            List<Patient> patients=loadData(patient_file, new TypeReference<List<Patient>>() {});
            patients.add((Patient)newUser);
            saveData(patient_file,patients);
        }
        else if(newUser instanceof Doctor){
            List<Doctor> doctors=loadData(doctor_file, new TypeReference<List<Doctor>>() {});
            doctors.add((Doctor)newUser);
            saveData(doctor_file,doctors);
        }
        else if(newUser instanceof Admin){
            List<Admin> admins=loadData(admin_file, new TypeReference<List<Admin>>() {});
            admins.add((Admin)newUser);
            saveData(admin_file,admins);
        }
    }

    public static int getNextAppointmentId() {

    }
}
