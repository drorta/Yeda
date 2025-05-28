import utils.*;

public class B2024 {

    public static int spilledOutReturnsLen(Queue<Integer> from, Queue<Integer> to){
        int len = 0;
        while (!from.isEmpty()) {
            len++;
            to.insert(from.remove());
        }
        return len;
    }

    public static <T> void spilledOut(Queue<T> from, Queue<T> to){
        while (!from.isEmpty()) {
            to.insert(from.remove());
        }
    }

    public static Queue<Integer> clone(Queue<Integer> q) {
        Queue<Integer> t = new Queue<>();
        Queue<Integer> c = new Queue<>();

        spilledOutReturnsLen(q, t);

        while (!t.isEmpty()) {
            c.insert(t.head());
            q.insert(t.remove());
        }

        return c;
    }

    public static int lenQueue(Queue<Integer> q) {
        Queue<Integer> c = clone(q);
        Queue<Integer> t = new Queue<>();

        return spilledOutReturnsLen(c, t);
    }

    public static int getNumByIndex(Queue<Integer> q, int i){
        int currentI = 1;
        Queue<Integer> c = clone(q);

        while (currentI != i) {
            c.remove();
            currentI++;
        }

        return c.head();
    }

    public static boolean isMagic(Queue<Integer> q, int m) {
        if (m == 1 || m == lenQueue(q)) {
            return false;
        }
        return getNumByIndex(q, m-1) + getNumByIndex(q, m+1) == getNumByIndex(q, m);
    }

    public static boolean nMagic(Queue<Integer> q, int n){
        int numOfNs = lenQueue(q) / n;

        for(int i = 1; i <= numOfNs; i++){
            if (!isMagic(q, n * i)) {
                return false;
            }
        }

        return true;
    }



}
