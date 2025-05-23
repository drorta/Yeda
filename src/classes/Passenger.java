package classes;

public class Passenger {

    private int passportNum;
    private String name;
    private boolean permPass;
    private int km;

    public Passenger(int passportNum, String name, boolean permPass, int km) {
        this.passportNum = passportNum;
        this.name = name;
        this.permPass = permPass;
        this.km = km;
    }

    public int getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermPass() {
        return permPass;
    }

    public void setPermPass(boolean permPass) {
        this.permPass = permPass;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
