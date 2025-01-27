public class L16 extends HelpCommands {

    public static void main(String[] args) {
//        OrderedList list = new OrderedList();
//        list.insertNum(1);
//        list.insertNum(1);
//        list.insertNum(1);
//        list.insertNum(3);
//        list.insertNum(2);
//        printNodes(list.lst);
        System.out.println(1%3);

        Node<Integer> node = buildNodes(1,2,3,4,5,6,7);
        int count = 0;
        for (int i = 1; i < 10000000; i+=2) {
            count += valueAt(node, i);
        }
    }

}
