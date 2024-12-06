public class H11 extends HelpCommands {

    public static Node<Integer> ex11(Node<Integer> node, int value) {
        return removeValue(node, value);
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(4);
        node.setNext(buildSortNode(10));
        printNodes(node);
        node = ex11(node, 4);
        printNodes(node);
    }

}
