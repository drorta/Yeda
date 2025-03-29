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
        RealSet realSet = new RealSet();
        realSet.insert(1);
        realSet.insert(1, 2, 3, 4, -1, -2);
        System.out.println(realSet);
        RealSet realSet1 = clone(realSet);
        System.out.println(realSet);
        System.out.println(realSet1);
//        realSet.remove(4);
//        System.out.println(realSet);

    }

}
