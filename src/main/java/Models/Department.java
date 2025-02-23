package Models;

public class Department {
    private int DeptId;
    private String DeptName;
    private int DeptHead;
    private int HospId;

    public Department(){}
    public Department(int DeptId,String DeptName,int DeptHead,int HospId){
        this.DeptId=DeptId;
        this.DeptName=DeptName;
        this.DeptHead=DeptHead;
        this.HospId=HospId;
    }

    public void setDeptId(int deptId){DeptId=deptId;}
    public void setDeptName(String deptName){DeptName=deptName;}
    public void setDeptHead(int deptHead){DeptHead=deptHead;}
    public void setHospId(int hospId){HospId=hospId;}

    public String toString(){
        return "DeptId: "+DeptId+", DeptName: "+DeptName+", DeptHead: "+DeptHead+", HospId: "+HospId;
    }
}
