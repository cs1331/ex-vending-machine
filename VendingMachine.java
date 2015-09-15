public class VendingMachine {

    // This is just a list of all the possible things we could stock in our
    // VendingMachine - quantity is 0 because these aren't actually stocked;
    // it's just a list of possibilities
    private static final Snack[] POSSIBLE_SNACKS = {
        new Snack("Cheetos", 0.85, 0),
        new Snack("Cheez-Its", 0.85, 0),
        new Snack("Funions", 0.85, 0),
        new Snack("Combos", 0.75, 0),
        new Snack("Teddy Grahams", 0.75, 0),
        new Snack("Potato Chips", 0.75, 0),
        new Snack("Fritos", 0.75, 0),
        new Snack("Nacho Doritos", 0.85, 0),
        new Snack("Cool Ranch Doritos", 0.85, 0),
        new Snack("Sun Chips", 0.85, 0),
        new Snack("Snickers", 1.0, 0),
        new Snack("Kit Kats", 1.0, 0),
        new Snack("Butterfinger", 1.0, 0),
        new Snack("Twix", 1.0, 0),
        new Snack("Reese's Peanut Butter Cups", 1.25, 0)
    };

    private static double allCollectedMoneyEver = 0.0;

    private final int NUM_ROWS;
    private final int NUM_COLS;

    private Snack[][] availableItems;
    private double depositedMoney;
    private double collectedMoney;

    public VendingMachine(int rows, int cols, int stockingQuantity) {
        depositedMoney = 0.0;
        collectedMoney = 0.0;
        NUM_ROWS = rows;
        NUM_COLS = cols;
        availableItems = new Snack[NUM_ROWS][NUM_COLS];
        restockSnacks(stockingQuantity);
    }

    public static double getAllCollectedMoneyEver() {
        return allCollectedMoneyEver;
    }

    public void depositMoney(double amount) {
        depositedMoney += amount;
    }

    public double getDepositedMoney() {
        return depositedMoney;
    }

    public double getCollectedMoney() {
        return collectedMoney;
    }

    // return value (null) indicates error
    public String vend(int row, int col) {
        Snack item = availableItems[row][col];

        if (depositedMoney >= item.getCost()
                && item.takeSnack()) {

            depositedMoney -= item.getCost();
            collectedMoney += item.getCost();
            allCollectedMoneyEver += item.getCost();
            return item.getName();

        } else {
            return null;
        }
    }

    public String toString() {
        String output = "";
        for (int row = 0; row < NUM_ROWS; ++row) {
            for (int col = 0; col < NUM_COLS; ++col) {
                output += "Slot " + row + "-" + col + " contains: ";
                output += availableItems[row][col].toString() + "\n";
            }
        }
        return output;
    }

    public double getChange() {
        double change = depositedMoney;
        depositedMoney = 0.0;
        return change;
    }

    private void restockSnacks(int stockingQuantity) {
        for (int row = 0; row < NUM_ROWS; ++row) {
            for (int col = 0; col < NUM_COLS; ++col) {
                int snackIndex = row * NUM_COLS + col;
                Snack snackToStock = POSSIBLE_SNACKS[snackIndex
                                                     % POSSIBLE_SNACKS.length];
                availableItems[row][col] = new Snack(snackToStock.getName(),
                                                     snackToStock.getCost(),
                                                     stockingQuantity);
            }
        }
    }
}
