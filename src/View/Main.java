package View;

import Controller.AdminController;
import Controller.AppointmentController;
import Controller.DoctorController;
import Controller.PatientController;

import java.util.*;
public class Main {
    static Scanner x=new Scanner(System.in);
    static  final String invalid_message="Invalid Input! Please try again...🔁";
    static PatientController pc = new PatientController();
    static DoctorController dc=new DoctorController();
    static AppointmentController ac=new AppointmentController();
    static AdminController adc=new AdminController();
    public static void main(String[] args) {

        System.out.println("-----------🙏 Welcome to Medical Appointment System 🏥 ----------");
        while (true) {
            System.out.println("Enter your choice (Register, Login, Exit) ✨");
            String choice = x.nextLine();
            switch (choice.toLowerCase()) {
                case "register":
                    registerUser();
                    break;
                case "login":
                    loginUser();
                    break;
                case "exit":
                    System.out.println("Stay healthy, Stay safe..! ❣️👋");
                    return;
                default:
                    System.out.println(invalid_message);
            }
        }
    }
    public static void registerUser() {
        boolean flag=true;
        while(flag){
            System.out.println("Enter your Role (Admin, Doctor, Patient / Exit): 🏷️");
            String role=x.nextLine();
            if(role.equalsIgnoreCase("exit")){
                System.out.println("Registration process ended.. ⛔");
                break;
            }
            switch(role.toLowerCase()){
                case "admin":
                    System.out.print("Enter Id: 🔢");
                    int adminId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter password: 🔑");
                    String passworddd=x.nextLine();
                    System.out.print("Name: 📝");
                    String nameee=x.nextLine();
                    System.out.print("Age: 🎂");
                    int ageee=x.nextInt();
                    x.nextLine();
                    System.out.print("Email: 📧");
                    String emailll=x.nextLine();
                    System.out.print("Contact: 📞");
                    String contacttt=x.nextLine();
                    adc.addAdmin(adminId,passworddd,nameee,ageee,emailll,contacttt);
                    flag=false;
                    break;
                case "doctor":
                    System.out.print("Enter Id: 🔢");
                    int doctorId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter password: 🔑");
                    String password=x.nextLine();
                    System.out.print("Enter Name: 📝");
                    String name=x.nextLine();
                    System.out.print("Enter Age: 🎂");
                    int age=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter Email: 📧");
                    String email=x.nextLine();
                    System.out.print("Enter Contact: 📞");
                    String contact=x.nextLine();
                    System.out.print("Enter Specialization: 🏥");
                    String specialization=x.nextLine();
                    System.out.print("Enter slot: ⏳");
                    int slot=x.nextInt();
                    x.nextLine();
                    dc.addDoctor(doctorId,password,name,age,email,contact,specialization,slot);
                    flag=false;
                    break;
                case "patient":
                    System.out.print("Enter Id: 🔢");
                    int patientId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter password: 🔑");
                    String passwordd=x.nextLine();
                    System.out.print("Enter Name: 📝");
                    String namee=x.nextLine();
                    System.out.print("Enter Age: 🎂");
                    int agee=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter Email: 📧");
                    String emaill=x.nextLine();
                    System.out.print("Enter Contact: 📞");
                    String contactt=x.nextLine();
                    pc.addPatient(patientId,passwordd,namee,agee,emaill,contactt);
                    flag=false;
                    break;
                default:
                    System.out.println(invalid_message);
            }
        }
    }

