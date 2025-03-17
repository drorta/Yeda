import java.util.Arrays;

public class Committee {

    private String name;
    private Member[] members;
    private int count;

    public Committee(String name, Member[] members, int count) {
        this.name = name;
        this.members = members;
        this.count = count;
    }

    public Committee(Committee other){
        this.name = other.name;
        this.members = other.members;
        this.count = other.count;
    }

    public int total(boolean belong){
        int total = 0;
        if (belong) {
            for (Member member : members){
                if (member.isCoal()) {
                    total++;
                }
            }
        } else {
            for (Member member : members){
                if (!member.isCoal()) {
                    total++;
                }
            }
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
