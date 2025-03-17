public class MrtnRace {

    public String country;
    public int yearMrtn;
    private Node<Runner> lstRunners;

    public MrtnRace(String country, int yearMrtn) {
        this.country = country;
        this.yearMrtn = yearMrtn;
        lstRunners = new Node<>(new Runner("-1", -1));
    }

    public Node<Runner> lstRunners(){
        return lstRunners.getNext();
    }

    public void addRunner(Runner runner){
        HelpCommands.setLast(lstRunners, runner);
    }

    public void addRunner(Runner... runners){
        for (Runner runner : runners){
            HelpCommands.setLast(lstRunners, runner);
        }
    }

    public Node<Runner> findRunner(String id){
        Node<Runner> temp = lstRunners;
        while (temp != null) {
            if (temp.getValue().id.equals(id)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return new Node<>(new Runner("-1", -1));
    }

    public void addScoreToRunner(String id, int score){
        findRunner(id).getValue().addItem(new Item(yearMrtn, score));
    }

}
