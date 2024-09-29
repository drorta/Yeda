public class H4 {

    //פעולות עזר

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

    //

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
        Stack<Integer> temp1 = copySt(st1);
        Stack<Integer> temp2 = copySt(st2);
        ex17B(temp1);
        ex17B(temp2);
        return isSame(temp1,temp2);
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

//    public static int ex17A(Stack<Integer> st) {
//        Stack<Integer> temp = new Stack<Integer>();
//        int min = st.top();
//        while (!st.isEmpty()) {
//            temp.push(st.pop());
//            if (!st.isEmpty()) {
//                if (Math.min(min, st.top()) == st.top()) {
//                    min = st.top();
//                }
//            }
//        }
//        while (!temp.isEmpty()) {
//            st.push(temp.pop());
//        }
//        return min;
//    }

    public static int ex17A(Stack<Integer> st) {
        if (st.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        int top = st.pop();
        int min = ex17A(st);
        st.push(top);
        return Math.min(top, min);
    }

    public static void removeNum(Stack<Integer> st, int num) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            int popped = st.pop();
            if (popped == num) {
                num = Integer.MAX_VALUE;
            } else {
                temp.push(popped);
            }
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static void ex17B(Stack<Integer> st) {
        Stack<Integer> sorted = new Stack<Integer>();
        int min;
        while (!st.isEmpty()) {
            min = ex17A(st);
            sorted.push(min);
            removeNum(st, min);
        }
        while (!sorted.isEmpty()) {
            st.push(sorted.pop());
        }
    }

    public static String ex18(String string) {
        Stack<Character> temp = new Stack<Character>();
        Stack<Character> finale = new Stack<Character>();
        while (!string.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                if (!string.isEmpty()) {
                    temp.push(string.charAt(0));
                    string = string.substring(1);
                }
            }
            while (!temp.isEmpty()) {
                finale.push(temp.pop());
            }
        }
        while (!finale.isEmpty()) {
            temp.push(finale.pop());
        }
        return temp.toString();
    }

    public static int ex19(Stack<Integer> st) {
        int prev = st.top();
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(st.pop());
        int retzef = 0;
        int maxRetzef = 0;
        while (!st.isEmpty()) {
            if (prev == st.top() + 1) {
                retzef++;
                if (retzef > maxRetzef) {
                    maxRetzef = retzef;
                }
            } else {
                retzef = 0;
            }
            prev = st.top();
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return maxRetzef;
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
        Stack<Integer> exp2 = new Stack<Integer>();
        exp2.push(9);
        exp2.push(8);
        exp2.push(7);
        exp2.push(6);
        exp2.push(5);
        exp2.push(4);
        exp2.push(1000);
        exp2.push(2);
        exp2.push(1);
        System.out.println(ex8(exp,exp2));
    }

}
