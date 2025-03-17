import classes.*;

public class H23 extends Main {

    public int legalCities(CameraInfo[] cameraInfos){
        int legalCities = 0;
        for (CameraInfo cameraInfo : cameraInfos){
            if (cameraInfo.allGood()) {
                legalCities++;
            }
        }
        return legalCities;
    }

    public static void main(String[] args) {

    }

}
