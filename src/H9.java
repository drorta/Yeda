public class H9 extends HelpCommands {

    public static void changeOdd(Node<Integer> node){
        while (node != null) {
            if (node.getValue() % 2 == 1) {
                node.setValue(node.getValue()*2);
            }
            node = node.getNext();
        }
    }

    public static boolean hasValue(Node<Integer> node, int value) {
        boolean has = false;
        while (node != null) {
            if (node.getValue() == value) {
                has = true;
            }
            node = node.getNext();
        }
        return has;
    }

    public static int countVal(Node<Integer> node, int value) {
        int count = 0;
        while (node != null) {
            if (node.getValue() == value) {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    public static int findMin(Node<Integer> node) {
        int min = node.getValue();
        while (node != null) {
            min = Math.min(min, node.getNext().getValue());
            node = node.getNext();
        }
        return min;
    }

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
