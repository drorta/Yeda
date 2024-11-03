public class Time {

    private int hours;

    private int minutes;

    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isSmallerThan(Time other){
        boolean smallerHours = this.hours < other.hours;
        boolean equalHours = this.hours == other.hours;
        boolean biggerHours = this.hours > other.hours;

        boolean smallerMin = this.minutes < other.minutes;
        boolean equalMin = this.minutes == other.minutes;
        boolean biggerMin = this.minutes > other.minutes;

        boolean smallerSec = this.seconds < other.seconds;
        boolean biggerSec = this.seconds > other.seconds;

        if (biggerHours) {
            return false;
        } else if (equalHours && biggerMin) {
            return false;
        } else if (equalHours && equalMin && biggerSec) {
            return false;
        }

        if (smallerHours) {
            return true;
        } else if (equalHours && smallerMin) {
            return true;
        } else if (equalHours && equalMin && smallerSec) {
            return true;
        }

        return false;
    }

}
