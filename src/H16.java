public class H16 extends HelpCommands {

    public static Node<Integer> ex54Apg117(Node<Integer> node) {
        if (node.getNext().getValue() % 2 == 1) {
            return node.getNext();
        }
        return ex54Apg117(node.getNext());
    }

    public static Node<Integer> ex54Bpg117(Node<Integer>[] nodes) {
        Node<Integer> ret = new Node<>(0);
        for (Node<Integer> node : nodes) {
            setLast(ret, ex54Apg117(node));
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
