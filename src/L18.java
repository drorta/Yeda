public class L18 extends HelpCommands {

    public static int ex16pg204(BinNode<Integer> root){
        if (root == null) {
            return 0;
        }
        if (hasTwoSons(root)) {
            return root.getValue() + ex16pg204(root.getLeft()) + ex16pg204(root.getRight());
        }
        return ex16pg204(root.getLeft()) + ex16pg204(root.getRight());
    }

    public static boolean ex19pg204(BinNode<Integer> root, int n) {
        if (n == 0) {
            return true;
        }
        if (countValue(root, n) != 1) {
            return false;
        }
        return ex19pg204(root, n-1);
    }

    public static boolean ex18pg204(BinNode<Integer> t1, BinNode<Integer> t2){
        if (t2 == null) {
            return true;
        }
        if (!hasValue(t1, t2.getValue())) {
            return false;
        }
        return ex18pg204(t1, t2.getLeft()) && ex18pg204(t1, t2.getRight());
    }

    public static void main(String[] args) {
        BinNode<Integer> binNode = new BinNode<>(1, new BinNode<>(2), null);
        BinNode<Integer> binNode2 = new BinNode<>(2, null, new BinNode<>(1));
        printMeTree(buildTree(100));
//        printMeTree(binNode2);
//        System.out.println(ex18pg204(binNode, binNode2));
    }

}
