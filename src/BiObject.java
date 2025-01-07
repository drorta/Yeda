public class BiObject<T, U> {

    private T first;
    private U second;

    public BiObject(U second, T first) {
        this.second = second;
        this.first = first;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
