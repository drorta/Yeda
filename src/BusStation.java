public class BusStation {

    private int num;
    private int[] arr;
    private int amount;

    public BusStation(int num) {
        this.num = num;
        this.arr = new int[10];
        this.amount = 1;
    }

    public boolean isStopping(int n){
        for (int bus : arr) {
            if (bus == n) {
                return true;
            }
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
