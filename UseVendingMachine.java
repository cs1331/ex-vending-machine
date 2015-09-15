public class UseVendingMachine {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        payForSnack(machine, 2, 3);
    }

    private static void payForSnack(VendingMachine machine, int row, int col) {
        machine.depositMoney(1.00);
        String snackName = machine.vend(row, col); // Twix

        System.out.println("You bought " + snackName);
        System.out.println("$" + machine.getDepositedMoney()
                + " remains in the machine");
    }

    private static void stealSnack(VendingMachine machine, int row, int col) {
        Snack snack = machine.availableItems[row][col];
        System.out.println(snack);

        System.out.println(snack.getName());
        String snackName = machine.vend(row, col); // Twix

        System.out.println("You stole " + snackName);
        System.out.println("$" + machine.getDepositedMoney()
                + " remains in the machine");
    }
}
