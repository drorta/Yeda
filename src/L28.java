import utils.Queue;

public class L28 extends Main {

    public static int sumH(Queue<Integer> queue) {
        int x = queue.remove();
        if (queue.head() > x) {
            queue.insert(x);
            return queue.head() - x + sumH(queue);
        } else {
             queue.insert(x);
             return 0;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = buildQueue(1,4,8,17,20);
        System.out.println(queue);
        System.out.println(sumH(queue));
        System.out.println(queue);
    }

}
