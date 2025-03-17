import java.util.Objects;
import java.util.Scanner;

public class H21 extends HelpCommands {

    public static boolean isGood(Node<Integer> node) {
        if (node == null || node.getNext() == null) {
            return false;
        }
        boolean isGoingUPPPP = node.getValue() < node.getNext().getValue();
        if (isGoingUPPPP) {
            while (node.getNext() != null) {
                if (node.getNext().getValue() <= node.getValue()) {
                    return false;
                }
                node = node.getNext();
            }
        } else {
            while (node.getNext() != null) {
                if (node.getNext().getValue() >= node.getValue()) {
                    return false;
                }
                node = node.getNext();
            }
        }
        return true;
    }

    public static int ex26(Node<Integer> node) {
        int numof = 0;
        Node<Integer> temp = new Node<>(0);
        while (node != null) {
            if (node.getValue() == -999) {
                if (isGood(temp.getNext())) {
                    numof++;
                }
                temp = new Node<>(0);
            }
            addLast(temp, node.getValue());
            node = node.getNext();
        }
        return numof;
    }

    public static Node<Integer> ex35() {
        Scanner input = new Scanner(System.in);
        Node<Integer> node = new Node<>(input.nextInt());
        while (input.nextInt() != -999) {
            node.setNext(new Node<>(input.nextInt()));
            node = sortNodeAllowed(node);
        }
        return node;
    }

    public static int ex37(Node<Integer> lis1, Node<Integer> lis2) {
        while (lis1 != null && lis2 != null) {
            if (Objects.equals(lis1.getValue(), lis2.getValue())) {
                return lis1.getValue();
            }
            if (lis1.getValue() > lis2.getValue()) {
                lis2 = lis2.getNext();
            } else {
                lis1 = lis1.getNext();
            }
        }
        return -999;
    }

    public static Node<Integer> ex38(Node<Integer> lis1, Node<Integer> lis2) {
        Node<Integer> both = new Node<>(0);
        Node<Integer> p = both;
        while (lis1 != null && lis2 != null) {
            if (Objects.equals(lis1.getValue(), lis2.getValue())) {
                p.setNext(new Node<>(lis1.getValue()));
                p = p.getNext();
                lis1 = lis1.getNext();
                lis2 = lis2.getNext();
            } else if (lis1.getValue() > lis2.getValue()) {
                lis2 = lis2.getNext();
            } else {
                lis1 = lis1.getNext();
            }
        }
        return both.getNext();
    }

    /*
    ex39A:
    [1] = true
    [1,2] = false
    B:
    הפעולה מקבלת רשימה של מספרים, ומחזירה שקר אם הרשימה כוללת שני מספרים (אחד אחרי השני ברשימה) שהמכפלה שלהם גדולה מ0
     */

    /*
    ex40
    A:
    30
    B:
    הפעולה מחזירה את המספר הגדול ביותר מבין רשימת המספרים שקיבלה
     */

    public static Node<Character> ex49(Node<Pair<Character, Integer>> node){
        Node<Character> finale = new Node<>('@');
        Node<Character> p = finale;
        while (node != null) {
            char currentChar = node.getValue().getTav();
            for (int i = 0; i < node.getValue().getNum(); i++) {
                p.setNext(new Node<>(currentChar));
                p = p.getNext();
            }
            node = node.getNext();
        }
        return finale.getNext();
    }

    public static void main(String[] args) {
        Node<Pair<Character, Integer>> exp = buildNodes(new Pair<>('R', 1), new Pair<>('L', 3), new Pair<>('S', 4));
        printNodes(ex49(exp));
    }

}