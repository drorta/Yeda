public class H5 {

//    public static boolean hasChar(Stack<Character> st, char c){
//        Stack<Character> temp = new Stack<Character>();
//        while (!st.isEmpty()) {
//            if (st.top() == c) {
//                return true;
//            }
//            temp.push(st.pop());
//        }
//        while (!temp.isEmpty()) {
//            st.push(temp.pop());
//        }
//        return false;
//    }

//    public static void removeChar(Stack<Character> st, char c){
//        Stack<Character> temp = new Stack<Character>();
//        while (!st.isEmpty()) {
//            if (st.top() == c) {
//                st.pop();
//            }
//            else temp.push(st.pop());
//        }
//        while (!temp.isEmpty()) {
//            st.push(temp.pop());
//        }
//    }

    public static int numOfCharInSt(Stack<Character> st, char c){
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

    public static void removeChar(Stack<Character> st, char c) {
        Stack<Character> temp = new Stack<Character>();
        while (!st.isEmpty()) {
            char popped = st.pop();
            if (popped ==  c) {
                c = Character.MAX_VALUE;
            } else {
                temp.push(popped);
            }
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static Stack<Character> copySt(Stack<Character> st) {
        Stack<Character> temp = new Stack<Character>();
        Stack<Character> copy = new Stack<Character>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.top());
            copy.push(temp.pop());
        }
        return copy;
    }

    public static Stack<A> compress(Stack<Character> st){
        Stack<A> finalStack = new Stack<A>();
        Stack<Character> temp = copySt(st);
        char top = temp.pop();
        A current = new A(top,1);
        while (!temp.isEmpty()) {
            //אפשר גם פשוט לכתוב פעולה שמסירה את הכל ואז לעשות פלוס לnum of
            int numOf = numOfCharInSt(temp, top);
            for (int i = 0; i < numOf; i++) {
                current.setNum(current.getNum()+1);
                removeChar(temp, top);
            }
            finalStack.push(current);
            if (!temp.isEmpty()) {
                top = temp.pop();
            }
            current = new A(top, 1);
            if (temp.isEmpty()) {
                finalStack.push(current);
            }
        }
        return finalStack;
    }

    public static Stack<Character> deCompress(Stack<A> st){
        Stack<Character> finalStack = new Stack<Character>();
        Stack<A> temp = new Stack<A>();
        while (!st.isEmpty()) {
            for (int i = 0; i < st.top().getNum(); i++) {
                finalStack.push(st.top().getLet());
            }
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return finalStack;
    }



    //תרגילים שיהיו בשיעורי בית!!

    public static Stack<Integer> ex20pg160(Stack<Couple> st){
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

    //תרגיל 21 ו22

    //

    public static void main(String[] args) {
        Stack<Character> exp = new Stack<Character>();
        exp.push('a');
        exp.push('b');
        exp.push('t');
        exp.push('f');
        exp.push('a');
        exp.push('f');
        System.out.println(deCompress(compress(exp)));
    }

}
