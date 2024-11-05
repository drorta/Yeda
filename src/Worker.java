public class Worker {

    private int workerID;
    private int id;

    public Worker(int workerID, int id) {
        this.workerID = workerID;
        this.id = id;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "{ id: " + id + ", jobId: " + workerID + "}";
    }
}
