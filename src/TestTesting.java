public class TestTesting {

    public static boolean ex2(int num){
        if(num == 0){
            return true;
        }
        if(num % 10 != 0 && num % 10 != 1){
            return false;
        }
        return ex2(num/10);
    }

    public static int ex3A(Stack<Integer> st){
        Stack<Integer> temp = new Stack<Integer>();
        int last = st.top();
        while(!st.isEmpty()){
            last = st.pop();
            if (!st.isEmpty()){
                temp.push(last);
            }
        }
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        return last;
    }

    public static Stack<Integer> ex3C(Stack<Integer> st){
        Stack<Integer> ret = new Stack<Integer>();
        while(!st.isEmpty()){
            int first = st.pop();
            if(!st.isEmpty()){
                int last = ex3A(st);
                ret.push(first * last);
            }
            else {
                ret.push(first * first);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Stack<Integer> stack =  new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        System.out.println(stack);
        System.out.println(ex3A(stack));
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        System.out.println(ex3C(stack));
    }

}
