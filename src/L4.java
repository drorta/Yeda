public class L4 {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>(); //פעולה בונה מחסנית ריקה

        st.push(5);
        System.out.println(st.toString());

        st.push(7);
        System.out.println(st.toString());

        st.push(8);
        System.out.println(st.toString());

        st.push(3);
        System.out.println(st.toString());

        int num = st.pop(); //מוציא איבר עליון רק אם לא ריק
        System.out.println(st.toString());

        int moreNum = st.pop();
        System.out.println(st.toString());

        st.push(0);
        System.out.println(st.toString());

    }

}
