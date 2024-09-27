public class H4 {

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

    public static boolean ex5(Stack<Integer> st) {
        Stack<Integer> temp = copySt(st);
        int prev = temp.pop();
        while (!temp.isEmpty()) {
            if (temp.top() >= prev) {
                return false;
            } else {
                prev = temp.pop();
            }
        }
        return true;
    }

    public static void ex6(Stack<Integer> st) {
        int top = st.pop();
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        st.push(top);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static String ex7(Stack<String> st, int back) {
        if (back == 1) {
            return st.top();
        }
        Stack<String> temp = new Stack<>();
        for (int i = 0; i < back; i++) {
            temp.push(st.pop());
        }
        String ret = st.top();
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return ret;
    }

    public static boolean ex8(Stack<Integer> st1, Stack<Integer> st2) {
        return false;
    }

    public static boolean ex16(Stack<Integer> st, int num) {
        Stack<Integer> temp = new Stack<>();
        int prevTwo = st.top();
        temp.push(st.pop());
        int prev = st.top();
        temp.push(st.pop());
        while (!st.isEmpty()) {
            if (prevTwo == num % 1000 / 100 && prev == num % 100 / 10 && st.top() == num % 10) {
                return true;
            }
            prevTwo = st.top();
            temp.push(st.pop());
            if (!st.isEmpty()) {
                prev = st.top();
                temp.push(st.pop());
            }
        }
        prevTwo = temp.top();
        st.push(temp.pop());
        prev = temp.top();
        st.push(temp.pop());
        while (!temp.isEmpty()) {
            if (prevTwo == num % 1000 / 100 && prev == num % 100 / 10 && temp.top() == num % 10) {
                return true;
            }
            prevTwo = temp.top();
            temp.push(temp.pop());
            if (!temp.isEmpty()) {
                prev = temp.top();
                temp.push(temp.pop());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> exp = new Stack<Integer>();
        exp.push(1);
        exp.push(2);
        exp.push(3);
        exp.push(4);
        exp.push(5);
        exp.push(6);
        exp.push(7);
        exp.push(8);
        exp.push(9);
        System.out.println(ex16(exp, 123));
    }

}
