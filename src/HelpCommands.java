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
        queue.insert(queue.remove());
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
     * Prints a node and all nodes linked to it
     *
     * @param node the first node
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
     */
    public static Node<Integer> buildNodes(int n) {
        int x = (int) (Math.random() * 10);
        Node<Integer> first = new Node<>(x);
        Node<Integer> p = first;
        for (int i = 0; i < n; i++) {
            x = (int) (Math.random() * 100);
            p.setNext(new Node<>(x));
            p = p.getNext();
        }
        return first;
    }

    /**
     * @param n the number of nodes to be in
     * @return a new sorted node
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
     */
    public static int findMin(Node<Integer> node) {
        int min = node.getValue();
        while (node != null) {
            min = Math.min(min, node.getNext().getValue());
            node = node.getNext();
        }
        return min;
    }

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
     * @param node  the node
     * @param start start point
     * @param end   end point
     * @return a new node containing the numbers between indexes start,end in the node
     */
    public static Node<Integer> subNode(Node<Integer> node, int start, int end) {
        for (int i = 1; i < start - 1; i++) {
            node = node.getNext();
        }
        Node<Integer> subNode = node.getNext();
        Node<Integer> temp = subNode;
        for (int i = 1; i < end - 1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return subNode;
    }

    /**
     * @param node the node
     * @return returns a sorted node from the numbers in the node
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

    public static Node<Integer> sortNodeAllowed(Node<Integer> node){
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

    public static Node<Integer> removeValue(Node<Integer> node, int value){
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

}