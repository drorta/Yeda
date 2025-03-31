import classes.RealSet;
import utils.BinNode;
import utils.Queue;

public class L25 extends Main {

    public static RealSet clone(RealSet rs){
        RealSet temp = new RealSet();
        for (int i = 0; i < rs.size(); i++) {
            temp.insert(rs.findBiggest());
            rs.remove(rs.findBiggest());
        }
        RealSet clone = new RealSet();
        for (int i = 0; i < temp.size(); i++) {
            double biggest = temp.findBiggest();
            rs.insert(biggest);
            clone.insert(biggest);
            temp.remove(biggest);
        }
        return clone;
    }

    public static RealSet buildNeg(RealSet rs){
        RealSet findIfThereIsNegative = clone(rs);
        boolean isThereNegative = false;
        for (int i = 0; i < findIfThereIsNegative.size(); i++) {
            double biggest = findIfThereIsNegative.findBiggest();
            if (biggest < 0) {
                isThereNegative = true;
            }
            findIfThereIsNegative.remove(biggest);
        }
        if (!isThereNegative) {
            return new RealSet();
        }

        RealSet clone = clone(rs);
        while (clone.findBiggest() > 0) {
            clone.remove(clone.findBiggest());
        }
        return clone;
    }

    public static <T> void inOrder(BinNode<T> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root);
            inOrder(root.getRight());
        }
    }

    public static Queue<Integer> q2A(BinNode<Queue<Integer>> root){
        return q2A(root, new Queue<>());
    }

    public static Queue<Integer> q2A(BinNode<Queue<Integer>> root, Queue<Integer> queue){
        if (root != null) {
            q2A(root.getLeft(), queue);
            if (root.getValue().isEmpty()) {
                queue.insert(0);
            } else if (lengthQueue(root.getValue()) == 1) {
                queue.insert(root.getValue().remove());
            } else if (lengthQueue(root.getValue()) == 2) {
                queue.insert(root.getValue().remove() + root.getValue().remove());
            } else {
                queue.insert(
                        root.getValue().remove() +
                                root.getValue().remove() +
                                root.getValue().remove()
                );
            }
            q2A(root.getRight(), queue);
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = buildQueue(8,4,9,7);
        Queue<Integer> q2 = buildQueue(1,8,1,2);
        Queue<Integer> q3 = buildQueue(3,1);
        Queue<Integer> q4 = new Queue<>();
        Queue<Integer> q5 = buildQueue(2,9,4,1);

        BinNode<Queue<Integer>> root = new BinNode<>(q1);
        root.setRight(new BinNode<>(q2));
        root.getRight().setLeft(new BinNode<>(q3));
        root.getRight().setRight(new BinNode<>(q4));
        root.getRight().getRight().setLeft(new BinNode<>(q5));

        System.out.println(q2A(root));
    }

}
