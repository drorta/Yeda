public class H19 extends HelpCommands {

    public static boolean hotNodeFamily(BinNode<String> root){
        if (root == null) {
            return true;
        }
        if (!hasValue(getHotColors(), root.getValue())) {
            return false;
        }
        return hotNodeFamily(root.getRight());
    }
    public static boolean coldNodeFamily(BinNode<String> root){
        if (root == null) {
            return true;
        }
        if (!hasValue(getColdColors(), root.getValue())) {
            return false;
        }
        return coldNodeFamily(root.getLeft());
    }

    public static boolean hotNodeFamily(BinNode<String> root, Node<String> hotColors){
        if (root == null) {
            return true;
        }
        if (!hasValue(hotColors, root.getValue())) {
            return false;
        }
        return hotNodeFamily(root.getRight());
    }
    public static boolean coldNodeFamily(BinNode<String> root, Node<String> coldColors){
        if (root == null) {
            return true;
        }
        if (!hasValue(coldColors, root.getValue())) {
            return false;
        }
        return coldNodeFamily(root.getLeft());
    }

    public static int ex32B(BinNode<String> root){
        if (root == null) {
            return 0;
        }
        if (hotNodeFamily(root)) {
            return 1 + ex32B(root.getLeft()) + ex32B(root.getRight());
        }
        return ex32B(root.getLeft()) + ex32B(root.getRight());
    }

    public static boolean ex32C(BinNode<String> root, Node<String> coldColors, Node<String> hotColors){
        return coldNodeFamily(root, coldColors) || hotNodeFamily(root, hotColors);
    }

    public static <T> boolean hasValue(BinNode<T> root, T value) {
        if (root == null) {
            return false;
        }
        if (root.getValue() == value) {
            return true;
        }
        return hasValue(root.getLeft(), value) || hasValue(root.getRight(), value);
    }

    public static int getNextNumber(BinNode<Integer> root){
        int i = root.getValue() + 1;
        while (i < Integer.MAX_VALUE) {
            if (!hasValue(root, i)) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void ex34(BinNode<Integer> root, int rootValue){
        if (root == null) {
            return;
        }
        if (root.getValue() == rootValue) {
            root.setValue(getNextNumber(root));
        }
        ex34(root.getLeft(), rootValue);
        ex34(root.getRight(), rootValue);
    }

    public static boolean hasOneSon(BinNode<Integer> root){
        return (root.hasLeft() && !root.hasRight()) || (root.hasRight() && !root.hasLeft());
    }

    public static void ex37(BinNode<Integer> root){
        if (root == null) {
            return;
        }
        if (root.hasLeft() && !root.hasRight()) {
            root.setRight(new BinNode<>(root.getLeft().getValue()));
        }
        if (root.hasRight() && !root.hasLeft()) {
            root.setLeft(new BinNode<>(root.getRight().getValue()));
        }
        ex37(root.getRight());
        ex37(root.getLeft());
    }

    //הפעולה מחזירה אמת עבור כל העצים שבהם ערך כל צומת לא עולה על הגובה

    public static void main(String[] args) {

    }

}