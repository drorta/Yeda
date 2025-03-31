public class H11 extends HelpCommands {

    public static Node<Integer> ex11(Node<Integer> node, int value) {
        return removeValue(node, value);
    }

    public static Node<Integer> ex13(Node<Integer> node){
        Node<Integer> temp = node;
        if (lenNodes(temp) % 2 == 0) {
            for (int i = 0; i < lenNodes(temp) / 2 - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(
                    Math.max(temp.getNext().getValue(), temp.getNext().getNext().getValue()) == temp.getNext().getValue() ?
                            temp.getNext() : temp.getNext().getNext()
            );
            return node;
        } else {
            node = node.getNext();
            temp = temp.getNext();
            for (int i = 0; i < lenNodes(node); i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            return node;
        }
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
        Node<Integer> node = new Node<>(4);
        node.setNext(buildSortNode(10));
        printNodes(node);
        node = ex11(node, 4);
        printNodes(node);
    }

}
