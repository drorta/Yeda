import java.util.Objects;
import java.util.Scanner;

public class H12 extends HelpCommands {

    public static int ex15ARec(Node<Character> node, char c) {
        if (node == null) {
            return 0;
        }
        if (node.getValue() == c) {
            return 1 + ex15ARec(node.getNext(), c);
        }
        return ex15ARec(node.getNext(), c);
    }

    public static void ex16A(Node<Character> node) {
        while (node != null) {
            System.out.println(countVal(node.getNext(), node.getValue()));
            removeValueChar(node, node.getValue());
            node = node.getNext();
        }
    }

    public static void ex16B() {
        Scanner reader = new Scanner(System.in);
        Node<Character> act = new Node<>('0');
        Node<Character> p = act;
        while (!Objects.equals(reader.next(), "999")) {
            p.setNext(new Node<>(reader.next().charAt(0)));
            p = p.getNext();
        }
        act = act.getNext();
        ex16A(act);
    }

    public static int ex18Rec(Node<String> node, String name) {
        if (node == null) {
            return 0;
        }
        if (Objects.equals(node.getValue().split(" ")[0], name)) {
            return 1 + ex18Rec(node.getNext(), name);
        }
        return ex18Rec(node.getNext(), name);
    }

    public static Node<String> ex20(Node<String> node) {
        Node<String> ret = new Node<>("0");
        Node<String> p = ret;
        while (node != null) {
            p.setNext(new Node<>(getLastString(node)));
            node = removeLastString(node);
            p = p.getNext();
        }
        return ret.getNext();
    }

    public static boolean abcFirst(String prev, String next) {
        if (prev.length() > next.length()) {
            for (int i = 0; i < prev.length(); i++) {
                if (i >= next.length()) {
                    return prev.charAt(i) <= next.charAt(next.length()-1);
                }
                if (prev.charAt(i) < next.charAt(i)) {
                    return prev.charAt(i) <= next.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < next.length(); i++) {
                if (i >= prev.length()) {
                    return prev.charAt(prev.length()-1) <= next.charAt(i);
                }
                if (prev.charAt(i) < next.charAt(i)) {
                    return prev.charAt(i) <= next.charAt(i);
                }
            }
        }
        return true;
    }

    public static Node<String> ex21(Node<String> node) {
        while (node.getNext() != null){
            if (!abcFirst(node.getValue(), node.getNext().getValue())){
                return new Node<>(node.getNext().getValue());
            }
            node = node.getNext();
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
