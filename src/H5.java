import java.util.Scanner;

public class H5 {

    public static Stack<Integer> ex20pg160(Stack<Couple> st) {
        Stack<Integer> finalStack = new Stack<Integer>();
        Stack<Couple> temp = new Stack<Couple>();
        while (!st.isEmpty()) {
            for (int i = 0; i < st.top().getAppears(); i++) {
                finalStack.push(st.top().getNum());
            }
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return finalStack;
    }

    public static void ex21B(HiTec hiTec, int workerCode, int numOfPpl) {
        Stack<Worker> temp = new Stack<Worker>();
        while (hiTec.areThereWorkers()) {
            temp.push(hiTec.removeWorker());
            if (temp.top().getWorkerID() == workerCode && numOfPpl > 0) {
                System.out.println(temp.pop().getId());
                numOfPpl -= 1;
            }
        }
        while (!temp.isEmpty()) {
            hiTec.addWorker(temp.pop());
        }
    }

    public static void ex21C() {
//in main
    }

    public static int ex22(Stack<Domino> heap, Domino stone) {
        //סיבוכיות: O(n)
        boolean isX = false;
        boolean isY = false;
        Stack<Domino> temp = new Stack<Domino>();
        while (!heap.isEmpty()) {
            if (heap.top().getX() == stone.getX()) {
                isX = true;
            }
            if (heap.top().getY() == stone.getY()) {
                isY = true;
            }
            temp.push(heap.pop());
        }
        while (!temp.isEmpty()) {
            heap.push(temp.pop());
        }
        if (!isX && !isY) {
            return 0;
        } else if (isY && !isX || isX && !isY) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {

        //ex21C
        HiTec hiTec = new HiTec();
        hiTec.addWorker(new Worker(1, 111));
        hiTec.addWorker(new Worker(2, 222));
        hiTec.addWorker(new Worker(1, 11));
        hiTec.addWorker(new Worker(3, 11));
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextInt() != 0) {
            System.out.println("enter num of workers to remove");
            int numOf = scanner.nextInt();
            System.out.println("enter job id");
            int jobID = scanner.nextInt();
            ex21B(hiTec, jobID, numOf);
        }
        //

    }

}
