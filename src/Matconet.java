import classes.Vote;
import utils.BinNode;
import utils.Queue;

import java.util.Arrays;

public class Matconet extends Main {

    public static int lastOddNum(int[] arr){
        int lastOddNum = -1;
        for (int j : arr) {
            if (j % 2 == 1) {
                lastOddNum = j;
            }
        }
        return lastOddNum;
    }

//    //O(n*z§k) n is nodes in t1 and k is nodes in t2
//    public static boolean treeLessThanTree(BinNode<Integer> t1, BinNode<Integer> t2){
//        if (t1 == null) {
//            return true;
//        }
//        if (!lessThanTree(t2, t1.getValue())) {
//            return false;
//        }
//        return treeLessThanTree(t1.getLeft(), t2) && treeLessThanTree(t1.getRight(), t2);
//    }

    public static int theWinner(Vote[] arr){
        int[] votes = new int[40];
        for (Vote vote : arr){
            votes[vote.getFirst()] += 7;
            votes[vote.getSecond()] += 5;
            votes[vote.getThird()] += 1;
        }
        int max = -1;
        int maxSong = -1;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > max) {
                max = votes[i];
                maxSong = i;
            }
        }
        return maxSong;
    }

    public static int checkX(Queue<Integer> q, int x){
        Queue<Integer> t = new Queue<>();
        int count = 0;
        while (!q.isEmpty()) {
            if (q.head() == x) {
                q.remove();
                count++;
            } else {
                t.insert(q.remove());
            }
        }
        while (!t.isEmpty()) {
            q.insert(t.remove());
        }
        return count;
    }

    public static Queue<Integer> sortQueuee(Queue<Integer> queue){
        Queue<Integer> ret = new Queue<>();
        while (!queue.isEmpty()) {
            int currentVal = queue.head();
            int countOfVal = checkX(queue, currentVal);
            for (int i = 0; i < countOfVal; i++) {
                ret.insert(currentVal);
            }
        }
        return ret;
    }

    public static void move(Queue<Integer> q){
        Queue<Integer> negative = new Queue<>();
        Queue<Integer> zeros = new Queue<>();
        Queue<Integer> positive = new Queue<>();
        while (!q.isEmpty()) {
            if (q.head() == 0) {
                zeros.insert(q.remove());
            } else if (q.head() > 0) {
                positive.insert(q.remove());
            } else {
                negative.insert(q.remove());
            }
        }
        while (!positive.isEmpty()) {
            q.insert(positive.remove());
        }
        while (!zeros.isEmpty()) {
            q.insert(zeros.remove());
        }
        while (!negative.isEmpty()) {
            q.insert(negative.remove());
        }
    }

    public static Queue<Integer> queCouples(Queue<Integer> queue){
        Queue<Integer> clone = copyQueue(queue);
        Queue<Integer> ret = new Queue<>();
        while (!clone.isEmpty()) {
            int currentVal = clone.head();
            if (checkX(queue, currentVal) == 2) {
                ret.insert(currentVal);
            }
        }
        return ret;
    }





    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,1,1,5,-1,2};
        System.out.println(Arrays.toString(Arrays.stream(a).sorted().toArray()));
    }
}
