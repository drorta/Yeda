
public class L9 {

    /**
     *
     * @param node the chainlink of nodes
     * @return the number of even numbers in the chainlink of nodes
     */
    public static int countEven(Node<Integer> node){
        int count = 0;
        while (node != null) {
            if (node.getValue() % 2 == 0) {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    public static void changeOdd(Node<Integer> node){
        while (node != null) {
            if (node.getValue() % 2 == 1) {
                node.setValue(node.getValue()*2);
            }
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        Node<Integer> fst = new Node<>(
                5, new Node<>(
                8, new Node<>(
                -3, new Node<>(
                7
        ))));
        Node<Integer> node = HelpCommands.buildNodes(5);
        HelpCommands.printNodes(node);
        System.out.println(HelpCommands.sumNodes(node));
        System.out.println(countEven(node));
        changeOdd(node);
        HelpCommands.printNodes(node);

    }

}
