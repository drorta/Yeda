public class Domino {

    private int upsideValue;
    private int downsideValue;

    public Domino(int upsideValue, int downsideValue) {
        this.upsideValue = upsideValue;
        this.downsideValue = downsideValue;
    }

    public boolean has(int value) {
        return upsideValue == value || downsideValue == value;
    }

    public boolean canBeNextTo(Domino other) {
        return this.upsideValue == other.upsideValue
                || this.upsideValue == other.downsideValue
                || this.downsideValue == other.upsideValue
                || this.downsideValue == other.downsideValue;
    }

    public int getUpsideValue() {
        return upsideValue;
    }

    public void setUpsideValue(int upsideValue) {
        this.upsideValue = upsideValue;
    }

    public int getDownsideValue() {
        return downsideValue;
    }

    public void setDownsideValue(int downsideValue) {
        this.downsideValue = downsideValue;
    }
}
