public class L8 {

    //idx = 0
    public static boolean countM(int[] arr, int x, int m, int idx) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == x) {
            if (m < 0) {
                return false;
            }
            return countM(arr, x, m-1, idx + 1);
        }
        if (m == 0){
            return true;
        }
        return countM(arr, x, m, idx+1);
    }

    public static int minDig(int num){
        if (num == 0) {
            return Integer.MAX_VALUE;
        }
        int currentdig = num%10;
        int next = minDig(num/10);
        return Math.min(currentdig,next);
    }

    public static boolean check(int[] arr, int idx, int m){
        if (idx == arr.length) {
            return true;
        }
        if (Math.min(minDig(arr[idx]), m) == m) {
            return check(arr, idx + 1, m);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10,7,15,7,9,9,7,7,3};
        System.out.println(countM(arr,7,3,0));
    }

}
