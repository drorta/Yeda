import classes.Birth;
import classes.Collec;
import classes.School;
import classes.Student;
import utils.BinNode;
import utils.Node;
import utils.Queue;

public class L26 extends Main {

    public static Node<Student> getStudentsByMonth(School s, int month) {
        Node<Student> ret = new Node<>(new Student("-1", new Birth(-1, -1, -1)));
        Node<Student> p = ret;
        for (Node<Student> n : s.getAr()) {
            while (n != null) {
                if (n.getValue().getBirthDay().getMonth() == month) {
                    p.setNext(new Node<>(n.getValue()));
                    p = p.getNext();
                }
                n = n.getNext();
            }
        }
        return ret.getNext();
    }

    public static Node<Student>[] ex3(School s) {
        Node<Student>[] ret = new Node[12];
        int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int m : months) {
            ret[m - 1] = getStudentsByMonth(s, m);
        }
        return ret;
    }

    public static <T> boolean isBalanced(BinNode<T> root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getTreeHeight(root.getRight()) - getTreeHeight(root.getLeft())) > 1) {
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    public static void main(String[] args) {
    }

    public static void checkCollec(){
        Collec collec = new Collec();
        System.out.println(collec.add(2));
        System.out.println(collec.add(3));
        System.out.println(collec.add(4));
        System.out.println(collec.add(5));
        System.out.println(collec.add(2));
        System.out.println(collec.small());
        Collec collec1 = new Collec(5);
        System.out.println(collec1.add(4));
        System.out.println(collec1.add(5));
        System.out.println(collec1.add(6));
        System.out.println(collec.smallest(collec1));
        Collec collec2 = new Collec(1);
        System.out.println(collec.smallest(collec2));


    }

    public static void isBalancedCheck() {
        BinNode<Integer> root1 = buildTree(1);
        BinNode<Integer> root2 = buildTree(1, 2, 3, 4);
        BinNode<Integer> root3 = buildTree(1, 2, 3, 4, 5, 6);
        BinNode<Integer> root4 = buildTree(1, 2, 3, 4, 5, 6, 7);

        printMeTree(root1);
        printMeTree(root2);
        printMeTree(root3);
        printMeTree(root4);

        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
        System.out.println(isBalanced(root3));
        System.out.println(isBalanced(root4));
    }

    public static void ex3Check() {
        Node<Student> grade1 = buildNodes(
                new Student("a", new Birth(1, 1, 1)),
                new Student("b", new Birth(1, 2, 1)),
                new Student("c", new Birth(1, 3, 1)),
                new Student("d", new Birth(1, 4, 1))
        );
        Node<Student> grade2 = buildNodes(
                new Student("e", new Birth(1, 5, 1)),
                new Student("f", new Birth(1, 6, 1)),
                new Student("g", new Birth(1, 7, 1)),
                new Student("h", new Birth(1, 8, 1))
        );
        Node<Student> grade3 = buildNodes(
                new Student("i", new Birth(1, 9, 1)),
                new Student("j", new Birth(1, 10, 1)),
                new Student("k", new Birth(1, 11, 1)),
                new Student("l", new Birth(1, 12, 1))
        );
        Node<Student> grade4 = buildNodes(
                new Student("m", new Birth(1, 1, 1)),
                new Student("n", new Birth(1, 2, 1)),
                new Student("o", new Birth(1, 3, 1)),
                new Student("p", new Birth(1, 4, 1))
        );
        Node<Student> grade5 = buildNodes(
                new Student("q", new Birth(1, 5, 1)),
                new Student("r", new Birth(1, 6, 1)),
                new Student("s", new Birth(1, 7, 1)),
                new Student("t", new Birth(1, 8, 1))
        );
        Node<Student> grade6 = buildNodes(
                new Student("u", new Birth(1, 9, 1)),
                new Student("w", new Birth(1, 10, 1)),
                new Student("x", new Birth(1, 11, 1)),
                new Student("y", new Birth(1, 12, 1))
        );

        School s = new School(
                new Node[]{
                        grade1,
                        grade2,
                        grade3,
                        grade4,
                        grade5,
                        grade6
                }
        );

        Node<Student>[] ex3 = ex3(s);

        for (Node<Student> n : ex3) {
            System.out.println(n);
        }
    }

}