    public static void loginUser(){
        boolean flag=true;
        while(true){
            System.out.println("Enter your Role (Admin, Doctor, Patient / Exit): 🔑");
            String role=x.nextLine();
            if(role.equalsIgnoreCase("exit")){
                System.out.println("Login process ended.. ⛔");
                break;
            }
            switch(role.toLowerCase()){
                case "admin":
                    System.out.print("Enter Id: 🔢");
                    int adminId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter Password: 🔑");
                    String passworddd=x.nextLine();
                    if(adc.isValidAdmin(adminId,passworddd)){
                        System.out.println("🎉 YOU ARE SUCCESSFULLY LOGGED IN AS AN ADMIN 👨‍💼");
                        adminDashboard(adminId);
                    }
                    else{
                        System.out.println(invalid_message);
                    }
                    flag=false;
                    return;
                case "doctor":
                    System.out.print("Enter Id: 🔢");
                    int doctorId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter password: 🔑");
                    String password=x.nextLine();
                    if(dc.validDoctor(doctorId,password)){
                        System.out.println("🎉 YOU ARE SUCCESSFULLY LOGGED IN AS A DOCTOR 👨‍⚕️");
                        doctorDashboard(doctorId);
                    }
                    else{
                        System.out.println(invalid_message);
                    }
                    flag=false;
                    return;
                case "patient":
                    System.out.print("Enter Id: 🔢");
                    int patientId=x.nextInt();
                    x.nextLine();
                    System.out.print("Enter password: 🔑");
                    String passwordd=x.nextLine();
                    if(pc.validPatient(patientId,passwordd)){
                        System.out.println("🎉 YOU ARE SUCCESSFULLY LOGGED IN AS A PATIENT 🏥");
                        patientDashboard(patientId);
                    }
                    else {
                        System.out.println("INVALID CREDENTIALS. TRY AGAIN.. ❌");
                    }
                    flag=false;
                    return;
                default:
                    System.out.println(invalid_message);
            }
        }
    }
public static void doctorDashboard(int id){
    while(true){
        System.out.println("🩺 Operations You can Do:");
        System.out.println("1️⃣ View Your Information\n2️⃣ View Appointments\n3️⃣ Exit");
        System.out.print("👉 Enter your choice: ");
        int choice=x.nextInt();
        x.nextLine();
        if(choice==3){
            System.out.println("Logging Out....🚶‍♀️");
            break;
        }
        switch(choice){
            case 1:
                dc.viewDoctorWithId(id);
                break;
            case 2:
                ac.viewAppointmentsWithDoctorId(id);
                break;
            default:
                System.out.println(invalid_message);
        }
    }
}

public static void patientDashboard(int id){
    while(true){
        System.out.println("🏥 Operations You can Do:");
        System.out.println("1️⃣ View Your Information\n2️⃣ View Appointments\n3️⃣ Book Appointments\n4️⃣ Exit");
        System.out.print("👉 Enter your choice: ");
        int choice=x.nextInt();
        x.nextLine();
        if(choice==4){
            System.out.println("Logging Out....🚶‍♀️");
            break;
        }
        switch(choice){
            case 1:
                pc.viewPatientWithId(id);
                break;
            case 2:
                ac.viewAppointmentsWithPatientId(id);
                break;
            case 3:
                System.out.println("🆔 Enter Appointment Id: ");
                int appointment_id=x.nextInt();
                x.nextLine();
                System.out.println("👨‍⚕️ The Doctors Available in this Hospital:");
                dc.viewDoctors();
                System.out.print("🩺 Choose your Doctor: ");
                int doctor_id=x.nextInt();
                x.nextLine();
                System.out.print("📅 Choose Date: ");
                String date=x.nextLine();
                ac.addAppointment(appointment_id,doctor_id,id,date);
                break;
            default:
                System.out.println(invalid_message);
        }
    }
}
public static void adminDashboard(int id){
    while(true){
        System.out.println("🛠️ Operations You can Do:");
        System.out.println("1️⃣ View Your Information\n2️⃣ View Doctors\n3️⃣ View Patients\n4️⃣ View Appointments\n5️⃣ Exit");
        System.out.print("👉 Enter your choice: ");
        int choice=x.nextInt();
        x.nextLine();
        if(choice==5){
            System.out.println("Logging Out....🚶‍♀️");
            break;
        }
        switch(choice){
            case 1:
                adc.viewAdmin(id);
                break;
            case 2:
                dc.viewDoctors();
                break;
            case 3:
                pc.viewPatients();
                break;
            case 4:
                ac.viewAppointments();
                break;
            default:
                System.out.println(invalid_message);
        }
    }
}
}