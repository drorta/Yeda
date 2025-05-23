import classes.Flight;
import classes.Passenger;

public class L29 {

    public static void main(String[] args) {

    }

    public static void makePermPass(Flight[] flights, Passenger nonPermPass){
        boolean found = false;
        for (Flight flight : flights){
            if (nonPermPass.getKm() + flight.getKm() >= 20) {
                found = true;

            }
        }
    }

}
