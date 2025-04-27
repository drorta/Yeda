package classes;

public class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour > 23 || hour < 0 ? 0 : hour;
        this.minute = minute > 59 || minute < 0 ? 0 : minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
