public class VendingMachine {

    public Snack[][] availableItems;
    public double depositedMoney;

    public VendingMachine() {
        depositedMoney = 0.0;
        availableItems = new Snack[3][5];
        restockSnacks();
    }

    public void depositMoney(double amount) {
        depositedMoney += amount;
    }

    public double getDepositedMoney() {
        return depositedMoney;
    }

    public String vend(int row, int col) {
        // TODO
        return null;
    }

    private void restockSnacks() {
        availableItems[0][0] = new Snack("Cheetos", 0.85, 10);
        availableItems[0][1] = new Snack("Cheez-Its", 0.85, 10);
        availableItems[0][2] = new Snack("Funions", 0.85, 10);
        availableItems[0][3] = new Snack("Combos", 0.75, 10);
        availableItems[0][4] = new Snack("Teddy Grahams", 0.75, 10);
        availableItems[1][0] = new Snack("Potato Chips", 0.75, 10);
        availableItems[1][1] = new Snack("Fritos", 0.75, 10);
        availableItems[1][2] = new Snack("Nacho Doritos", 0.85, 10);
        availableItems[1][3] = new Snack("Cool Ranch Doritos", 0.85, 10);
        availableItems[1][4] = new Snack("Sun Chips", 0.85, 10);
        availableItems[2][0] = new Snack("Snickers", 1.0, 10);
        availableItems[2][1] = new Snack("Kit Kats", 1.0, 10);
        availableItems[2][2] = new Snack("Butterfinger", 1.0, 10);
        availableItems[2][3] = new Snack("Twix", 1.0, 10);
        availableItems[2][4] = new Snack("Reese's Peanut Butter Cups",
                                         1.25,
                                         10);
    }
}
