import utils.BinNode;

public class L24 extends Main {

    public static void printAll(BinNode<Integer> root) {
        printAll(root, 0);
    }

    public static void printAll(BinNode<Integer> root, int n){
        if (root != null) {
            if (isLeaf(root)) {
                System.out.println(root.getValue() + n * 10);
            } else {
                n = n*10 + root.getValue();
                if (root.hasLeft()) {
                    printAll(root.getLeft(), n);
                }
                if (root.hasRight()) {
                    printAll(root.getRight(), n);
                }
            }
        }
    }



    public static void main(String[] args) {
        BinNode<Integer> root = buildTree(10);
        printMeTree(root);
        printAll(root);

    }

}
