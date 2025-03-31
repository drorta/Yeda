public class L13 extends HelpCommands {

    public static int ex1(Node<Integer> fstCircle){
        Node<Integer> p = fstCircle;
        int len = 1;
        while (p.getNext() != fstCircle) {
            len++;
            p = p.getNext();
        }
        return len;
    }

    public static int ex1Onil(Node<Integer> fstCircle){
        Node<Integer> next2 = fstCircle.getNext().getNext();
        fstCircle.setNext(null);
        int len = lenNodes(fstCircle);
        return len;
    }

    public static void main(String[] args) {
        Node<Integer> exp = new Node<>(5);
        Node<Integer> p = exp;
        p.setNext(new Node<>(3));
        p = p.getNext();
        p.setNext(new Node<>(2));
        p = p.getNext();
        p.setNext(new Node<>(3));
        p = p.getNext();
        p.setNext(new Node<>(34));
        p = p.getNext();
        p.setNext(exp);
        System.out.println(ex1Onil(exp));
    }

}
