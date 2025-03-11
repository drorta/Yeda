public class Ezer {

    public static int sumNodes(Node<Integer> node) {
        int sum = 0;
        while (node != null) {
            sum += node.getValue();
            node = node.getNext();
        }
        return sum;
    }

    public static <T> boolean hasValue(Node<T> node, T value) {
        boolean has = false;
        while (node != null) {
            if (node.getValue() == value) {
                has = true;
            }
            node = node.getNext();
        }
        return has;
    }

    public static <T> int countVal(Node<T> node, T value) {
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

    public static int findMax(Node<Integer> node) {
        int max = node.getValue();
        while (node.getNext() != null) {
            max = Math.max(max, node.getNext().getValue());
            node = node.getNext();
        }
        return max;
    }

    public static <T> Node<T> subNode(Node<T> node, int start, int end) {
        for (int i = 1; i < start - 1; i++) {
            node = node.getNext();
        }
        Node<T> subNode = node.getNext();
        Node<T> temp = subNode;
        for (int i = 1; i < end - 1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return subNode;
    }

    public static Node<Integer> sortNode(Node<Integer> node) {
        if (node == null) {
            return null;
        }
        Node<Integer> sorted = new Node<>(0);
        Node<Integer> p = sorted;
        int firstmin = findMin(node);
        for (int i = 0; i < countVal(node, firstmin); i++) {
            p.setNext(new Node<>(firstmin));
            p = p.getNext();
        }
        node = removeValue(node, firstmin);
        for (int i = 0; i < size(node); i++) {
            int min = findMin(node);
            for (int j = 0; j < countVal(node, min); j++) {
                p.setNext(new Node<>(min));
                p = p.getNext();
            }
            node = removeN(node, min);
        }
        return sorted;
    }

    public static <T> Node<T> setFirst(Node<T> node, T value) {
        Node<T> ret = new Node<>(value);
        ret.setNext(node);
        return ret;
    }

    public static <T> T valueAt(Node<T> node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    public static <T> Node<T> nodeAt(Node<T> node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public static <T> void addLast(Node<T> node, T value){
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setValue(value);
    }

}
