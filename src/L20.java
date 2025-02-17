import java.util.ArrayList;
import java.util.Arrays;

public class L20 extends HelpCommands {

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

//    public static boolean ex38(BinNode<Integer> root){
//
//    }

    public static <T> int ex41(BinNode<T> root, T value){
        Queue<BinNode<T>> qTree = new Queue<>();
        qTree.insert(root);
        int i = 0;
        while (!qTree.isEmpty()) {
            while (qTree.head() == null) {
                qTree.remove();
                if (qTree.isEmpty()) {
                    return -1;
                }
            }
            if (qTree.head().getValue() == value) {
                return i;
            }
            if (qTree.head().hasLeft()) {
                qTree.insert(qTree.head().getLeft());
            }
            if (qTree.head().hasRight()) {
                qTree.insert(qTree.head().getRight());
            }
            qTree.remove();
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinNode<Integer> root = buildTree(1,2,2,2,2,20);
        printMeTree(root);
        System.out.println(ex41(root, 20));
    }

}
