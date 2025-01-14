public class OrderedList {

    public Node<NumCount> lst;

    public OrderedList() {
    }

    public void insertNum(int x) {
        if (lst == null) {
            lst = new Node<>(new NumCount(x, 1));
        }
        else if (lst.getValue().getNum() > x) {
            Node<NumCount> temp = lst.getNext();
            NumCount tempNumCount = lst.getValue();
            lst.setValue(new NumCount(x, 1));
            lst.setNext(new Node<>(tempNumCount));
            lst.getNext().setNext(temp);
        } else {
            Node<NumCount> p = lst;
            while (p != null) {
                if (p.getValue().getNum() == x) {
                    p.getValue().setCount(p.getValue().getCount()+1);
                }
                else if (p.getValue().getNum() > x) {
                    if (p.getNext() == null) {
                        NumCount temp = new NumCount(p.getValue());
                        p.setValue(new NumCount(x, 1));
                        p.setNext(new Node<>(temp));
                        p = p.getNext();
                    }
                    else {
                        Node<NumCount> temp = p.getNext();
                        p.setNext(new Node<>(new NumCount(x, 1)));
                        p.getNext().setNext(temp);
                    }
                } else if (p.getNext() == null) {
                    p.setNext(new Node<>(new NumCount(x, 1)));
                    p = p.getNext();
                }
                p = p.getNext();
            }
        }
    }

    public int valueN(int n){
        return HelpCommands.valueAt(lst, n-1).getNum();
    }

    @Override
    public String toString() {
        return "OrderedList{" +
                "lst=" + lst +
                '}';
    }
}
