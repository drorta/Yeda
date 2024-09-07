public class H1 {

    public void /*ספר עיצוב תוכנה ישן*/answers() {

        //EX1
        //הפונקציה מדפיסה את התו שהוכנס n פעמים

        //EX2
        //מחזיר פי כמה a גדול מb

        //EX3
        //מחזיר את הספרה הגדולה ביותר במספר

        //EX4
        //מחזיר num^2

        //EX6
        //הופך את המספר

        //EX7
        //מחזיר a*b

    }

    public static int EX1PG26(int n) {
        if (n == 1) {
            return 1;
        }
        return n + EX1PG26(n - 1);
    }

    public static int EX2PG26(int x) {
        if (x == 1) {
            return 1;
        }
        return x * EX2PG26(x - 1);
    }

    public static int EX3PG26(int num) {
        if (num == 1) {
            return 1;
        }
        if (num % 2 == 0) {
            return EX3PG26(num - 1);
        }
        return num * EX3PG26(num - 1);
    }

    public static int EX4PG26(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + EX4PG26(num / 10);
    }

    public static int EX5PG26(int x, int y) {
        if (y == 1) {
            return x;
        }
        return x + EX5PG26(x, y - 1);
    }

    public static int EX6PG26(int x, int y) {
        if (x < y) {
            return x;
        }
        return EX6PG26(x - y, y);
    }

    public static boolean EX7PG26(int x, int y) {
        if (x == y) {
            return true;
        }
        if (x < y) {
            return false;
        }
        return EX7PG26(x - y, y);
    }

    //count should be num-1
    public static boolean EX8PG26(int num, int count) {
        if (count == 1) {
            return true;
        }
        if (num % count == 0){
            return false;
        }
        return EX8PG26(num,count-1);
    }

    public static boolean EX9PG26(int num) {
        if (num / 10 == 0) {
            return true;
        }
        if (num % 10 % 2 != (num / 10) % 10 % 2) {
            return false;
        }
        return EX9PG26(num / 10);
    }

    public static void main(String[] args) {

    }

}