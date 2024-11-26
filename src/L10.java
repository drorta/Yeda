public class L10 extends HelpCommands {

    public static void addValue(int num, Node<Integer> node) {
        if (num < node.getValue()) {
            Node<Integer> temp = copyNode(node);
            node.setNext(null);
            node.setValue(num);
            node.setNext(temp);
        } else {
            while (node.getNext() != null && node.getNext().getValue() < num) {

                node = node.getNext();

            }
            Node<Integer> temp = node.getNext();
            node.setNext(new Node<>(num));
            node = node.getNext();
            node.setNext(temp);
        }
    }

    public static Node<Integer> addDummy(int num, Node<Integer> fst){
        Node<Integer> p = new Node<>(num);
        Node<Integer> dummy = new Node<>(0, fst);
        fst = dummy;
        Node<Integer> p1 = fst;
        while (p1.getNext() != null && p1.getNext().getValue() < num) {
            p1 = p1.getNext();
        }
        p.setNext(p1.getNext());
        p1.setNext(p);
        return fst.getNext();
    }

    public static void addTimes2(Node<Integer> node){
        while (node != null) {
            Node<Integer> temp = node.getNext();
            node.setNext(new Node<>(node.getValue()*2));
            node = node.getNext();
            node.setNext(temp);
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        Node<Integer> exp = buildSortNode(5);
        printNodes(exp);
        addTimes2(exp);
        printNodes(exp);

    }

}
