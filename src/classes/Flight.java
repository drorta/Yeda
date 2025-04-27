package classes;

public class Flight {

    private String name;
    private String destination;
    private String flightCode;
    private Time flightTime;

    public Flight(String name, String destination, String flightCode, Time flightTime) {
        this.name = name;
        this.destination = destination;
        this.flightCode = flightCode;
        this.flightTime = flightTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", flightCode='" + flightCode + '\'' +
                ", flightTime=" + flightTime +
                '}';
    }

}
