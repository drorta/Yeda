public class ArrStack<T> {

    private T[] arr;
    private int top;

    public ArrStack() {
        arr = (T[]) new Object[5];
        top = -1;
    }

    public ArrStack(int n) {
        arr = (T[]) new Object[n];
        top = -1;
    }

    public void push(T x) {
        if (top == arr.length - 1) {
            T[] temp = (T[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        top++;
        arr[top] = x;
    }

    public T pop() {
        T x = arr[top];
        top--;
        return x;
    }

    public T top() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int countX(T x) {
        int count = 0;
        for (int i = 0; i < top; i++) {
            if (arr[i].equals(x)) {
                count++;
            }
        }
        return count;
    }

    //i==0
    public int ex22RecCountX(T x, int i) {
        if (arr[i] == x) {
            return 1 + ex22RecCountX(x, i + 1);
        }
        return ex22RecCountX(x, i + 1);
    }

    public double ex23Sum() {
        int sum = 0;
        for (int i = 0; i < top; i++) {
            sum += (int) arr[i];
        }
        return (double) sum / top;
    }

    public ArrStack<Integer> ex24(){
        ArrStack<Integer> finale = new ArrStack<Integer>();
        for (int i = 0; i < top; i++) {
            if (finale.countX((Integer) arr[i]) == 0) {
                finale.push((Integer) arr[i]);
            }
        }
        return finale;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String s = "[";
        for (int i = 0; i < top; i++) {
            s = s + arr[i] + ",";
        }
        return s.substring(0, s.length() - 1) + "]";
    }
}
