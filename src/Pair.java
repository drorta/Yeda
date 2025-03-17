public class Pair<T, K> {

    private Character tav;

    public void setNum(int num) {
        this.num = num;
    }

    public void setTav(Character tav) {
        this.tav = tav;
    }

    private int num;

    public Pair(Character tav, int num){
        this.tav = tav;
        this.num = num;
    }

    public Character getTav() {
        return tav;
    }

    public int getNum() {
        return num;
    }

}
