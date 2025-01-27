public class L17 {

    public static <T> void preOrder(BinNode<T> root){
        if (root != null) {
            System.out.println(root);
            preOrder(root.getLeft());
            preOrder(root.getRight() );
        }
    }

    public static <T> boolean isLeaf(BinNode<T> root){
        return !(root.hasLeft() || root.hasRight());
    }

    public static int sumRightSon(BinNode<Integer> root){
        if (root == null) {
            return 0;
        }
        return root.getValue() + sumRightSon(root.getRight());
    }

    public static <T> boolean hasOneSon(BinNode<T> root){
        return root.hasLeft() && !root.hasRight() || root.hasRight() && !root.hasLeft();
    }

    public static int countOneSon

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(
                1,
                new BinNode<Integer>(
                        2,
                        new BinNode<Integer>(
                                3, null, new BinNode<>(4)
                ),
                        new BinNode<Integer>(5, new BinNode<Integer>(6), null)
                ),
                null
        );
        HelpCommands.printMeTree(root);
    }

}
