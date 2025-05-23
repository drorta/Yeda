package classes;

public class Results {

    private int[] arr;
    private String name;

    public Results(int[] arr, String name) {
        this.arr = arr;
        this.name = name;
    }

    public int deltas(boolean isLonger) {
        int ret = 0;
        if (isLonger) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    ret += arr[i] - arr[i - 1];
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    ret += arr[i - 1] - arr[i];
                }
            }
        }
        return ret;
    }

    public boolean improving(){
        return deltas(false) > deltas(true);
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
