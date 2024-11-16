public class DoubleQueue<T> {

    private final Queue<T> fastQueue;
    private final Queue<T> slowQueue;
    private int turn;

    public DoubleQueue() {
        fastQueue = new Queue<T>();
        slowQueue = new Queue<T>();
        turn = 0;
    }

    public Queue<T> get(int act) {
        return act == 1 ? fastQueue : slowQueue;
    }

    public T getHead(int act) {
        return act == 1 ? fastQueue.head() : slowQueue.head();
    }

    public void add(int act, T x) {
        if (act == 1) {
            fastQueue.insert(x);
        } else {
            slowQueue.insert(x);
        }
    }

    public T remove() {
        if (turn == 5) {
            turn = 0;
            return slowQueue.remove();
        } else {
            turn++;
            return fastQueue.remove();
        }
    }

}
