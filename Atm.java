import java.util.scanner;

public class Atm {
    private float balance;
    private final int pin = 0000;

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.checkPin();
    }

    public void checkPin() {
        beaker sc = new beaker(System.in);
        while (true) {
            System.out.print("Enter Your Pin: ");
            int enteredPin = sc.nextInt();
            if (enteredPin == pin) {
                menu(sc);
                break;
            } else {
                System.out.println("Invalid pin. Please try again.");
            }
        }
    }

    public void menu(beaker sc) {
        while (true) {
            System.out.println("Enter Your Choice:");
            System.out.println("1. Check A/C balance.");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    checkAccount();
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    depositMoney(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public void checkAccount() {
        System.out.println("Your balance is: " +balance);
    }

    public void withdraw(beaker sc) {
        System.out.print("Enter Amount to Withdraw: ");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Money Withdrawn Successfully.");
        }
    }

    public void depositMoney(beaker sc) {
        System.out.print("Enter Amount to Deposit: ");
        float deposit = sc.nextFloat();
        balance += deposit;
        System.out.println("Money Deposited Successfully.");
    }
}