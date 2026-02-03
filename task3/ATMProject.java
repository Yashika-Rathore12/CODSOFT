import java.util.Scanner;
class Account {
    private double balance;
    public Account(double initialBalance ) {
        balance = initialBalance;
    }
    public void depositAmount(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("money deposited");
        }
        else {
            System.out.println("Invalid amount");
        }
    }
    public void withdrawAmount(double amount) {
        if (amount <= 0) {
            System.out.println("invalid amount");
        }
        else if(amount > balance) {
            System.out.println("Insufficient balance ");
        }
        else {
            balance = balance - amount;
            System.out.println("Collect Your Money");
        }
    }
    public double showBalance() {
        return balance;
    }
}
class SimpleATM {
    private Account userAccount;
    public SimpleATM(Account account)
    {
        userAccount = account;
    }
    public void displayOptions() {
        System.out.println("\n     ATM MENU         ");
        System.out.println("1. Withdrawal money");
        System.out.println("2. Deposit money");
        System.out.println("3. check Balance");
        System.out.println("4. exit");
    }
    public void runATM() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            displayOptions();
            System.out.println("Choose an option");
            option = sc.nextInt();
            if (option == 1) {
                System.out.println("enter withdrawal amount");
                double amt = sc.nextDouble();
                userAccount.withdrawAmount(amt);
            }
            else if(option == 2){
                System.out.println("enter deposit amount");
                double amt = sc.nextDouble();
                userAccount.depositAmount(amt);
            }
            else if(option == 3){
                System.out.println("CURRENT BALANCE " + userAccount.showBalance());
            }
            else if(option == 4){
                System.out.println("THANK YOU FOR USING THE ATM SYSTEM !!");
            }
            else {
                System.out.println("INVALID OPTION !!");
            }
        }while(option != 4);
        sc.close();

    }
}
public class ATMProject {
    public static void main(String args[]) {
        Account myAccount = new Account(5000);
        SimpleATM atm = new SimpleATM(myAccount);
        atm.runATM();
    }
}