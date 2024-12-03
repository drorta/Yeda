public class LHashlama {

    public static Queue<Integer> copy(Queue<Integer> queue){
        Queue<Integer> temp = new Queue<Integer>();
        Queue<Integer> copy = new Queue<Integer>();
        while (!queue.isEmpty()) {
            temp.insert(queue.remove());
        }
        while (!temp.isEmpty()) {
            copy.insert(temp.head());
            queue.insert(temp.remove());
        }
        return copy;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.insert(5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        System.out.println(queue);
        System.out.println("--");
        System.out.println(copy(queue));
        System.out.println(queue);
    }

}
