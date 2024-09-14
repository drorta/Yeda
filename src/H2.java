public class H2 {

    public static double pg33ex15(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 != 0) {
            return n + pg33ex15(n - 1);
        }
        return -Math.sqrt(n - 1) + pg33ex15(n - 3);
    }

    //counter=2
    public static int pg33ex16(int n1, int n2, int counter) {
        if (n1 * counter >= n2) {
            return 0;
        }
        return 1 + pg33ex16(n1, n2, counter + 1);
    }

    public static double pg33ex17A(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Math.pow(pg33ex17A(n - 1), 2) + Math.pow(pg33ex17A(n - 2), 2);
    }

    public static double pg33ex17B(int n) {
        if (n == 0) {
            return 0;
        }
        return pg33ex17A(n - 1) + pg33ex17B(n - 1);
    }

    public static int pg33ex18(int[] arr, int i) {
        if (i == 0) {
            return arr[i];
        }
        return arr[i] + pg33ex18(arr, i - 1);
    }

    public static int pg34ex20(int[] arr, int i) {
        if (i == 0) {
            if (arr[i] > 0) {
                return 1;
            }
            return 0;
        }
        if (arr[i] > 0) {
            return 1 + pg34ex20(arr, i - 1);
        }
        return pg34ex20(arr, i - 1);
    }

    //i=0
    public static boolean pg34ex24(String string, int i) {
        if (i >= string.length() / 2) {
            return true;
        }
        if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
            return false;
        }
        return pg34ex24(string, i + 1);
    }

    //i=2
    public static boolean isPrime(int num, int i) {
        if (i == num / 2) {
            return true;
        }
        if (num % i == 0) {
            return false;
        }
        return isPrime(num, i + 1);
    }

    //i=0
    public static boolean pg34ex25(int[] arr, int i) {
        if (i == arr.length) {
            return false;
        }
        if (isPrime(arr[i], 2)) {
            return true;
        }
        return pg34ex25(arr, i + 1);
    }

    //i=0
    public static boolean allBigger(int[] arr, int num, int i) {
        if (i == arr.length) {
            return true;
        }
        if (arr[i] <= num) {
            return false;
        }
        return allBigger(arr, num, i + 1);
    }

    //i=0
    public static boolean pg34ex28(int[][] arr, int num, int i) {
        if (i == arr.length) {
            return true;
        }
        if (!allBigger(arr[i], num, 0)) {
            return false;
        }
        return pg34ex28(arr, num, i + 1);
    }

    //תרגיל 30: כתוב להיעזר בפעולה בעמוד 24 אבל אין לי את הספר או תצלום של העמוד...

    public static int pg35ex31(String string) {
        if (string.isEmpty()) {
            return 0;
        }
        if (Character.isLowerCase(string.charAt(0))) {
            return 1 + pg35ex31(string.substring(1));
        }
        return pg35ex31(string.substring(1));
    }

    public static boolean isAllBig(String string) {
        if (string.isEmpty()) {
            return true;
        }
        if (!Character.isUpperCase(string.charAt(0))) {
            return false;
        }
        return isAllBig(string.substring(1));
    }

    public static boolean isAllSmall(String string) {
        if (string.isEmpty()) {
            return true;
        }
        if (!Character.isLowerCase(string.charAt(0))) {
            return false;
        }
        return isAllSmall(string.substring(1));
    }

    public static boolean pg35ex32(String string) {
        return isAllBig(string) || isAllSmall(string);
    }

    public static void main(String[] args) {
    }

}
