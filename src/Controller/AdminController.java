package Controller;
import java.util.*;
import Model.Admin;

public class AdminController {
    private List<Admin> adminList;

    public boolean isExist(){
        return adminList.size()==1;
    }
    public AdminController(){
        adminList=new ArrayList<>();
    }
    public void addAdmin(int id,String password,String name,int age,String email,String contact){
        Admin admin=new Admin(id,password,name,age,email,contact);
        adminList.add(admin);
        System.out.println("Admin Registered Successfully!");
    }

    public void viewAdmin(int id){
        for(Admin admin:adminList){
            if(admin.getAdminId()==id){
                System.out.println(admin);
                return;
            }
        }
        System.out.println("Admin with that id doesn't exist");
    }

    public boolean isValidAdmin(int id,String password){
        for(Admin admin:adminList){
            if(admin.getAdminId()==id && admin.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
