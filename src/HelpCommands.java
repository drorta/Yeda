public class HelpCommands {

    /**
     * @RuntimeComplexity O(n)
     * @param st The Stack you want to copy
     * @return A copy of the given Stack
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
     *
     * @param st the stack to search
     * @param c the char to search
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
     *
     * @param st the stack to search
     * @param c the char to search
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
     * @param st the stack to remove from
     * @param c the char to remove
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
     *
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
     *
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
     *
     * @param queue the queue to search in
     * @param x the value to search
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
     * @param queue the queue to remove from
     * @param x the value to remove
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
     *
     * @param queue the queue to search
     * @return the min value in the queue
     * @RuntimeComplexity O(n)
     */
    public static int findMin(Queue<Integer> queue){
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
     * @param queue the queue to remove from
     * @param x the num to remove
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
     * @param queue the queue to sort
     * @RuntimeComplexity O(n^2)
     */
    public static void sortQueue(Queue<Integer> queue){
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

}