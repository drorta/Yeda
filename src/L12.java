import java.util.Objects;
import java.util.Scanner;

public class L12 extends HelpCommands {

    public static int ex15A(Node<Character> node, char c){
        return countVal(node, c);
    }

    public static void ex15B(){
        Scanner reader = new Scanner(System.in);
        Node<Character> node = new Node<>(reader.next().charAt(0));
        Node<Character> p = node;
        String current = reader.next();
        while (!Objects.equals(current, "999")) {
            p.setNext(new Node<>(current.charAt(0)));
            p = p.getNext();
            current = reader.next();
        }
        for (int i = 65; i < 91; i++) {
            System.out.println((char)i + ": " + countVal(node, ((char) i)));
        }
        for (int i = 97; i < 123; i++) {
            System.out.println((char)i + ": " + countVal(node, ((char) i)));
        }
    }
    
    public static Node<Integer> ex17(Node<Character> node){
        int first = 0;
        int second = 0;
        int len = lenNodesChar(node);
        Node<Integer> ret = new Node<>(0);
        Node<Integer> p = ret;
        for (int i = 1; i < len+1; i++) {
            if (i % 3 == 2) {
                first = Integer.valueOf(node.getValue());
            } else if (i % 3 == 0) {
                second = node.getValue();
            } else {
                p.setNext(
                        switch (node.getValue()){
                            case '+' -> new Node<>(first + second);
                            case '-' -> new Node<>(first - second);
                            case '*' -> new Node<>(first * second);
                            case '/' -> new Node<>(first / second);
                            default -> new Node<>(Integer.MAX_VALUE);
                        }
                );
            }
            p = p.getNext();
        }
        return ret;
    }

    public static Node<String> ex19(){
        Scanner reader = new Scanner(System.in);
        String current = reader.next();
        while (!reader.next().equals("999")) {

        }
    }

    public static void main(String[] args) {
        ex15B();
    }

}
