public class A {

    private char let;
    private int num;

    public A(char let, int num){
        this.let = let;
        this.num = num;
    }

    public char getLet() {
        return let;
    }

    public void setLet(char let) {
        this.let = let;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString(){
        return "Let: " + let + " Num: " + num;
    }
}
