public class CarInfo {

    private int id;
    private boolean privateCar;
    private int speed;

    public CarInfo(int id, boolean privateCar, int speed) {
        this.id = id;
        this.privateCar = privateCar;
        this.speed = speed;
    }

    public boolean illegal(int maxSpeed){
        return privateCar || speed > maxSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrivateCar() {
        return privateCar;
    }

    public void setPrivateCar(boolean privateCar) {
        this.privateCar = privateCar;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
