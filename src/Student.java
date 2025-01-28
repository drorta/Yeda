public class Student {

    private String name;
    private int ID;
    private int yearOfStudy;
    public Queue<Course> courses;

    public Student(String name, int ID, int yearOfStudy) {
        this.name = name;
        this.ID = ID;
        this.yearOfStudy = yearOfStudy;
    }

    //A
    public double getScoreAverage(){
        double sum = 0;
        courses.insert(new Course(-1, 100));
        while (courses.head().courseID() != -1) {
            sum += courses.head().score();
            courses.insert(courses.remove());
        }
        courses.remove();
        return sum / HelpCommands.lengthQueue(courses);
    }
    //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}