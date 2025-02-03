import java.util.Objects;

public class H18 extends HelpCommands {

    public static boolean isSame(BinNode<Integer> root1, BinNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (Objects.equals(root1.getValue(), root2.getValue())) {
            return isSame(root1.getRight(), root2.getRight()) && isSame(root1.getLeft(), root2.getLeft());
        } else {
            return false;
        }
    }

    public static boolean isMirror(BinNode<Integer> root1, BinNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (Objects.equals(root1.getValue(), root2.getValue())) {
            return isSame(root1.getRight(), root2.getLeft()) && isSame(root1.getLeft(), root2.getRight());
        } else {
            return false;
        }
    }

    public static int getSumPositiveNumbers(BinNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getValue() > 0) {
            return root.getValue() + getSumPositiveNumbers(root.getRight()) + getSumPositiveNumbers(root.getLeft());
        }
        return getSumPositiveNumbers(root.getRight()) + getSumPositiveNumbers(root.getLeft());
    }

    public static int getSumNegativeNumbers(BinNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getValue() < 0) {
            return root.getValue() + getSumNegativeNumbers(root.getRight()) + getSumNegativeNumbers(root.getLeft());
        }
        return getSumNegativeNumbers(root.getRight()) + getSumNegativeNumbers(root.getLeft());
    }

    public static int ex20(BinNode<Integer> root) {
        return getSumPositiveNumbers(root) - Math.abs(getSumNegativeNumbers(root));
    }

    public static <T> boolean ex21(BinNode<T> root) {
        if (root == null) {
            return true;
        }
        if (getTreeHeight(root.getLeft()) - getTreeHeight(root.getRight()) <= 1) {
            return ex21(root.getLeft()) && ex21(root.getRight());
        } else {
            return false;
        }
    }

    public static int findMax(BinNode<Integer> root, int currentMax) {
        if (root == null) {
            return currentMax;
        }
        if (root.getValue() > currentMax) {
            return Math.max(findMax(root.getRight(), root.getValue()), findMax(root.getLeft(), root.getValue()));
        }
        return Math.max(findMax(root.getRight(), currentMax), findMax(root.getLeft(), currentMax));
    }

    public static int findMin(BinNode<Integer> root, int currentMin) {
        if (root == null) {
            return currentMin;
        }
        if (root.getValue() < currentMin) {
            return Math.min(findMin(root.getRight(), root.getValue()), findMin(root.getLeft(), root.getValue()));
        }
        return Math.min(findMin(root.getRight(), currentMin), findMin(root.getLeft(), currentMin));
    }

    public static int ex23A(BinNode<Integer> root) {
        return findMax(root, root.getValue());
    }

    public static int ex23B(BinNode<Integer> root) {
        return findMin(root, root.getValue());
    }

    public static int ex23C() {
        BinNode<Integer> root = buildTree(10);
        return Math.abs(ex23A(root) - ex23B(root));
    }

    public static boolean ex25(BinNode<Character> root, char c1, char c2) {
        if (root == null) {
            return false;
        }
        if (
                (root.getValue() == c1 &&
                        ((root.hasRight() && (root.getRight().getValue() == c2))
                                || (root.hasLeft() && (root.getLeft().getValue() == c2)))
                )
                        || (root.getValue() == c2 &&
                        ((root.hasRight() && (root.getRight().getValue() == c1))
                                || (root.hasLeft() && (root.getLeft().getValue() == c1)))
                )
        ) {
            return true;
        }
        return ex25(root.getRight(), c1, c2) || ex25(root.getLeft(), c1, c2);
    }

    public static void main(String[] args) {

    }

}
