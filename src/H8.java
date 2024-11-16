import java.util.Objects;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class H8 {

    /**
     * @param n   The number of integers in the result Queue;
     * @param top The max value of an integer in the Queue
     * @return A randomly generated Queue
     * @RuntimeComplexity O(@ param n)
     */
    public static Queue<Integer> buildIntQ(int n, int top) {
        Queue<Integer> finale = new Queue<Integer>();
        for (int i = 0; i < n; i++) {
            finale.insert(RandomGenerator.getDefault().nextInt(top) + 1);
        }
        return finale;
    }


    public static Stack<Integer> ex7pg177(Queue<Integer> queue) {
        Stack<Integer> finale = new Stack<Integer>();
        while (!queue.isEmpty()) {
            int min = HelpCommands.findMin(queue);
            HelpCommands.removeXFromQ(queue, min);
            finale.push(min);
        }
        return finale;
    }

    public static void ex9pg178(Queue<Integer> active, Queue<Integer> closed) {
        Queue<Integer> temp = new Queue<Integer>();
        while (!closed.isEmpty() && !active.isEmpty()) {
            temp.insert(active.remove());
            temp.insert(closed.remove());
        }
        if (active.isEmpty() && !closed.isEmpty()) {
            while (!closed.isEmpty()) {
                temp.insert(closed.remove());
            }
        } else if (!active.isEmpty() && closed.isEmpty()) {
            while (!active.isEmpty()) {
                temp.insert(active.remove());
            }
        }
        while (!temp.isEmpty()) {
            active.insert(temp.remove());
        }
    }

    /**
     * Makes q1 a sorted queue made out of both queues values
     *
     * @param q1
     * @param q2
     * @RuntimeComplexity O(n ^ 2)
     */
    public static void ex10pg178(Queue<Integer> q1, Queue<Integer> q2) {
        ex9pg178(q1, q2);
        HelpCommands.sortQueue(q1);
    }

    /**
     * @param queue
     * @value 1 - Costumer add
     * @value 2 - Costumer gets service
     * @value 3 - Exit
     */
    public static void ex12pg178(DoubleQueue<Integer> queue) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextInt() != 3) {
            System.out.println("What would you like to do?");
            if (scanner.nextInt() == 1) {
                System.out.println("What is the costumer's account number?");
                int acc = scanner.nextInt();
                System.out.println("Does the costumer's request has anything to do with cash? Enter yes or no");
                if (Objects.equals(scanner.next(), "yes")) {
                    queue.add(0, acc);
                } else {
                    queue.add(1, acc);
                }
            } else if (scanner.nextInt() == 2) {
                System.out.println("Account number " + queue.remove() + " got serviced and exited the queue");
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = buildIntQ(4, 10);
        Queue<Integer> q2 = buildIntQ(4, 10);
        System.out.println(q1);
        System.out.println(q2);
        ex9pg178(q1, q2);
        System.out.println(q1);
        System.out.println(q2);
    }


}
