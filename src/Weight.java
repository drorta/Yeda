public class Weight {

    private int kiloGrams;
    private int grams;

    private int totalInGrams;

    public Weight() {
        this.kiloGrams = 0;
        this.grams = 0;
        this.totalInGrams = 0;
    }

    public Weight(int kiloGrams, int grams) {
        this.kiloGrams = kiloGrams;
        this.grams = grams;
        updateTotal();
    }

    public Weight(int totalInGrams) {
        this.totalInGrams = totalInGrams;
        updateByTotal();
    }

    public Weight(int maxInGrams, boolean idk) {
        this.totalInGrams = (int) (Math.random() * maxInGrams);
        updateByTotal();
    }

    public static Weight[] generateArray(int numberOfObjects, int maxGramsForEachWeight) {
        Weight[] arr = new Weight[numberOfObjects];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Weight(maxGramsForEachWeight, true);
        }
        return arr;
    }

    private void updateTotal() {
        this.totalInGrams = (kiloGrams * 1000) + grams;
    }

    private void updateByTotal() {
        this.kiloGrams = totalInGrams / 1000;
        this.grams = totalInGrams - (kiloGrams * 1000);
    }

    public void add(Weight other) {
        this.totalInGrams += other.totalInGrams;
        updateByTotal();
    }

    public boolean less(Weight other) {
        return this.totalInGrams < other.totalInGrams;
    }

    public int getKiloGrams() {
        return kiloGrams;
    }

    public void setKiloGrams(int kiloGrams) {
        this.kiloGrams = kiloGrams;
        updateTotal();
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
        updateTotal();
    }

    public int getTotalInGrams() {
        return totalInGrams;
    }

    public void setTotalInGrams(int totalInGrams) {
        this.totalInGrams = totalInGrams;
        updateByTotal();
    }

    @Override
    public String toString() {
        return "Weight{" +
                "kiloGrams=" + kiloGrams +
                ", grams=" + grams +
                ", totalInGrams=" + totalInGrams +
                '}';
    }
}
