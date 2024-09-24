import java.util.Random;

public class L4 {

    public static Stack<Integer> buildStack(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            stack.push((int) (Math.random() * 41) + 10);
        }
        return stack;
    }

    //בהירת מחדל: המחסנית חוזרת למצבה המקורי בכל פעולה!!
    public static int sumStack(Stack<Integer> st) {
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }

    //חוזר במצב מקורי
    public static int sumStackSaveStack(Stack<Integer> st) {
        int sum = 0;
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            sum += st.top();
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return sum;
    }

    //מחזירה את כמות הפעמים שהערך איקס נמצא במחסנית
    public static int valRepSt(Stack<Integer> st, int x) {
        int sum = 0;
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            if (st.top() == x) {
                sum++;
            }
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return sum;
    }

    //מחזירה את הערך המקסימלי במחסנית
    public static int maxValSt(Stack<Integer> st) {
        int max;
        while ()
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>(); //פעולה בונה מחסנית ריקה

        /*
        פעולות:
        1) Stack<Integer> stack = new Stack<Integer>() בונה מחסנית ריקה
        2) push(T x) הוספה
        3) T x = stack.pop()
        4) T y = stack.top() pop but not removing
        5) boolean isEmpty()
        6) String toString()
         */

        stack.push(5);
        System.out.println(stack.toString());
        //System.out.println(stack);

        stack.push(7);
        System.out.println(stack.toString());

        stack.push(8);
        System.out.println(stack.toString());

        stack.push(3);
        System.out.println(stack.toString());

        int num = stack.pop(); //מוציא איבר עליון רק אם לא ריק
        System.out.println(num);
        System.out.println(stack.toString());

        int moreNum = stack.pop();
        System.out.println(moreNum);
        System.out.println(stack.toString());

        stack.push(0);
        System.out.println(stack.toString());

        stack.pop(); //מוציא את 0
        System.out.println(stack.toString());

        int y = stack.top();
        System.out.println(y);

        /*
        if (!stack.isEmpty()) {
            stack.pop();
        }
         */

        Stack<Integer> stack1 = buildStack((int) (Math.random() * 1000) + 20);
        System.out.println(stack);
        System.out.println(sumStackSaveStack(stack));
        System.out.println(stack);

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

    }

}
