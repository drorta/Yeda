public class H7 {

    public static int numOfAppearances(Queue<Integer> queue, int x) {
        int counter = 0;
        Queue<Integer> temp = new Queue<Integer>();
        while (!queue.isEmpty()) {
            if (queue.head() == x) {
                counter++;
            }
            temp.insert(queue.remove());
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
        return counter;
    }

    public static void removeAllX(Queue<Integer> queue, int x) {
        Queue<Integer> temp = new Queue<Integer>();
        while (!queue.isEmpty()) {
            if (queue.head() == x) {
                queue.remove();
            } else {
                temp.insert(queue.remove());
            }
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }

    public static Time subtractTime(Time time1, Time time2) {
        return new Time(
                Math.abs(time1.getHours() - time2.getHours()),
                Math.abs(time1.getMinutes() - time2.getMinutes()),
                Math.abs(time1.getSeconds() - time2.getSeconds())
        );
    }

    public static boolean ex1(Queue<Integer> queue, int x) {
        Queue<Integer> temp = new Queue<Integer>();
        int seq = 0;
        boolean isSeqGood = false;
        while (!queue.isEmpty()) {
            if (seq > 1) {
                isSeqGood = true;
            }
            if (queue.head() == x) {
                seq++;
            } else {
                seq = 0;
            }
            temp.insert(queue.remove());
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
        return isSeqGood;
    }

    public static void ex3(Queue<Integer> queue) {
        Queue<Integer> temp = new Queue<Integer>();
        while (!queue.isEmpty()) {
            if (numOfAppearances(queue, queue.head()) > 1) {
                int tempy = queue.remove();
                removeAllX(queue, tempy);
                temp.insert(tempy);
            } else {
                temp.insert(queue.remove());
            }
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }

    public static Time ex4A(Queue<Time> timeQueue) {
        Time firstplace = timeQueue.head();
        Queue<Time> temp = new Queue<Time>();
        Time lastplace = new Time();
        while (!timeQueue.isEmpty()) {
            Time current = timeQueue.head();
            temp.insert(timeQueue.remove());
            if (temp.isEmpty()) {
                lastplace = current;
            }
        }
        while (!temp.isEmpty()) {
            timeQueue.insert(temp.remove());
        }
        return subtractTime(firstplace, lastplace);
    }

    public static int[] ex4B(Queue<Time> timeQueue) {
        int minAOne;
        int minATwo;
        Time min = new Time();
        int counter = 3;
        timeQueue.insert(new Time(Integer.MAX_VALUE, 0, 0));
        minAOne = 1;
        minATwo = 2;
        Time temp1 = timeQueue.head();
        timeQueue.insert(timeQueue.remove());
        Time temp2 = timeQueue.head();
        timeQueue.insert(timeQueue.remove());
        min = subtractTime(temp1, temp2);
        while (timeQueue.head().getHours() != Integer.MAX_VALUE) {
            temp1 = timeQueue.head();
            timeQueue.insert(timeQueue.remove());
            if (timeQueue.head().getHours() != Integer.MAX_VALUE) {
                temp2 = timeQueue.head();
                if (subtractTime(temp1, temp2).isSmallerThan(min)) {
                    min = new Time(subtractTime(temp1, temp2));
                    minAOne = counter;
                    minATwo = counter + 1;
                    counter++;
                }
            }
        }
        timeQueue.remove();
        return new int[]{minAOne, minATwo};
    }

    public static boolean ex5(Queue<Integer> queue, int n) {
        int temmoppp = 1;
        while (temmoppp <= n) {
            if (numOfAppearances(queue, temmoppp) != temmoppp) {
                return false;
            }
            temmoppp++;
        }
        return true;
    }

    public static boolean ex6(Queue<String> galil, int guess) {
        int tempguess = guess;
        while (tempguess > 0) {
            if (galil.head() == "gold") {
                return true;
            }
            galil.insert(galil.remove());
            tempguess--;
        }
        return false;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.insert(1);
        queue.insert(1);
        queue.insert(1);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(3);
        queue.insert(2);
        System.out.println(queue);
        ex3(queue);
        System.out.println(queue);
    }

}
