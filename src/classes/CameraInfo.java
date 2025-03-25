package classes;

public class CameraInfo {

    private int city;
    private int maxSpeed;
    private CarInfo[] cars;

    public CameraInfo(int city, int maxSpeed, CarInfo[] cars) {
        this.city = city;
        this.maxSpeed = maxSpeed;
        this.cars = cars;
    }

    public boolean allGood() {
        for (CarInfo car : cars) {
            if (car.illegal(maxSpeed)) {
                return false;
            }
        }
        return true;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public CarInfo[] getCars() {
        return cars;
    }

    public void setCars(CarInfo[] cars) {
        this.cars = cars;
    }

}
