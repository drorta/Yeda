
public class L11 extends HelpCommands {

    public static Node<Integer> removeNegative(Node<Integer> fst) {
        if (fst.getValue() < 0) {
            fst = fst.getNext();
        }
        Node<Integer> p = fst;
        while (p.getNext() != null) {
            if (p.getNext().getValue() < 0) {
                p.setNext(p.getNext().getNext());
            } else {
                p = p.getNext();
            }
        }
        return fst;
    }

    public static Node<Integer> removeBig(Node<Integer> node, int n) {
        if (lenNodes(node) <= n) {
            return null;
        }
        Node<Integer> p = node;
        for (int i = 0; i < n; i++) {
            int big = findMax(node);
            if (countVal(node, big) > 1) {
                i += countVal(node, big);
            }
            node = removeValue(node, big);
        }
        return node;
    }

    public static Node<Integer> ex11pg91(Node<Integer> node, int value){
        return removeValue(node, value);
    }

    public static Node<Integer> ex14pg91(Node<Integer> chain1, Node<Integer> chain2){
        int removed = 0;
        Node<Integer> p = chain1;
        for (int i = 0; i < lenNodes(p); i++) {
            for (int j = 0; j < lenNodes(chain2); j++) {
                removed += countVal(p, chain2.getValue());
                p = removeValue(p, chain2.getValue());
                chain2 = chain2.getNext();
            }
            p = p.getNext();
        }
        p.setNext(new Node<>(removed));
        return chain1;
    }

    public static void main(String[] args) {
        Node<Integer> exp = buildNodes(5);
        Node<Integer> exp2 = buildNodes(5);
        printNodes(exp);
        printNodes(exp2);
        exp = ex14pg91(exp, exp2);
        printNodes(exp);
    }

}
