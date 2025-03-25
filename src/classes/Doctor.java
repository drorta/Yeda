package classes;

public class Doctor {

    private String name;
    private String specialization;
    private int rate;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.rate = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
