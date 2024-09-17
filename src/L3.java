public class L3 {

    //i = 0
    public static int numOfWords(String string, int i) {
        if (string.isEmpty()) {
            return 0;
        }
        if (i == string.length()) {
            return 1;
        }
        if (string.charAt(i) == ' ') {
            return 1 + numOfWords(string, i + 1);
        }
        return numOfWords(string, i + 1);
    }

    public static int numOfWordsNoParams(String string) {
        if (string.isEmpty()) {
            return 1;
        }
        if (string.charAt(0) == ' ') {
            return 1 + numOfWordsNoParams(string.substring(1));
        }
        return numOfWordsNoParams(string.substring(1));
    }

    public static String pg35ex33(String string) {
        if (string.length() < 3) {
            return string;
        }
        return string.substring(0, 3) + "*" + pg35ex33(string.substring(3));
    }

    public static String pg35ex34(String string) {
        if (1 == string.length()) {
            return string;
        }
        return string.substring(string.length() - 1) + pg35ex34(string.substring(0, string.length() - 1));
    }
/*
פעולת מעטפת

    public static boolean isPoliArr(int[] arr) {
        int i = 0;
        return isPoliArr(arr, i);
    }

    public static boolean isPoliArr(int[] arr, int i) {

    }

 */


    public static void main(String[] args) {
        System.out.println(pg35ex34("abc"));
    }

}
