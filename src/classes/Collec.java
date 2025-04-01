package classes;

import utils.HelpCommands;
import utils.Queue;

public class Collec {

    private Queue<Integer> queue;
    private int biggest;

    public Collec(){
        this.queue = new Queue<>();
        biggest = 0;
    }

    public Collec(int n){
        this.queue = new Queue<>();
        queue.insert(n);
        biggest = n;
    }

    public boolean add(int n){
        if (n > biggest) {
            queue.insert(n);
            biggest = n;
            return true;
        }
        return false;
    }

    public int small(){
        return queue.isEmpty() ? -1 : queue.head();
    }

    public int smallest(Collec other){
        return Math.min(small(), other.small());
    }

    @Override
    public String toString() {
        return "Collec{" +
                "queue=" + queue +
                ", biggest=" + biggest +
                '}';
    }
}
