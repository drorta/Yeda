public class L14 extends HelpCommands {

    public static Queue<Double> ex4(Queue<Double> scores, Queue<Integer> numOfScoresForEachStudent){
        Queue<Double> scoresTemp = new Queue<>();
        Queue<Integer> numOfScoresForEachStudentTemp = new Queue<>();
        Queue<Double> retAvg = new Queue<>();
        flipQueueRec(scores);
        while (!scores.isEmpty()) {
            int currentSum = 0;
            for (int i = 0; i < numOfScoresForEachStudent.head(); i++) {
                currentSum += scores.head();
                scoresTemp.insert(scores.remove());
            }
            retAvg.insert((double) (currentSum / numOfScoresForEachStudent.head()));
            numOfScoresForEachStudentTemp.insert(numOfScoresForEachStudent.remove());
        }
        while (!scoresTemp.isEmpty()) {
            scores.insert(scoresTemp.remove());
        }
        flipQueueRec(scores);
        while (!numOfScoresForEachStudentTemp.isEmpty()) {
            numOfScoresForEachStudent.insert(numOfScoresForEachStudentTemp.remove());
        }
        return retAvg;
    }

    public static <T> Queue<T> copy(){
        return new Queue<>();
    }

    public static void main(String[] args) {
        Queue<Double> queue = new Queue<>();
        queue.insert(1.1);
        queue.insert(2.2);
        queue.insert(3.3);
        queue.insert(4.4);
        queue.insert(5.5);
        flipQueueRec(queue);
        System.out.println(queue);
    }

}
