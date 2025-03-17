public class L2 {

    public static void printN(int num) {
        if (num == 0) {
            return;
        }
        System.out.println(num);
        printN(num - 1);
        /*
        if (num > 0) {
            System.out.println(num);
            printN(num - 1);
        }
        */
    }

    public static void printNReverse(int num) {
        if (num == 0) {
            return;
        }
//        System.out.println(num);
        printNReverse(num - 1);
        System.out.println(num);
    }

    public static int diffDig(int x, int y) {
        //stop
        if (x < 10 && y < 10) {
            return 0;
        }
        //x is finished, y is longer, starting to count the diff
        if (x < 10) {
            return 1 + diffDig(x, y / 10);
        }
        //y is finished, x is longer, starting to count the diff
        if (y < 10) {
            return 1 + diffDig(x / 10, y);
        }
        return diffDig(x / 10, y / 10);
    }

    public static int fibo(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int seq5(int n) {
        if (n == 1) {
            return n * 2;
        }
        if (n % 2 == 0) {
            return n * n + seq5(n - 1);
        }
        return n * 2 + seq5(n - 1);
    }

    //count=1, start=1, lol =1
    public static void seq6(int n, int count, int start, int lol) {
        if (n < lol) {
            return;
        }
        System.out.println(start);
        seq6(n, count + 1, start + count, lol + 1);
    }

    //second half

    //param=0
    public static int sumArrRec(int[] arr, int param) {
        if (param == arr.length) {
            return 0;
        }
        return arr[param] + sumArrRec(arr, param + 1);
    }

    //param=0
    public static int countEvenArrRec(int[] arr, int param) {
        if (param == arr.length) {
            return 0;
        }
        if (arr[param] % 2 == 0) {
            return 1 + countEvenArrRec(arr, param + 1);
        }
        return countEvenArrRec(arr, param + 1);
    }

    //param==0
    public static boolean hasNumArr(int[] arr, int num, int param) {
        if (param == arr.length) {
            return false;
        }
        if (arr[param] == num) {
            return true;
        }
        return hasNumArr(arr, num, param + 1);
    }

    //param=0
    public static int maxValueArrRec(int[] arr, int param) {
        if (param == arr.length) {
            return 0;
        }
        return Math.max(arr[param], maxValueArrRec(arr, param + 1));
    }

    //param=0
    public static void printModNum(int[] arr, int num, int param) {
        if (param == arr.length) {
            return;
        }
        if (arr[param] % num == 0) {
            System.out.println(arr[param]);
        }
        printModNum(arr, num, param + 1);
    }

    //param=2
    public static boolean isPrime(int num, int param) {
        if (param == 0) {
            param = 2;
        }
        if (param == num / 2) {
            return true;
        }
        if (num % param == 0) {
            return false;
        }
        return isPrime(num, param + 1);
    }

    //param=0
    public static int firstPrime(int[] arr, int param) {
        if (param == arr.length) {
            return -1;
        }
        if (isPrime(arr[param], 0)) {
            return arr[param];
        }
        return firstPrime(arr, param + 1);
    }

    public static int staircase(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (y - x < x) {
            return 1 + staircase(x + 1, y);
        }
        return 1 + staircase(x * 2, y);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, -3, 7, 14};

        System.out.println(staircase(2, 15));
    }

}
