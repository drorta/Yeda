public class L6 {

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

    public static int countStRec(Stack<Integer> st){
        Stack<Integer> copy = copySt(st);
        if (copy.isEmpty()) {
            return 0;
        }
        copy.pop();
        return 1 + countStRec(copy);
    }

    public static int countStRec2(Stack<Integer> st){
        if (st.isEmpty()) {
            return 0;
        }
        int x = st.pop();
        int sum = countStRec2(st);
        st.push(x);
        return 1 + sum;
    }

    public static void what2(Stack<Integer> st1, Stack<Integer> st2){
        if (!st1.isEmpty()) {
            int x = st1.pop();
            what2(st1,st2);
            st1.push(x);
            st2.push(x);
        }
    }
    //סיבוכיות: O(n)



    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
//        System.out.println(countStRec2(test));
//        System.out.println(test);
        Stack<Integer> st2 = new Stack<Integer>();
        what2(test,st2);
    }

}
