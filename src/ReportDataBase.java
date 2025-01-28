public class ReportDataBase {

    private Node<Report> reports;

    public ReportDataBase(){
        this.reports = new Node<>(new Report());
    }

    public void moveReportToLawyer(Date date){
        /*
        לא כתבו אם לכתוב את זה או לא... אני מניח שלא צריך
         */
    }

    public int carPaymentTotal(int carID){
        Node<Report> temp = reports;
        int sum = 0;
        while (temp != null) {
            if (temp.getValue().carID() == carID) {
                sum += temp.getValue().payment();
            }
        }
        return sum;
    }

    /**
     *
     * במקום רשימה אפשר להשתמש במערך
     * @return pg118ex55C
     */
    public Node<Integer> findDriver(int offenceID){
        Node<Integer> ret = new Node<>(-1);
        Node<Integer> p = ret;
        Node<Report> temp = reports;
        while (temp != null){
            if (temp.getValue().offenceID() == offenceID){
                p.setNext(new Node<>(temp.getValue().carID()));
                p = p.getNext();
            }
            temp = temp.getNext();
        }
        return ret.getNext();
    }

}
