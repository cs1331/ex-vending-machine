public class UseVendingMachine {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(3, 4, 10);
        System.out.println("\nmachine:");
        System.out.println(machine);
        payForSnack(machine, 2, 3);

        VendingMachine otherMachine = new VendingMachine(4, 2, 5);
        System.out.println("\notherMachine:");
        System.out.println(otherMachine);
        payForSnack(otherMachine, 3, 0);

        System.out.println("All vending machines have collected a total of $"
                + VendingMachine.getAllCollectedMoneyEver() + " so far.");
    }

    private static void payForSnack(VendingMachine machine, int row, int col) {
        double deposit = 1.00;
        machine.depositMoney(deposit);
        System.out.println("Deposited $" + deposit);
        String snackName = machine.vend(row, col); // Twix

        System.out.println("You bought " + snackName);
        System.out.println("$" + machine.getDepositedMoney()
                + " remains in the machine");
    }

    private static void stealSnack(VendingMachine machine, int row, int col) {
        String snackName = machine.vend(row, col); // Twix

        System.out.println("You stole " + snackName);
        System.out.println("$" + machine.getDepositedMoney()
                + " remains in the machine");
    }
}
