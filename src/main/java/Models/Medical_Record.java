package Models;
import java.util.Date;

public class Medical_Record {
    private int RecordId;
    private int DoctorId;
    private int PatientId;
    private String Diagnosis;
    private String Treatment;
    private Date RecordDate;

    public Medical_Record(){}
    public Medical_Record(int RecordId,int DoctorId,int PatientId,String Diagnosis,String Treatment,Date RecordDate){
        this.RecordId=RecordId;
        this.DoctorId=DoctorId;
        this.PatientId=PatientId;
        this.Diagnosis=Diagnosis;
        this.Treatment=Treatment;
        this.RecordDate=RecordDate;
    }

    public void setRecordId(int recordId){RecordId=recordId;}
    public void setDoctorId(int doctorId){DoctorId=doctorId;}
    public void setPatientId(int patientId){PatientId=patientId;}
    public void setDiagnosis(String diagnosis){Diagnosis=diagnosis;}
    public void setTreatment(String treatment){Treatment=treatment;}
    public void setRecordDate(Date recordDate){RecordDate=recordDate;}

    public int getRecordId(){return RecordId;}
    public int getDoctorId(){return DoctorId;}
    public int getPatientId(){return PatientId;}
    public String getDiagnosis(){return Diagnosis;}
    public String getTreatment(){return Treatment;}
    public Date getRecordDate(){return RecordDate;}

    public String toString(){
        return "RecordId: "+RecordId+", DoctorId: "+DoctorId+", PatientId: "+PatientId+", Diagnosis: "+Diagnosis+", Treatment: "+Treatment+", Date: "+RecordDate;
    }
}

