package org.example;
import Models.Admin;
import Models.Doctor;
import Models.Patient;
import Models.User;
import Services.FileStorage;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        List<User> users= FileStorage.loadUsers();
        List<Patient> patients=FileStorage.loadPatients();
        List<Doctor> doctors=FileStorage.loadDoctors();
        List<Admin> admins=FileStorage.loadAdmins();
        while(true){
           System.out.println("Welcome to Medical Appointment System");
           System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            System.out.print("Choose any Option :");
            int op=x.nextInt();
            switch(op){
                case 1:
                    login(x);
                    break;
                case 2:
                    User currUser=User.createUser();
                    currUser.Welcome();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
    public static void login(Scanner x){
        System.out.println("1.Admin");
        System.out.println("2.Doctor");
        System.out.println("3.Patient");
        System.out.print("Choose User Role: ");
        int op=x.nextInt();
        System.out.print("Enter UserName: ");
        String Uname=x.nextLine();
        System.out.print("Enter Password: ");
        String pwd=x.nextLine();
        System.out.println();
        System.out.println("Logged in successfully");
    }
}