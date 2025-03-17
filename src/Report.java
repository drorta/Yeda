public record Report(Date dateGiven, int carID, int offenceID, int payment) {

    Report(){
        this(new Date(-1, Month.DECEMBER, -1), -1, -1, -1);
    }

}
