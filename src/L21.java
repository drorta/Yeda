public class L21 extends HelpCommands {

    public static boolean is3ConsecutiveNumbers(int n1, int n2, int n3) {
        return (n2 - n1 == 1) && (n3 - n2 == 1);
    }

    public static boolean hasParticipatedIn3ConsecutiveYears(Runner runner) {
        Node<Item> runnerItems = runner.lstItems();
        while (runnerItems.getNext().getNext() != null) {
            if (is3ConsecutiveNumbers(
                    runnerItems.getValue().year(),
                    runnerItems.getNext().getValue().year(),
                    runnerItems.getNext().getNext().getValue().year()
            )) {
                return true;
            }
            runnerItems = runnerItems.getNext();
        }
        return false;
    }

    public static int numberOfRunnersParticipatedIn3ConsecutiveYears(MrtnRace mrtnRace) {
        Node<Runner> runners = mrtnRace.lstRunners();
        int numberOfRunnersParticipatedIn3ConsecutiveYears = 0;
        while (runners != null) {
            if (hasParticipatedIn3ConsecutiveYears(runners.getValue())) {
                numberOfRunnersParticipatedIn3ConsecutiveYears++;
            }
            runners = runners.getNext();
        }
        return numberOfRunnersParticipatedIn3ConsecutiveYears;
    }

    public static Node<Integer> allStations(BusStation[] busStations, int[] autobusim){
        Node<Integer> allStations = new Node<>(-1);
        for (int autobus : autobusim){
            boolean wasStopping = true;
            boolean isStopping = true;
            for (BusStation busStation : busStations){
                if (wasStopping && busStation.isStopping(autobus)) {
                    isStopping = true;
                } else {
                    wasStopping = false;
                    isStopping = false;
                }
            }
            if (wasStopping && isStopping) {
                HelpCommands.setLast(allStations, autobus);
            }
        }
        return allStations.getNext();
    }

    public static void main(String[] args) {
//        Runner r1 = new Runner("1", 1);
//        Runner r2 = new Runner("2", 2);
//        Runner r3 = new Runner("3", 3);
//
//        r1.addItems(new Item(1, 2), new Item(2, 2), new Item(3, 3));
//        r2.addItems(new Item(1, 2), new Item(5, 2), new Item(3, 3));
//
//        MrtnRace mrtnRace = new MrtnRace("Israel", 1);
//        mrtnRace.addRunner(r1, r2);
//
//        mrtnRace.addScoreToRunner("1", 100);
//        printNodes(r1.lstItems());
//
//        System.out.println(numberOfRunnersParticipatedIn3ConsecutiveYears(mrtnRace));

        BusStation b1 = new BusStation(1);
        b1.setArr(new int[]{49, 47});

        BusStation b2 = new BusStation(2);
        b2.setArr(new int[]{49, 47});

        BusStation b3 = new BusStation(3);
        b3.setArr(new int[]{49, 47});

        BusStation[] busStations = new BusStation[]{b1, b2, b3};
        int[] autobusim = new int[]{24, 47, 49, 42};

        printNodes(allStations(busStations, autobusim));

    }

}
