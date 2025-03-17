import classes.*;

public class H23 extends Main {

    public static int legalCities(CameraInfo[] cameraInfos){
        int legalCities = 0;
        for (CameraInfo cameraInfo : cameraInfos){
            if (cameraInfo.allGood()) {
                legalCities++;
            }
        }
        return legalCities;
    }

    public static void doctorRatings(Doctor[] doctors, int[] ratings){
        int ratingsI = 0;
        for (Doctor doctor : doctors) {
            int currentSum = 0;
            int currentLength = 0;
            while (ratings[ratingsI] != -1) {
                currentSum += ratings[ratingsI];
                currentLength++;
                ratingsI++;
            }
            doctor.setRate(currentSum / currentLength);
            ratingsI++;
        }
    }

    public static boolean isEqualNumber(int[] arr, int index){
        int rightSum = 0;
        for (int i = index+1; i < arr.length; i++) {
            rightSum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < index; i++) {
            leftSum += arr[i];
        }

        return rightSum == leftSum;
    }

    public static boolean isEqualArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (isEqualNumber(arr, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
