public class H16 extends HelpCommands {

    public static Node<Integer> ex54Apg117(Node<Integer> node) {
        if (node.getNext().getValue() % 2 == 1) {
            return node.getNext();
        }
        return ex54Apg117(node.getNext());
    }

    public static Node<Integer> ex54Bpg117(Node<Integer>[] nodes) {
        Node<Integer> ret = new Node<>(0);
        for (Node<Integer> node : nodes) {
            setLast(ret, ex54Apg117(node));
        }
        return ret;
    }

    public static int pg119ex56part2(Node<Student> students) {
        double max = 0;
        int maxCourse = 0;
        Queue<Course> q;
        while (students != null) {
            q = students.getValue().courses;
            q.insert(null);
            while (q.head() != null) {
                if (students.getValue().getScoreAverage() > max) {
                    max = students.getValue().getScoreAverage();
                    maxCourse = students.getValue().courses.head().courseID();
                }
                q.insert(q.remove());
            }
            students = students.getNext();
        }
        return maxCourse;
    }

    public static void main(String[] args) {

    }

}
