import classes.Card;
import utils.HelpCommands;
import utils.Node;

public class H24 extends HelpCommands {

    public static void fixCardsByNum(Node<Card> node) {
        while (node != null) {
            Node<Card> p = node;
            while (hasNum(p.getNext(), p.getValue().num())) {
                Node<Card> before = findBeforeNum(p, p.getValue().num());
                Card card = before.getNext().getValue();
                before.setNext(before.getNext().getNext());
                p.setNext(new Node<>(card, p.getNext()));
                p = p.getNext();
            }
            node = node.getNext();
        }
    }

    public static boolean hasNum(Node<Card> node, int num){
        while (node != null) {
            if (node.getValue().num() == num) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public static Node<Card> findBeforeNum(Node<Card> node, int num){
        while (node.getNext() != null) {
            if (node.getNext().getValue().num() == num) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public static void main(String[] args) {
        Card card = new Card(3, "a");
        Card card1 = new Card(4, "b");
        Card card2 = new Card(3, "c");
        Card card3 = new Card(2, "d");

        Node<Card> node = buildNodes(card, card1, card2, card3);
        fixCardsByNum(node);
        System.out.println(node);
    }

}
