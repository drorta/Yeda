public class HiTec {

    private Stack<Worker> workers;

    public HiTec() {
        workers = new Stack<Worker>();
    }

    public void addWorker(Worker worker) {
        workers.push(worker);
    }

    public Worker removeWorker() {
        return workers.pop();
    }

    public boolean areThereWorkers() {
        return !workers.isEmpty();
    }

    public String toString() {
        return workers.toString();
    }

}
