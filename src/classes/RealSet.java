package classes;

import utils.HelpCommands;
import utils.Node;

public class RealSet {

    private Node<Double> node;

    public RealSet() {
    }

    public int size(){
        return HelpCommands.lenNodes(node);
    }

    public void insert(double num){
        if (node == null) {
            node = new Node<>(num);
        } else {
            HelpCommands.setLast(node, num);
        }
    }

    public void insert(double... numbers){
        for (double num : numbers){
            HelpCommands.setLast(node, num);
        }
    }

    public void remove(double num){
        node = HelpCommands.removeValue(node, num);
    }

    public double findBiggest(){
        return HelpCommands.findMax(node, true);
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
