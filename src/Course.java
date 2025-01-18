public class Course {

    private int courseID;
    private int score;

    public Course(int courseID, int score) {
        this.courseID = courseID;
        this.score = score;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
