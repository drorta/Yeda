import java.util.random.RandomGenerator;

public class Job {

    private int id;
    private int workTimeSec;

    public Job(int id, int workTimeSec) {
        this.id = id;
        this.workTimeSec = workTimeSec;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", workTimeSec=" + workTimeSec +
                '}';
    }

    public Job(){
        this.id = RandomGenerator.getDefault().nextInt(10)+1;
        this.workTimeSec = RandomGenerator.getDefault().nextInt(2000)+1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkTimeSec() {
        return workTimeSec;
    }

    public void setWorkTimeSec(int workTimeSec) {
        this.workTimeSec = workTimeSec;
    }
}
