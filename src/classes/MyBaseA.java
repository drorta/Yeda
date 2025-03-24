package classes;

import utils.HelpCommands;
import utils.Node;

public class MyBaseA {

    private Node<Integer> first;
    private Node<Integer> last;

    public MyBaseA() {
        this.first = null;
    }

    public void insert(int x) {
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

    public boolean exists(int x) {
        Node<Integer> temp = first;
        while (temp != null) {
            if (temp.getValue() == x) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public Node<Integer> showMin() {
        return last;
    }

    public int getMax() {
        int max = first.getValue();
        this.first = first.getNext();
        return max;
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
