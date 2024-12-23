import java.util.Objects;

public class H13 extends HelpCommands {

    public static int lenNodesLOOP(Node<Integer> fstCircle) {
        Node<Integer> p = fstCircle;
        int len = 1;
        while (p.getNext() != fstCircle) {
            len++;
            p = p.getNext();
        }
        return len;
    }

    public static Node<Integer> removeValueLOOP(Node<Integer> node, int value) {
        if (node.getValue() == value) {
            node = node.getNext();
        }
        Node<Integer> p = node;
        for (int i = 0; i < lenNodesLOOP(node); i++) {
            if (p.getNext().getValue() == value) {
                p.setNext(p.getNext().getNext());
            } else {
                p = p.getNext();
            }
        }
        return node;
    }

    public static int countValueLOOP(Node<Integer> node, int value) {
        int count = 0;
        for (int i = 0; i < lenNodesLOOP(node); i++) {
            if (node.getValue() == value) {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    public static Node<Integer> ex24Cpg108(Node<Integer> loop, int num) {
        if (countValueLOOP(loop, num) > 1) {
            loop.setNext(removeValueLOOP(loop.getNext(), num));
        }
        return loop;
    }

    public static Node<Integer> ex22pg108(Node<Integer> node, int num) {
        while (node != null) {
            if (node.getValue() == num) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public static boolean ex23pg108(Node<Integer> lis, int num) {
        int seq = 0;
        while (lis.getNext() != null) {
            if (lis.getNext().getValue() - lis.getValue() == 1) {
                seq++;
            } else {
                seq = 0;
            }
            if (seq == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(Node<Integer> node) {
        Node<Integer> half1 = (Node<Integer>) subNode(node, 0, lenNodes(node) / 2);
        Node<Integer> half2 = (Node<Integer>) subNode(node, lenNodes(node) / 2, lenNodes(node));
        half2 = reverseNode(half2);
        while (half1 != null && half2 != null) {
            if (!Objects.equals(half1.getValue(), half2.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static boolean ex27Apg109(Node<Integer> node, int num) {
        for (int i = 0; i < lenNodes(node) - num; i++) {
            if (isPalindrome((Node<Integer>) subNode(node, i, num + i))) {
                return true;
            }
        }
        return false;
    }

    public static int ex27Bpg109(Node<Integer> node) {
        for (int i = 0; i < lenNodes(node); i++) {
            if (isPalindrome((Node<Integer>) subNode(node, i, lenNodes(node)))) {
                return lenNodes(node) - i;
            }
        }
        return 1;
    }

    public static Node<Integer> ex30pg110(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> cut = new Node<>(0);
        Node<Integer> p = cut;
        while (n1 != null) {
            int val = n1.getValue();
            if (hasValue(n2, val)) {
                p.setNext(new Node<>(val));
                n1 = removeValue(n1, val);
            }
            p = p.getNext();
            n1 = n1.getNext();
        }
        return cut;
    }

    public static int ex31pg110(Node<Integer> lis1, Node<Integer> lis2) {
        int lis1num = 0;
        int lis2num = 0;
        for (int i = lenNodes(lis1); i > 0; i--) {
            lis1num += (int) (lis1.getValue() * Math.pow(10, i));
            lis1 = lis1.getNext();
        }
        for (int i = lenNodes(lis2); i > 0; i--) {
            lis2num += (int) (lis2.getValue() * Math.pow(10, i));
            lis2 = lis2.getNext();
        }
        if (lis2num < lis1num) {
            return 1;
        } else if (lis2num > lis1num) {
            return 2;
        }
        return 3;
    }

    public static Node<Integer> ex36pg111(Node<Integer> node) {
        return sortNodeAllowed(node);
    }

    public static void main(String[] args) {
    }

}