public class AllWeights {

    private Weight[] weights;

    public AllWeights() {}

    public AllWeights(Weight... weights){
        this.weights = weights;
    }

    public Weight sum() {
        Weight sum = new Weight();
        for (Weight weight : weights) {
            sum.add(weight);
        }
        return sum;
    }

    public Weight[] getWeights() {
        return weights;
    }

}
