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

    public static void main(String[] args) {
        seq6(5, 1, 1, 1);
    }

}
