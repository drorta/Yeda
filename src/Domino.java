public class Domino {

    private int x;
    private int y;

    @Override
    public String toString() {
        return "Domino{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Domino(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
