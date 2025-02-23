package Models;

public class Payment {
    private int PaymentId;
    private int PatientId;
    private int MedicalRecord;
    private int Amount;
    private String PaymentType;
    private String Status;

    public Payment(){}
    public Payment(int PaymentId,int PatientId,int MedcialRecord,int Amount,String PaymentType,String Status){
        this.PaymentId=PaymentId;
        this.MedicalRecord=MedcialRecord;
        this.PatientId=PatientId;
        this.PaymentType=PaymentType;
        this.Amount=Amount;
        this.Status=Status;
    }

    public void setPaymentId(int paymentId) {PaymentId = paymentId;}

}

