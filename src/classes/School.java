package classes;

import utils.Node;

import java.util.Arrays;

public class School {

    private Node<Student>[] ar;

    public School(Node<Student>[] ar) {
        this.ar = ar;
    }

    public Node<Student>[] getAr() {
        return ar;
    }

    public void setAr(Node<Student>[] ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "School{" +
                "ar=" + Arrays.toString(ar) +
                '}';
    }
}
