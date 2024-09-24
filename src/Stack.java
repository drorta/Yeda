public class Stack<T> {
    private Node<T> first;

    public Stack() {
        this.first = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void push(T x) {
        this.first = new Node<T>(x, this.first);
    }

    public T pop() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T top() {
        return this.first.getValue();
    }

    public String toString() {
        String str = "[";
        Node<T> pos = this.first;
        while (pos != null) {
            str = str + pos.getValue().toString();
            if (pos.getNext() != null)
                str = str + " , ";
            pos = pos.getNext();
        }
        str = str + "]";
        return str;
    }
}