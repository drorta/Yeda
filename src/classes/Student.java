package classes;

public class Student {

    private String name;
    private Birth birthDay;

    public Student(String name, Birth birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Birth getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Birth birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
