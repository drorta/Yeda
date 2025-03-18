import classes.Card;
import utils.Node;

public class L24 extends Main {

    public static void fixCardsByNum(Node<Card> node){}


    public static void main(String[] args) {
        Node<Integer> node = buildNodes(0,1,2,3,4,5,6);
        System.out.println(node);
        System.out.println(subNode(node, 2, 4));
    }

}
