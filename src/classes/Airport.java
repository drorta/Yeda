package classes;

import java.util.Arrays;

public class Airport {

    private Flight[] arr;

    public Airport(Flight[] arr) {
        this.arr = arr;
    }

    public Flight[] getArr() {
        return arr;
    }

    public void setArr(Flight[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
