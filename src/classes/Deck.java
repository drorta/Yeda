package classes;

import utils.HelpCommands;
import utils.Node;

public class Deck {

    private final Node<Card> deck1;
    private final Node<Card> deck2;
    private final Node<Card> deck3;
    private final Node<Card> deck4;

    private final Node<Card> deck5;

    public Deck() {
        deck1 = new Node<>(new Card(-1, -1));
        deck2 = new Node<>(new Card(-1, -1));
        deck3 = new Node<>(new Card(-1, -1));
        deck4 = new Node<>(new Card(-1, -1));

        deck5 = new Node<>(new Card(-1, -1));
    }

    private Node<Card> getDeckByShape(int shape){
        return switch (shape){
            case 1 -> deck1;
            case 2 -> deck2;
            case 3 -> deck3;
            case 4 -> deck4;
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        };
    }

    public void insert(Card card){
        HelpCommands.setLast(getDeckByShape(card.shape()), card);
    }

    public boolean move(int shape){
        if (HelpCommands.lenNodes(getDeckByShape(shape)) < 2) {
            return false;
        }
        HelpCommands.setLast(deck5, HelpCommands.getLast(getDeckByShape(shape)));
        return true;
    }

    public int sum(){
        int sum = 0;
        Node<Card> p = deck5;
        while (p != null) {
            sum += p.getValue().value();
            p = p.getNext();
        }
        return sum;
    }

}
