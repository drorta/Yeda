public class H10 extends HelpCommands {

    public static boolean ex6(Node<Integer> node) {
        double avg = (double) sumNodes(node) / lenNodes(node);
        int bigger = 0;
        int smaller = 0;
        while (node != null) {
            if (node.getValue() > avg) {
                bigger++;
            } else if (node.getValue() < avg) {
                smaller++;
            }
            node = node.getNext();
        }
        return bigger == smaller;
    }

    public static void ex7(Node<Integer> node, int start, int end) {
        Node<Integer> subNode = subNode(node, start, end);
        printNodes(subNode);
    }

    public static Node<Integer> ex9A() {
        Node<Integer> ret = new Node<>((int) (Math.random() * 99));
        Node<Integer> temp = ret;
        for (int i = 0; i < 49; i++) {
            int x = (int) (Math.random() * 99);
            if (!hasValue(ret, x)) {
                temp.setNext(new Node<>(x));
                temp = temp.getNext();
            } else i--;
        }
        return ret;
    }

    public static Node<Integer> ex9B(Node<Integer> node) {
        Node<Integer> rando = ex9A();
        Node<Integer> ret = new Node<>(0);
        Node<Integer> temp = ret;
        while (rando != null) {
            if (!hasValue(node, rando.getValue())) {
                temp.setNext(rando.getNext());
            }
            rando = rando.getNext();
            temp = temp.getNext();
        }
        return ret.getNext();
    }

    public static Node<Integer> ex10(int begin, int num) {
        Node<Integer> ret = new Node<>(begin);
        Node<Integer> temp = ret;
        for (int i = 0; i < num; i++) {
            temp.setNext(new Node<>(begin+i));
            temp = temp.getNext();
        }
        return ret;
    }

    public static Node<Integer> ex12(Node<Integer> node){
        Node<Integer> ret = new Node<>(0);
        Node<Integer> temp = ret;
        while (node != null) {
            if (countVal(node, node.getValue()) < 2) {
                temp.setNext(new Node<>(node.getValue()));
            }
            node = node.getNext();
            temp = temp.getNext();
        }
        return ret;
    }

    public static void main(String[] args) {
        Node<Integer> exp = buildNodes(10);
        printNodes(exp);
        printNodes(sortNode(exp));
    }

}