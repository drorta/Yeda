package classes;

import utils.Queue;

public class WaitingList {

    private Queue<Persoon> green;
    private Queue<Persoon> red;

    public WaitingList(){
        green = new Queue<>();
        red = new Queue<>();
    }

    public void insert(Persoon persoon, int k){
        if (k == 1) {
            green.insert(persoon);
        } else if (k == 2) {
            red.insert(persoon);
        }
    }

    public Persoon remove(){
        if (green.isEmpty()) {
            return red.remove();
        }
        return green.remove();
    }

    public boolean isEmpty(){
        return green.isEmpty() && red.isEmpty();
    }

    @Override
    public String toString(){
        return "Green queue: " + green + "\n" + "Red queue: " + red;
    }

}
