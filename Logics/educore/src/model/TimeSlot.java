package model;

import java.time.DayOfWeek;

public class TimeSlot {
    private DayOfWeek day;
    private int period;
    private String classID;

    public TimeSlot(DayOfWeek day, int period, String classID) {
        this.day = day;
        this.period = period;
        this.classID = classID;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
