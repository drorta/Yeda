public class L4 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(); //פעולה בונה מחסנית ריקה

        /*
        פעולות:
        1) בונה
        2) push(int x)
        3) int num = stack.pop()
        4) int y = stack.top() pop but not removing
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

    }

}
