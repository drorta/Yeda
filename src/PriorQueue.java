import classes.Patient;
import utils.Queue;

public class PriorQueue {

    private final Queue<Patient> q;

    public PriorQueue() {
        q = new Queue<>();
    }

    public void priorityInsert(Patient p){
        if (q.isEmpty()) {
            q.insert(p);
        } else if (q.head().getPriority() < p.getPriority()){
            Queue<Patient> t = new Queue<>();
            B2024.spilledOut(q, t);
            q.insert(p);
            B2024.spilledOut(t, q);
        } else {
            boolean hasBeenInserted = false;
            Patient head = q.head();

            q.insert(q.remove());

            while (q.head() != head && !hasBeenInserted) {
                if (q.head().getPriority() < p.getPriority()) {
                    hasBeenInserted = true;
                    Queue<Patient> t = new Queue<>();
                    t.insert(p);
                    while (q.head() != head) {
                        t.insert(q.remove());
                    }
                    B2024.spilledOut(t, q);
                }
                if (!hasBeenInserted) {
                    q.insert(q.remove());
                }
            }
            if (!hasBeenInserted) {
                q.insert(p);
            }
        }
    }

    public void update(int id, int pri){
        Patient to;
        if (q.head().getId() == id){
            to = q.head();
            q.remove();
        } else {
            Patient head = q.head();
            while (q.head().getId() != id) {
                q.insert(q.remove());
            }

        }

    }
}
