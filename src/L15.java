public class L15 extends HelpCommands {

    public static int sumNodeRec(Node<Integer> fst){
        if (fst == null) {
            return 0;
        }
        return fst.getValue() + sumNodeRec(fst.getNext());
    }

    public static void ex44pg114(Node<Integer> fst){
        if (fst.getNext() != null) {
            System.out.println(fst.getNext().getValue());
            ex44pg114(fst.getNext().getNext());
        }
    }

    public static Node<Integer> what(Node<Integer> lst, int x){
        if (lst == null) {
            return null;
        }
        Node<Integer> temp = what(lst.getNext(), x);
        if (lst.getValue() == x) {
            return temp;
        }
        lst.setNext(temp);
        return lst;
    }

    public static int ex53pg117(Node<BiObject<Integer, Integer>> )

    public static void main(String[] args) {
        Node<Integer> exp = buildNodes(1,3,5,3,1,9,4);
        printNodes(exp);
        printNodes(what(exp, 1));
    }

}
