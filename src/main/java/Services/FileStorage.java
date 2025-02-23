package Services;
import Models.User;
import Models.Patient;
import Models.Doctor;
import Models.Admin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String USERS_FILE = "data/users.json";
    private static final String PATIENTS_FILE = "data/patients.json";
    private static final String DOCTORS_FILE = "data/doctors.json";
    private static final String ADMINS_FILE = "data/admins.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> loadFromFile(String filename, TypeReference<List<T>> typeReference) {
        File file = new File(filename);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveToFile(String filename, Object data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        return loadFromFile(USERS_FILE, new TypeReference<List<User>>() {});
    }

    public static List<Patient> loadPatients() {
        return loadFromFile(PATIENTS_FILE, new TypeReference<List<Patient>>() {});
    }

    public static List<Doctor> loadDoctors() {
        return loadFromFile(DOCTORS_FILE, new TypeReference<List<Doctor>>() {});
    }

    public static List<Admin> loadAdmins() {
        return loadFromFile(ADMINS_FILE, new TypeReference<List<Admin>>() {});
    }

    public static void saveUsers(List<User> users) {
        saveToFile(USERS_FILE, users);
    }

    public static void savePatients(List<Patient> patients) {
        saveToFile(PATIENTS_FILE, patients);
    }

    public static void saveDoctors(List<Doctor> doctors) {
        saveToFile(DOCTORS_FILE, doctors);
    }

    public static void saveAdmins(List<Admin> admins) {
        saveToFile(ADMINS_FILE, admins);
    }

    public static void SaveWithRole(User user) {
        int count=0;
        if (user instanceof Patient) {
            count++;
            List<Patient> patients = loadPatients();
            patients.add((Patient) user);
            savePatients(patients);
        } else if (user instanceof Doctor) {
            count++;
            List<Doctor> doctors = loadDoctors();
            doctors.add((Doctor) user);
            saveDoctors(doctors);
        } else if (user instanceof Admin) {
            count++;
            List<Admin> admins = loadAdmins();
            admins.add((Admin) user);
            saveAdmins(admins);
        } else {
            System.out.println("The Role you chose is not available.");
        }
        if(count>0){
            List<User> users = loadUsers();
            User basicUser=new User(user.getUserId(), user.getUserRole(), user.getUserName(), user.getPassword(), user.getName(), user.getEmail(), user.getContact(), user.getGender(), user.getDateOfBirth(), user.getAddress(), user.getAge());
            users.add(basicUser);
            saveUsers(users);
        }
    }

    public static int getNextUserId() {
        return loadUsers().size() + 1;
    }

    public static int getNextPatientId() {
        return loadPatients().size() + 1;
    }

    public static int getNextDoctorId() {
        return loadDoctors().size() + 1;
    }

    public static int getNextAdminId() {
        return loadAdmins().size() + 1;
    }

    public static boolean login(String role, String username, String password) {
        switch (role) {
            case "Admin":
                return loadAdmins().stream().anyMatch(admin -> admin.getUserName().equals(username) && admin.getPassword().equals(password));
            case "Doctor":
                return loadDoctors().stream().anyMatch(doctor -> doctor.getUserName().equals(username) && doctor.getPassword().equals(password));
            case "Patient":
                return loadPatients().stream().anyMatch(patient -> patient.getUserName().equals(username) && patient.getPassword().equals(password));
            default:
                return false;
        }
    }
}
