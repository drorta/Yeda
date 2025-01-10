import java.util.Arrays;

public class H15 extends HelpCommands {

    public static int ex45pg114(Node<Integer> lst, Node<Integer> p, Node<Integer> q) {
        if (lst == q) {
            return lst.getValue();
        }
        if (p == null || lst == p) {
            return lst.getValue() + ex45pg114(lst.getNext(), null, q);
        }
        return ex45pg114(lst.getNext(), p, q);
    }

    public static int ex46pg114(Node<Integer> lst1, Node<Integer> lst2) {
        if (lst1 == null && lst2 == null) {
            return 0;
        }
        if (lst1 == null) {
            return 1 + ex46pg114(lst1, lst2.getNext());
        }
        if (lst2 == null) {
            return 1 + ex46pg114(lst1.getNext(), lst2);
        }
        return ex46pg114(lst1.getNext(), lst2.getNext());
    }

    public static int ex48pg115(Domino[] dominoBricks, Domino domino) {
        int counter = 0;
        for (int i = 0; i < dominoBricks.length; i++) {
            counter += domino.canBeNextTo(dominoBricks[i]) ? 1 : 0;
        }
        return counter;
    }

    public static int ex52pg116(Node<int[]> node){
        int unevenLotteries = 0;
        while (node != null) {
            if (Arrays.stream(node.getValue()).max().getAsInt() - Arrays.stream(node.getValue()).min().getAsInt() <= 20) {
                unevenLotteries++;
            }
        }
        return unevenLotteries;
    }

    public static void main(String[] args) {
        Node<Integer> exp = buildNodes(1, 2, 3, 4, 5, 6);
        Node<Integer> exp2 = buildNodes(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(ex46pg114(exp, exp2));
    }

}
