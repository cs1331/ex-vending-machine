public class Snack {

    private String name;
    private double cost;
    private int numRemaining;

    public Snack(String name, double cost, int quantity) {
        numRemaining = quantity;
        this.cost = cost;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getNumRemaining() {
        return numRemaining;
    }

    // Takes a snack, if any are available, and returns whether a snack was
    // successfully take (true) or not (false)
    public boolean takeSnack() {
        if (numRemaining > 0) {
            --numRemaining;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return numRemaining + " " + name + " costing $" + cost + " each.";
    }
}
