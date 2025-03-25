package classes;

import utils.HelpCommands;
import utils.Node;

public class Race {

    private Node<Competitor> competitors;

    public Race(){}

    public void add(Competitor competitor){
        if (competitors == null) {
            competitors = new Node<>(competitor);
        } else {
            if (competitor.isBetter(competitors.getValue())) {
                competitors = new Node<>(competitor, competitors);
            }
            Node<Competitor> temp = competitors;
            boolean hasBeenPlaced = false;
            while (temp.getNext() != null) {
                if (competitor.isBetter(temp.getNext().getValue())) {
                    temp.setNext(new Node<>(competitor, temp.getNext()));
                    hasBeenPlaced = true;
                }
                temp = temp.getNext();
            }
            if (!hasBeenPlaced) {
                temp.setNext(new Node<>(competitor));
            }
        }
    }

    public Competitor rank(int rank){
        rank -= 1;
        return HelpCommands.valueAt(competitors, rank);
    }

}
