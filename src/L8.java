import java.util.random.RandomGenerator;

public class L8 {

    //idx = 0
    public static boolean countM(int[] arr, int x, int m, int idx) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == x) {
            if (m < 0) {
                return false;
            }
            return countM(arr, x, m - 1, idx + 1);
        }
        if (m == 0) {
            return true;
        }
        return countM(arr, x, m, idx + 1);
    }

    public static int minDig(int num) {
        if (num == 0) {
            return Integer.MAX_VALUE;
        }
        int currentdig = num % 10;
        int next = minDig(num / 10);
        return Math.min(currentdig, next);
    }

    public static boolean check(int[] arr, int idx, int m) {
        if (idx == arr.length) {
            return true;
        }
        if (Math.min(minDig(arr[idx]), m) == m) {
            return check(arr, idx + 1, m);
        }
        return false;
    }

    //not finished
//    public static void hefresh(Stack<Integer> s1, Stack<Integer> s2){
//        Stack<Integer> temp1 = new Stack<Integer>();
//        Stack<Integer> temp2 = new Stack<Integer>();
//        while (!s1.isEmpty()) {
//
//        }
//    }

    //

    public static Queue<Domino> buildDomino(int n) {
        Queue<Domino> finale = new Queue<Domino>();
        for (int i = 0; i < n; i++) {
            finale.insert(new Domino());
        }
        return finale;
    }

    public static boolean isDouble(Queue<Domino> queue) {
        queue.insert(new Domino(Integer.MAX_VALUE, Integer.MAX_VALUE));
        boolean flag = false;
        while (queue.head().getTopSide() != Integer.MAX_VALUE && !flag) {
            if (queue.head().getTopSide() == queue.head().getBottomSide()) {
                flag = true;
            }
            queue.insert(queue.remove());
        }
        while (queue.head().getTopSide() != Integer.MAX_VALUE) {
            queue.insert(queue.remove());
        }
        queue.remove();
        return flag;
    }

    public static void removeZero(Queue<Domino> queue) {
        queue.insert(new Domino(Integer.MAX_VALUE, Integer.MAX_VALUE));
        while (queue.head().getTopSide() != Integer.MAX_VALUE) {
            if (queue.head().getTopSide() == 0 || queue.head().getBottomSide() == 0) {
                queue.remove();
            } else queue.insert(queue.remove());
        }
        queue.remove();
    }

    public static void hefresh(Queue<Domino> queue1, Queue<Domino> queue2) {
        queue1.insert(null);
        queue2.insert(null);
        while (queue1.head() != null) {
            if (queue1.head().isSame(queue2.head())) {
                queue1.remove();
            }
            queue1.insert(queue1.remove());
            queue2.insert(queue2.remove());
        }
        while (queue2.head() != null) {
            queue2.insert(queue2.remove());
        }
        queue1.remove();
        queue2.remove();
    }

    public static Queue<Job> buildJob(int n){
        Queue<Job> finale = new Queue<Job>();
        for (int i = 0; i < n; i++) {
            finale.insert(new Job());
        }
        return finale;
    }

    public static void ex8pg177(Queue<Job> queue, int timeToWork) {
        queue.insert(new Job(Integer.MAX_VALUE, Integer.MAX_VALUE));
        while (queue.head().getId() != Integer.MAX_VALUE) {
            if (queue.head().getWorkTimeSec() <= timeToWork) {
                System.out.println(queue.head().getId());
            }
            queue.insert(queue.remove());
        }
        queue.remove();
    }

    public static void main(String[] args) {
//        Queue<Domino> dominoQueue = buildDomino(5);
//        Queue<Domino> dominoQueue1 = buildDomino(5);
//        System.out.println("0:" + dominoQueue);
//        System.out.println("1:" + dominoQueue1);
//        hefresh(dominoQueue, dominoQueue1);
//        System.out.println("0:" + dominoQueue);
//        System.out.println("1:" + dominoQueue1);
        System.out.println(ex53(1234569));
    }

    public static int ex53(int num){
        if (num / 10 == 0) {
            return num%10;
        }
        return ex53(HelpCommands.sumRec(num));
    }

}
