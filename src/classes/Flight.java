package classes;

import utils.Node;
import utils.Queue;

public class Flight {

    private String flightNum;
    private Node<Passenger> passengers;
    private int capacity;
    private int km;
    private Queue<Passenger> waiting;

    public Flight(String flightNum, Node<Passenger> passengers, int capacity, int km, Queue<Passenger> waiting) {
        this.flightNum = flightNum;
        this.passengers = passengers;
        this.capacity = capacity;
        this.km = km;
        this.waiting = waiting;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public Node<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Node<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Queue<Passenger> getWaiting() {
        return waiting;
    }

    public void setWaiting(Queue<Passenger> waiting) {
        this.waiting = waiting;
    }
}
