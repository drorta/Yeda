public class H9 extends HelpCommands {

    public static boolean ex3pg89(Node<Integer> node) {
        int prev = Integer.MIN_VALUE;
        while (node != null) {
            if (Math.max(prev, node.getValue()) != node.getValue()) {
                return false;
            }
            prev = node.getValue();
            node = node.getNext();
        }
        return true;
    }

    public static char ex4pg90(Node<Integer> node) {
        int zugi = 0;
        int ezugi = 0;
        while (node != null) {
            if (node.getValue() % 2 == 0) {
                zugi++;
            } else {
                ezugi++;
            }
            node = node.getNext();
        }
        if (zugi == ezugi) {
            return 's';
        }
        return zugi > ezugi ? 'z' : 'e';
    }

    public static void main(String[] args) {
    }

}
