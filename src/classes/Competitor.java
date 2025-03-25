package classes;

public class Competitor {

    private int minutes;
    private int seconds;
    private String name;

    /**
     * @param seconds NOT greater than 59!
     */
    public Competitor(int minutes, int seconds, String name) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.name = name;
    }

    public boolean isBetter(Competitor other){
        if (this.minutes < other.minutes) {
            return true;
        }
        return this.seconds < other.seconds;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
