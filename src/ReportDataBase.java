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

}
