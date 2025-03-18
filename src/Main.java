import utils.HelpCommands;
import utils.Node;

public class Main extends HelpCommands {

    public static void main(String[] args) {
        Node<Integer> node = buildNodes(0,1,2,3,4,5,6,7);
        setByIndex(node, 1000, 3);
        System.out.println(node);
    }

}
