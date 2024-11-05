import java.util.Random;
import java.util.random.RandomGenerator;

public class Domino {

    private int topSide;
    private int bottomSide;

    public Domino(int topSide, int bottomSide) {
        this.topSide = topSide;
        this.bottomSide = bottomSide;
    }

    public Domino(){
        this.topSide = RandomGenerator.getDefault().nextInt(6)+1;
        this.bottomSide = RandomGenerator.getDefault().nextInt(6)+1;
    }

    public int getTopSide() {
        return topSide;
    }

    public void setTopSide(int topSide) {
        this.topSide = topSide;
    }

    public int getBottomSide() {
        return bottomSide;
    }

    public void setBottomSide(int bottomSide) {
        this.bottomSide = bottomSide;
    }

    public boolean isSame(Domino other){
        return this.topSide == other.topSide && this.bottomSide == other.bottomSide;
    }

    @Override
    public String toString() {
        return "{" +
                topSide +
                "|" + bottomSide +
                '}';
    }
}
