public class rekursia {

    //gets two positive natural numbers x and y, returns x^y
    public static int myPowRec(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return x * myPowRec(x, y - 1);
    }

    //gets two positive natural numbers x and y, return x*y
    public static int myKafulRec(int x, int y) {
        if (y == 1) {
            return x;
        }
        return x + myKafulRec(x, y - 1);
    }


    public static int mySum1Rec(int n) {
        if (n == 1) {
            return 1;
        }
        return n + mySum1Rec(n - 1);
    }

    public static int myAtzeretRec(int x) {
        if (x == 1) {
            return 1;
        }
        return x * myAtzeretRec(x - 1);
    }

    public static int countDigitRec(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + countDigitRec(num / 10);
    }

    public static int sumDigRec(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + sumDigRec(num / 10);
    }

    public static boolean hasNum(int num, int dig) {
        if (num == 0) {
            return false;
        }
        if (num % 10 == dig) {
            return true;
        }
        return hasNum(num / 10, dig);
    }

    public static int evenCount(int num) {
        if (num == 0) {
            return 1;
        }
        if (num % 10 % 2 == 0) {
            return 1 + evenCount(num / 10);
        }
        return evenCount(num / 10);
    }

    public static boolean isAllOdd(int num) {
        if (num == 0) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        return isAllOdd(num / 10);
    }

    public static int maxDigit(int num) {
        if (num == 0) {
            return 0;
        }
        return Math.max(num % 10, maxDigit(num / 10));
    }

    public static void main(String[] args) {
        System.out.println();
    }

}