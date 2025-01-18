import java.util.Arrays;

public class HelpCommands {

    /**
     * @param st The Stack you want to copy
     * @return A copy of the given Stack
     * @RuntimeComplexity O(n)
     */
    public static Stack<Integer> copySt(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<Integer>();
        Stack<Integer> copy = new Stack<Integer>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.top());
            copy.push(temp.pop());
        }
        return copy;
    }

    /**
     * @param st the stack to search
     * @param c  the char to search
     * @return if @param c exists within @param st
     * @RuntimeComplexity O(n)
     */
    public static boolean hasChar(Stack<Character> st, char c) {
        Stack<Character> temp = new Stack<Character>();
        while (!st.isEmpty()) {
            if (st.top() == c) {
                return true;
            }
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return false;
    }

    /**
     * @param st the stack to search
     * @param c  the char to search
     * @return the number of time @param c is withing @param st
     * @RuntimeComplexity O(n)
     */
    public static int numOfCharInSt(Stack<Character> st, char c) {
        Stack<Character> temp = new Stack<Character>();
        int count = 0;
        while (!st.isEmpty()) {
            if (st.top() == c) {
                count++;
            }
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return count;
    }

    /**
     * Removes c from the given stack
     *
     * @param st the stack to remove from
     * @param c  the char to remove
     * @RuntimeComplexity O(n)
     */
    public static void removeChar(Stack<Character> st, char c) {
        Stack<Character> temp = new Stack<Character>();
        while (!st.isEmpty()) {
            char popped = st.pop();
            if (popped == c) {
                c = Character.MAX_VALUE;
            } else {
                temp.push(popped);
            }
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    /**
     * @param st
     * @return the length of st
     * @RuntimeComplexity O(n)
     */
    public static int stLen(Stack<Integer> st) {
        int len = 0;
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            len++;
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return len;
    }

    /**
     * @param st1
     * @param st2
     * @return is st1 and st2 same
     * @RuntimeComplexity O(n)
     */
    public static boolean isSame(Stack<Integer> st1, Stack<Integer> st2) {
        Stack<Integer> temp1 = copySt(st1);
        Stack<Integer> temp2 = copySt(st2);
        if (stLen(st1) != stLen(st2)) {
            return false;
        }
        while (!temp1.isEmpty()) {
            int a = temp1.pop();
            int b = temp2.pop();
            if (a != b) return false;
        }
        return true;
    }

    /**
     * @param queue the queue to search in
     * @param x     the value to search
     * @return the number of appearances x has in the given queue
     * @RuntimeComplexity O(n)
     */
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

    /**
     * Removes all x present inside the queue
     *
     * @param queue the queue to remove from
     * @param x     the value to remove
     * @RuntimeComplexity O(n)
     */
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

    /**
     * @param queue the queue to search
     * @return the min value in the queue
     * @RuntimeComplexity O(n)
     */
    public static int findMin(Queue<Integer> queue) {
        int min = queue.head();
        queue.insert(Integer.MAX_VALUE);
        while (queue.head() != Integer.MAX_VALUE) {
            if (queue.head() < min) {
                min = queue.head();
            }
            queue.insert(queue.remove());
        }
        queue.remove();
        return min;
    }

    /**
     * Removes x from the queue
     *
     * @param queue the queue to remove from
     * @param x     the num to remove
     * @RuntimeComplexity O(n)
     */
    public static void removeXFromQ(Queue<Integer> queue, int x) {
        Queue<Integer> temp = new Queue<Integer>();
        while (!queue.isEmpty()) {
            int popped = queue.remove();
            if (popped == x) {
                x = Integer.MAX_VALUE;
            } else {
                temp.insert(popped);
            }
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }

    /**
     * Sorts the given queue
     *
     * @param queue the queue to sort
     * @RuntimeComplexity O(n ^ 2)
     */
    public static void sortQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new Queue<Integer>();
        while (!queue.isEmpty()) {
            int min = findMin(queue);
            removeXFromQ(queue, min);
            temp.insert(min);
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }

    /**
     * @param queue
     * @return the sum
     * @RuntimeComplexity O(A LOT)
     */
    public static int sumQRec(Queue<Integer> queue) {
        Queue<Integer> copy = copyQueue(queue);
        if (copy.isEmpty()) {
            return 0;
        }
        return copy.remove() + sumQRec(copy);
    }

    /**
     * NOTE: when running a recursive loop on a queue, it will always reverse itself, unless doing some tricks
     *
     * @param queue
     * @return the sum
     */
    public static int sumQRecButReverses(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return 0;
        } else {
            int x = queue.remove();
            int sum = x + sumQRecButReverses(queue);
            queue.insert(x);
            return sum;
        }
    }

    /**
     * @param queue
     * @return a copy of the given queue
     * @RuntimeComplexity O(n)
     */
    public static Queue<Integer> copyQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new Queue<>();
        while (!queue.isEmpty()) {
            temp.insert(queue.remove());
        }
        Queue<Integer> copy = new Queue<>();
        while (!temp.isEmpty()) {
            copy.insert(temp.head());
            queue.insert(temp.remove());
        }
        return copy;
    }

    /**
     * @param n
     * @param max
     * @return a new queue with n nodes and a max value of param max
     * @RuntimeComplexity O(param n)
     */
    public static Queue<Integer> buildQueue(int n, int max) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.insert((int) (Math.random() * max));
        }
        return queue;
    }

    /**
     * @param queue
     * @return the length of the queue
     */
    public static int lengthQueue(Queue<Integer> queue) {
        int len = 0;
        Queue<Integer> temp = new Queue<>();
        while (!queue.isEmpty()) {
            temp.insert(queue.remove());
            len++;
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
        return len;
    }

    /**
     * Returns a flipped form of the given queue while not destroying the original queue
     *
     * @param queue
     * @return the flipped queue
     */
    public static Queue<Integer> flipQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new Queue<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> flip = new Queue<>();
        while (!queue.isEmpty()) {
            temp.insert(queue.head());
            stack.push(queue.remove());
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
            flip.insert(stack.pop());
        }
        return flip;
    }

    /**
     * flips the given queue recursively
     *
     * @param q1
     */
    public static void flipQueueRec(Queue<Double> q1) {
        if (!q1.isEmpty()) {
            double x = q1.remove();
            flipQueueRec(q1);
            q1.insert(x);
        }
    }

    /**
     * Prints a node and all nodes linked to it
     *
     * @param node the first node
     * @RuntimeComplexity O(n)
     */
    public static void printNodes(Node<?> node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node);
            node = node.getNext();
            if (node != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * @param n the number of nodes to be in the node
     * @return a new chainlink of nodes
     * @RuntimeComplexity O(param n)
     */
    public static Node<Integer> buildNodes(int n) {
        int x = (int) (Math.random() * 10);
        Node<Integer> first = new Node<>(x);
        Node<Integer> p = first;
        for (int i = 0; i < n; i++) {
            x = (int) (Math.random() * 10);
            p.setNext(new Node<>(x));
            p = p.getNext();
        }
        return first;
    }

    /**
     * @param numbers the numbers to put in the node
     * @return a new nodes with the given numbers in order
     */
    public static Node<Integer> buildNodes(int... numbers) {
        Node<Integer> ret = new Node<>(0);
        Node<Integer> p = ret;
        for (int i = 0; i < numbers.length; i++) {
            p.setNext(new Node<>(numbers[i]));
            p = p.getNext();
        }
        return ret.getNext();
    }

    /**
     * @param n the number of nodes to be in
     * @return a new sorted node
     * @RuntimeComplexity O(param n)
     */
    public static Node<Integer> buildSortNode(int n) {
        Node<Integer> ret = new Node<>(0);
        Node<Integer> p = ret;
        for (int i = 0; i < n; i++) {
            p.setNext(new Node<>(i + 1));
            p = p.getNext();
        }
        return ret;
    }

    /**
     * @param node the node
     * @return The sum of a node and all nodes linked to it
     * @RuntimeComplexity O(n)
     */
    public static int sumNodes(Node<Integer> node) {
        int sum = 0;
        while (node != null) {
            sum += node.getValue();
            node = node.getNext();
        }
        return sum;
    }

    /**
     * @param node  the node to search in
     * @param value the value to search
     * @return does value exist in the node
     * @RuntimeComplexity O(n)
     */
    public static boolean hasValue(Node<Integer> node, int value) {
        boolean has = false;
        while (node != null) {
            if (node.getValue() == value) {
                has = true;
            }
            node = node.getNext();
        }
        return has;
    }

    /**
     * @param node  the node to search in
     * @param value the value to search
     * @return the number of time value is in the node
     * @RuntimeComplexity O(n)
     */
    public static int countVal(Node<Integer> node, int value) {
        int count = 0;
        while (node != null) {
            if (node.getValue() == value) {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    /**
     * @param node the node to search in
     * @return the min value in the node
     * @RuntimeComplexity O(n)
     */
    public static int findMin(Node<Integer> node) {
        int min = node.getValue();
        while (node != null) {
            min = Math.min(min, node.getNext().getValue());
            node = node.getNext();
        }
        return min;
    }

    /**
     * @param node the node to search in
     * @return the max value in the node
     * @RuntimeComplexity O(n)
     */
    public static int findMax(Node<Integer> node) {
        int max = node.getValue();
        while (node.getNext() != null) {
            max = Math.max(max, node.getNext().getValue());
            node = node.getNext();
        }
        return max;
    }

    /**
     * @param node the node
     * @return the length of the node
     * @RuntimeComplexity O(n)
     */
    public static int lenNodes(Node<Integer> node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    /**
     * @param node the node
     * @return the length of the node
     * @RuntimeComplexity O(n)
     */
    public static int lenNodesChar(Node<Character> node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    /**
     * @param node  the node
     * @param start start point
     * @param end   end point
     * @return a new node containing the numbers between indexes start,end in the node
     * @RuntimeComplexity O(n = start + ( end - start))
     */
    public static Node<?> subNode(Node<?> node, int start, int end) {
        for (int i = 1; i < start - 1; i++) {
            node = node.getNext();
        }
        Node<?> subNode = node.getNext();
        Node<?> temp = subNode;
        for (int i = 1; i < end - 1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return subNode;
    }

    /**
     * @param node the node
     * @return returns a sorted node from the numbers in the node
     * @RuntimeComplexity O(n)
     */
    public static Node<Integer> sortNode(Node<Integer> node) {
        int[] nodeValues = new int[lenNodes(node)];
        for (int i = 0; i < nodeValues.length; i++) {
            nodeValues[i] = node.getValue();
            node = node.getNext();
        }
        nodeValues = Arrays.stream(nodeValues).sorted().toArray();
        Node<Integer> sorted = new Node<>(nodeValues[0]);
        Node<Integer> temp = sorted;
        for (int i = 1; i < nodeValues.length; i++) {
            temp.setNext(new Node<>(nodeValues[i]));
            temp = temp.getNext();
        }
        return sorted;
    }

    /**
     * @param node the node to sort
     * @return a sorted node from the numbers in the node
     * @RuntimeComplexity O(n ^ 2)
     */
    public static Node<Integer> sortNodeAllowed(Node<Integer> node) {
        if (node == null) {
            return null;
        }
        Node<Integer> sorted = new Node<>(0);
        Node<Integer> p = sorted;
        int firstmin = findMin(node);
        for (int i = 0; i < countVal(node, firstmin); i++) {
            p.setNext(new Node<>(firstmin));
            p = p.getNext();
        }
        node = removeValue(node, firstmin);
        for (int i = 0; i < lenNodes(node); i++) {
            int min = findMin(node);
            for (int j = 0; j < countVal(node, min); j++) {
                p.setNext(new Node<>(min));
                p = p.getNext();
            }
            node = removeValue(node, min);
        }
        return sorted;
    }

    /**
     * @param node  the node
     * @param value the value to remove
     * @return the same node but without all the nodes with the param value
     * @RuntimeComplexity O(n)
     */
    public static Node<Integer> removeValue(Node<Integer> node, int value) {
        if (node.getValue() == value) {
            node = node.getNext();
        }
        Node<Integer> p = node;
        for (int i = 0; i < lenNodes(node); i++) {
            if (p.getNext().getValue() == value) {
                p.setNext(p.getNext().getNext());
            } else {
                p = p.getNext();
            }
        }
        return node;
    }

    /**
     * @param node  the node to search in
     * @param value the value to search
     * @return the number of time value is in the node
     * @RuntimeComplexity O(n)
     */
    public static int countVal(Node<Character> node, char value) {
        int count = 0;
        while (node != null) {
            if (node.getValue() == value) {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    /**
     * @param node
     * @param value
     * @return returns a new node with first value being param value and the next is the given node
     */
    public static <T> Node<T> setFirst(Node<T> node, T value) {
        Node<T> ret = new Node<>(value);
        ret.setNext(node);
        return ret;
    }

    public static <T> Node<T> setFirst(Node<T> node, Node<T> value) {
        value.setNext(node);
        return value;
    }

    public static <T> void setLast(Node<T> node, T value) {
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node<>(value));
    }

    public static <T> void setLast(Node<T> node, Node<T> value) {
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(value);
    }

    /**
     * @param fst the node to reverse
     * @return a reversed form of the given node
     */
    public static Node<Integer> reverseNode(Node<Integer> fst) {
        Node<Integer> prev = null;
        Node<Integer> current = fst;
        Node<Integer> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * A generic function
     *
     * @param node  the node to search
     * @param index the index
     * @param <T>   the Type of the node
     * @return the value in the node in the given index
     */
    public static <T> T valueAt(Node<T> node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * A generic function
     *
     * @param node  the node to search
     * @param index the index
     * @param <T>   the Type of the node
     * @return the node in the given index
     */
    public static <T> Node<T> nodeAt(Node<T> node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

}