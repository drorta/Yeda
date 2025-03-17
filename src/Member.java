public class Member {

    private String name;
    private boolean isCoal;

    public Member(String name, boolean isCoal) {
        this.name = name;
        this.isCoal = isCoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCoal() {
        return isCoal;
    }

    public void setCoal(boolean coal) {
        isCoal = coal;
    }
}
