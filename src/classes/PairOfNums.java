package classes;

public class PairOfNums {

    private int num1;
    private int num2;

    public PairOfNums(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public static PairOfNums[] generate(int n){
        PairOfNums[] pairs = new PairOfNums[n];
        for (int i = 0; i < n; i++) {
            PairOfNums pair = new PairOfNums(((int) (Math.random() * 1000)), (int) (Math.random() * 1000));
            while (!pair.endStart()) {
                pair = new PairOfNums(((int) (Math.random() * 1000)), (int) (Math.random() * 1000));
            }
            pairs[i] = pair;
        }
        return pairs;
    }

    public boolean endStart(){
        int num1FirstDigit = num1%10;
        int num1LastDigit = num1;
        for (int i = 0; i < String.valueOf(num1).length(); i++) {
            num1LastDigit /= 10;
        }

        int num2FirstDigit = num2%10;
        int num2LastDigit = num2;
        for (int i = 0; i < String.valueOf(num2).length(); i++) {
            num2LastDigit /= 10;
        }

        return num1FirstDigit == num2LastDigit
                || num2FirstDigit == num1LastDigit;

    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
