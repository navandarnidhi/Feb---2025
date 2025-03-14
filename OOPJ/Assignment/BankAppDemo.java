import java.util.Scanner;

// Bank Class
class Bank {
    protected double balance;

    // Default Constructor
    public Bank() {
        this(0.0);
    }

    // Parameterized Constructor
    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

// Customer Class
class Customer {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private Bank bank; // Aggregation (Customer has a Bank account)

    // Default Constructor
    public Customer() {
        this(0, "Unknown", 0, "0000000000", new Bank());
    }

    // Constructor with ID and Name
    public Customer(int id, String name) {
        this(id, name, 0, "0000000000", new Bank());
    }

    // Constructor with all parameters
    public Customer(int id, String name, int age, String phoneNumber, Bank bank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.bank = bank;
    }

    // Method to Check Balance
    public void checkBalance() {
        System.out.println("Balance for " + name + ": $" + bank.balance);
    }

    // Getter for Bank instance
    public Bank getBank() {
        return bank;
    }
}

// BankAppDemo (Driver class)
public class BankAppDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Customer and Bank Account
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        // Initial balance for the customer
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        // Creating Bank and Customer objects
        Bank bankAccount = new Bank(initialBalance);
        Customer customer = new Customer(id, name, age, phoneNumber, bankAccount);

        // Menu-driven approach
        int choice;
        do {
            System.out.println("\n----- Bank Menu -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    customer.getBank().deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    customer.getBank().withdraw(withdrawAmount);
                    break;

                case 3:
                    customer.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting Bank System...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
