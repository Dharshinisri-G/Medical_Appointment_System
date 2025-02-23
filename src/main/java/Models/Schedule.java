package Models;

import java.util.Date;

public class Schedule {
    private int ScheduleId;
    private Date ScheduleDate;
    private int ScheduledTime;

    public Schedule(){}
    public Schedule(int ScheduleId,Date ScheduleDate,int ScheduleTime){
        this.ScheduleId=ScheduleId;
        this.ScheduleDate=ScheduleDate;
        this.ScheduledTime=ScheduleTime;
    }
    public void setScheduleId(int scheduleId){ScheduleId=scheduleId;}
    public void setScheduleDate(Date scheduleDate){ScheduleDate=scheduleDate;}
    public void setScheduledTime(int scheduledTime){ScheduledTime=scheduledTime;}

    public int getScheduleId(){return ScheduleId;}
    public Date getScheduleDate(){return ScheduleDate;}
    public int getScheduledTime(){return ScheduledTime;}

    public String toString(){
        return "ScheduleId: "+ScheduleId+", ScheduleDate: "+ScheduleDate+", ScheduledTime"+ScheduledTime;
    }
}
