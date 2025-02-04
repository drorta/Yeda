import java.util.Objects;

public class L19 extends HelpCommands {

    public static String eraseFirst(String str) {
        return str.substring(1);
    }

    public static boolean wordFromRoot(BinNode<Character> tree, String str) {
        if (Objects.equals(str, "")) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        if (tree.getValue() == str.charAt(0)) {
            return wordFromRoot(tree.getLeft(), eraseFirst(str)) || wordFromRoot(tree.getRight(), eraseFirst(str));
        }
        return wordFromRoot(tree.getLeft(), str) || wordFromRoot(tree.getRight(), str);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean addNodes(BinNode<Integer> leaf) {
        if (isPrime(leaf.getValue())) {
            return false;
        }
        else {
            for (int i = 2; i <= leaf.getValue() / 2; i++) {
                if (leaf.getValue() % i == 0) {
                    leaf.setRight(new BinNode<>(leaf.getValue() / i));
                    leaf.setLeft(new BinNode<>(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinNode<Integer> leaf = new BinNode<>(5);
        addNodes(leaf);
        printMeTree(leaf);
    }

}
