public class H3 {

    public static void ex9(int[] a1, int[] a2) {
        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] == a2[j]) {
                System.out.println(a1[i]);
            }
            if (j != a2.length - 1 && a1[i] > a2[j]) {
                j++;
            }
            else i++;
        }
    }

    public static void main(String[] args) {

    }

}
