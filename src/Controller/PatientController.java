package Controller;
import Model.Patient;

import java.util.*;

public class PatientController {
      private List<Patient> patientList;

      public PatientController(){
          patientList=new ArrayList<>();
      }
      public boolean validPatient(int id,String password){
          for(Patient patient:patientList){
              if(patient.getPatientId()==id && patient.getPassword().equals(password))
                  return true;
          }
          return false;
      }
      public void addPatient(int id,String password,String name,int age,String email,String contact){
          Patient patient=new Patient(id,password,name,age,email,contact);
          patientList.add(patient);
          System.out.println("Patient Successfully Added!");
      }
      public void viewPatients(){
          int count=0;
          for(Patient patient:patientList){
              System.out.println(patient);
              count++;
          }
          if(count==0) System.out.println("No patients available");
      }

      public void viewPatientWithId(int id){
          for(Patient patient:patientList){
              if(patient.getPatientId()==id){
                  System.out.println(patient);
                  break;
              }
          }
      }

      public void updateEmail(int id,String email){
          for(Patient patient:patientList){
              if(patient.getPatientId()==id){
                  patient.setEmail(email);
              }
          }
          viewPatientWithId(id);
      }

      public void deletePatientWithId(int id){
          Iterator<Patient> i=patientList.iterator();
          while(i.hasNext()){
              if(i.next().getPatientId()==id){
                  i.remove();
                  viewPatients();
                  return;
              }
          }

      }
}
