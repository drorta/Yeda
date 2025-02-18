import java.util.ArrayList;
import java.util.Scanner;

public class H20 extends HelpCommands {

    public static <T> void wideScan(BinNode<T> root) {
        Queue<BinNode<T>> qTree = new Queue<>();
        qTree.insert(root);
        while (!qTree.isEmpty()) {
            while (qTree.head() == null) {
                qTree.remove();
                if (qTree.isEmpty()) {
                    return;
                }
            }
            System.out.println(qTree.head().getValue());
            qTree.insert(qTree.head().getLeft());
            qTree.insert(qTree.head().getRight());
            qTree.remove();
        }
    }

    public static <T> boolean hasOneSon(BinNode<T> root) {
        return root.hasRight() && !root.hasLeft() || root.hasLeft() && !root.hasRight();

    }

    public static <T> void ex40(BinNode<T> root) {
        if (root == null) {
            return;
        }

        Queue<BinNode<T>> queue = new Queue<>();
        queue.insert(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = lengthQueue(queue);
            ArrayList<T> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                BinNode<T> node = queue.remove();

                if (level % 2 == 0) {
                    currentLevel.add(node.getValue());
                }

                if (node.hasRight()) {
                    queue.insert(node.getRight());
                }
                if (node.hasLeft()) {
                    queue.insert(node.getLeft());
                }
            }

            if (!currentLevel.isEmpty()) {
                for (T val : currentLevel) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            level++;
        }
    }

    public static <T> int getHeightOfValue(BinNode<T> root, T value) {
        if (root == null) {
            return -1;
        }
        if (root.getValue() == value) {
            return hightTree(root);
        }
        return Math.max(getHeightOfValue(root.getLeft(), value), getHeightOfValue(root.getRight(), value));
    }

    public static int ex42(BinNode<Integer> root, int val1, int val2) {
        return Math.abs(getHeightOfValue(root, val1) - getHeightOfValue(root, val2));
    }

    public static <T> void ex43(BinNode<T> root) {
        //השאלה לא מובנת, אנחנו בכל מקרה עושים סריקה לעומק ללא שימוש ברקורסיה, לא מוסבר מה זה ביקור לעומק ומה זה סריקה תחילית


    }


    public static void printLeftToRight(BinNode<Integer> root) {
        if (root == null) {
            return;
        }
        printLeftToRight(root.getLeft());
        System.out.println(root.getValue());
        printLeftToRight(root.getRight());
    }


    public static Scanner input = new Scanner(System.in);

    public static void AddToTree(int n, BinNode<Integer> root) {
        if (root == null)
            return;
        if (n > root.getValue() && root.hasRight())
            AddToTree(n, root.getRight());
        else if (n > root.getValue() && !root.hasRight()) {
            root.setRight(new BinNode<>(n));
        } else if (n < root.getValue() && root.hasLeft()) {
            AddToTree(n, root.getLeft());
        } else if (n < root.getValue() && !root.hasLeft()) {
            root.setLeft(new BinNode<>(n));
        }

    }

    public static BinNode<Integer> BuildSearchTree() { // q45 p219
        System.out.println("insert a number");
        int x = input.nextInt();

        BinNode<Integer> root = new BinNode<>(x);
        while (x != -999) {

            System.out.println("insert a number");
            x = input.nextInt();
            if (x != -999) {
                AddToTree(x, root);
            }
        }
        return root;
    }

    public static boolean IsItThere(Node<Integer> node, int n) { //o(n)
        Node<Integer> fst = node;
        while (fst != null) {
            if (fst.getValue() == n)
                return true;
            fst = fst.getNext();
        }
        return false;
    }

    public static int HowManyNodes(Node<Integer> node) { //o(n)
        Node<Integer> fst = node;
        int c = 0;
        while (fst != null) {
            c++;
            fst = fst.getNext();
        }
        return c;
    }

    public static int HowManyInTree(BinNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + HowManyInTree(root.getLeft()) + HowManyInTree(root.getRight());

    }

    public static Node<Integer> FromTreeToList(BinNode<Integer> root) { // q46
        Node<Integer> ret = new Node<>(Integer.MIN_VALUE);
        Node<Integer> temp = ret;
        int x = HowManyInTree(root);
        while (x != HowManyNodes(temp)) {
            while (root.getValue() > temp.getValue() && root.hasLeft()) {
                root = root.getLeft();
            }
            temp.setNext(new Node<>(root.getValue()));
            temp = temp.getNext();
        }
        return ret.getNext();
    }

    public static boolean IsItSorted(BinNode<Integer> root) { // q47
        if (root == null)
            return true;
        if (root.hasLeft() && root.hasRight()) {
            if (root.getValue() < root.getLeft().getValue() || root.getValue() > root.getRight().getValue())
                return false;
        } else if (root.hasRight() && !root.hasLeft()) {
            if (root.getValue() > root.getRight().getValue())
                return false;
        } else if (root.hasLeft() && !root.hasRight()) {
            if (root.getValue() < root.getLeft().getValue())
                return false;
        }
        return IsItSorted(root.getLeft()) && IsItSorted(root.getRight());
    }

    public static void printNodes(Node<?> node) {  // f
        System.out.print("[");
        while (node != null) {
            System.out.print(node);
            node = node.getNext();
            if (node != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }


    public static void main(String[] args) {
        BinNode<Integer> root = buildTree(5);
        printMeTree(root);
        ex40(root);
    }

}
