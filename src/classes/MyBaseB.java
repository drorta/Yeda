package classes;

import utils.HelpCommands;
import utils.Node;

public class MyBaseB {

    private Node<Integer> first;
    private Node<Integer> last;

    private int div7;

    public MyBaseB() {
        this.first = null;
    }

    public void insert(int x) {
        if (x % 7 == 0) {
            div7++;
        }
        if (first == null) {
            this.first = new Node<>(x);
        }
        if (x > first.getValue()) {
            this.first = new Node<>(x, this.first);
        } else {
            Node<Integer> temp = first;
            while (temp.getNext() != null) {
                if (x > temp.getNext().getValue()) {
                    temp.setNext(new Node<>(x, temp.getNext()));
                }
            }
        }

        this.last = HelpCommands.getLast(first);
    }

    public int getMax() {
        int max = first.getValue();
        this.first = first.getNext();
        if (max % 7 == 0) {
            div7--;
        }
        return max;
    }

    public boolean div7(){
        return div7 > 0;
    }

    public String toString() {
        String str = "[";
        Node<Integer> pos = this.first;
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
