package Models;

public class Prescription {
    private int PrescriptionId;
    private int RecordId;
    private String Medicine;
    private String Dosage;
    private String Diagnosis;

    public Prescription(){}
    public Prescription(int PrescriptionId,int RecordId,String Medicine,String Dosage,String Diagnosis){
        this.PrescriptionId=PrescriptionId;
        this.RecordId=RecordId;
        this.Diagnosis=Diagnosis;
        this.Dosage=Dosage;
        this.Medicine=Medicine;
    }

    public int getPrescriptionId() {return PrescriptionId;}
    public int getRecordId(){return RecordId;}
    public String getDiagnosis(){return Diagnosis;}
    public String getMedicine(){return Medicine;}
    public String getDosage(){return Dosage;}

    public void setPrescriptionId(int prescriptionId){PrescriptionId=prescriptionId;}
    public void setDiagnosis(String diagnosis){Diagnosis=diagnosis;}
    public void setRecordId(int recordId){RecordId=recordId;}
    public void setMedicine(String medicine){Medicine=medicine;}
    public void setDosage(String dosage){Dosage=dosage;}

    public String toString(){
        return "PrescriptionId: "+PrescriptionId+", RecordId: "+RecordId+", Diagnosis: "+Diagnosis+", Dosage"+Dosage+", Medicine";
    }
}
