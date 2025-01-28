import java.util.Scanner;

public class H17 extends HelpCommands {

    public static boolean IsIt(BinNode<Integer> tree) {
        if (tree.getValue() == null)
            return true;
        return tree.getValue() % 2 == 0;
    }

    public static void OnlyEvenAndNoOdd(BinNode<Integer> root) { // ex11
        if (root == null)
            return;
        if (root.getValue() % 2 == 0 && IsIt(root.getLeft()) && IsIt(root.getRight()))
            System.out.println(root);
        OnlyEvenAndNoOdd(root.getLeft());
        OnlyEvenAndNoOdd(root.getRight());

    }

    public static void Close(BinNode<Integer> root) { //ex13
        if (root == null)
            return;
        if (root.hasRight() && !root
                .hasLeft())
            System.out.println(root.getRight().getValue());
        else if (!root.hasRight() && root.hasLeft()) {
            System.out.println(root.getLeft().getValue());
        } else if (root.getValue() - root.getLeft().getValue() < root.getValue() - root.getRight().getValue()) {
            System.out.println(root.getLeft().getValue());
        } else if (root.getValue() - root.getRight().getValue() < root.getValue() - root.getLeft().getValue()) {
            System.out.println(root.getLeft().getValue());
        }
        Close(root.getRight());
        Close(root.getLeft());
    }

    public static int HowManyDoubles(BinNode<Integer> root, int n) { //ex 15
        if (root == null)
            return 0;
        if (root.getValue() % n == 0)
            return 1 + HowManyDoubles(root.getRight(), n) + HowManyDoubles(root.getLeft(), n);
        return HowManyDoubles(root.getRight(), n) + HowManyDoubles(root.getLeft(), n);
    }

    public static int HowManyBigFamily(BinNode<Integer> root) { // ex17
        if (root == null)
            return 0;
        if (root.hasRight() && root.hasLeft()) {
            if (root.getRight().hasLeft() || root.getRight().hasRight()) {
                if (root.getLeft().hasRight() || root.getLeft().hasLeft()) {
                    return 1 + HowManyBigFamily(root.getRight()) + HowManyBigFamily(root.getLeft());
                }
            }
        }
        return HowManyBigFamily(root.getLeft()) + HowManyBigFamily(root.getRight());
    }

    public static Node<Integer> ex61(Node<Integer> node){
        int len = lenNodes(node)/2;
        for (int i = 0; i < len; i++) {
            node = node.getNext();
        }
        return node.getNext();
    }

    public static BinNode<Integer> ex63(){
        Node<Integer> temp = new Node<>(0);
        Node<Integer> p = temp;
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextInt() != -999) {
            p.setNext(new Node<>(scanner.nextInt()));
            p = p.getNext();
        }
        temp = temp.getNext();
        temp = reverseNode(temp);
        BinNode<Integer> ret = new BinNode<>(0);
        BinNode<Integer> bp = ret;
        while (temp != null) {
            bp.setLeft(new BinNode<>(temp.getValue()));
            bp = bp.getLeft();
            temp = temp.getNext();
        }
        return ret.getLeft();
    }

    public static BinNode<Integer> ex64(BinNode<Integer> l1, BinNode<Integer> l2){
        //לא מגדירים בשום מקום מה זה ״באמצע הרשימה״ וגם בדוגמא זה לא ברור...
        return null;
    }

    public static void main(String[] args) {
    }

}
