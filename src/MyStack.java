public class MyStack<T> {

    private T[] arr;
    private int t;

    public MyStack(){
        this.arr = (T[]) new Object[5];
        this.t = -1;
    }

    public boolean isEmpty(){
        return this.t == -1;
    }

    public T top(){
        return arr[t];
    }

    public T pop(){

    }
}
