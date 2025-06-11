/*
Q2. Create a C++ program for a simple banking system. You need to implement a class 
called 
1. BankAccount with the following data members: 
2. accountNumber (int): The account number of the bank account. 
3. accountHolderName (string): The name of the account holder. 
4. balance (double): The current balance in the account. 
The BankAccount class should have the following member functions: 
1. Getter and Setter Methods: 
2. deposit method: A method that allows the user to deposit money into the account. It 
should take an amount as a parameter and update the balance accordingly. 
3. withdraw method: A method that allows the user to withdraw money from the 
account. It should take an amount as a parameter and update the balance. Make sure 
to check if there is sufficient balance before allowing the withdrawal. 
4. displayAccountDetails method: A method that displays the account details ( 
account number, account holder name, and balance). 
Now, create a menu-driven program in the `main` function that allows the user to perform the 
following operations: 
1. Deposit money into an existing account. 
2. Withdraw money from an existing account. 
3. Display the account details. 
4. Exit the program.
*/

#include <iostream>
#include <string>
using namespace std;

class BankAccount {
    private:
        int accountNumber;
        string accountHolderName;
        double balance;
    public:
        // Constructor to initialize account details
        BankAccount(int accNum, string accHolderName, double initialBalance) {
            accountNumber = accNum;
            accountHolderName = accHolderName;
            balance = initialBalance;
        }

        // Getter for account number
        int getAccountNumber() {
            return accountNumber;
        }

        // Getter for account holder name
        string getAccountHolderName() {
            return accountHolderName;
        }

        // Getter for balance
        double getBalance() {
            return balance;
        }

        // Method to deposit money
        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                cout << "Deposited: " << amount << ". New balance: " << balance << endl;
            } else {
                cout << "Invalid deposit amount." << endl;
            }
        }

        // Method to withdraw money
        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                cout << "Withdrawn: " << amount << ". New balance: " << balance << endl;
            } else if (amount > balance) {
                cout << "Insufficient balance." << endl;
            } else {
                cout << "Invalid withdrawal amount." << endl;
            }
        }

        // Method to display account details
        void displayAccountDetails() {
            cout << "\n--- Account Details ---\n";
            cout << "Account Number      : " << accountNumber << endl;
            cout << "Account Holder Name : " << accountHolderName << endl;
            cout << "Current Balance     : " << balance << endl;
        }
};
int main() {
    int accountNumber;
    string accountHolderName;
    double initialBalance;

    cout << "Enter account number: ";
    cin >> accountNumber;
    cin.ignore(); // To clear newline left in the buffer
    cout << "Enter account holder name: ";
    getline(cin, accountHolderName);
    cout << "Enter initial balance: ";
    cin >> initialBalance;

    BankAccount account(accountNumber, accountHolderName, initialBalance);

    int choice;
    do {
        cout << "\n===== Banking Menu =====\n";
        cout << "1. Deposit Money\n";
        cout << "2. Withdraw Money\n";
        cout << "3. Display Account Details\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                double depositAmount;
                cout << "Enter amount to deposit: ";
                cin >> depositAmount;
                account.deposit(depositAmount);
                break;
            }
            case 2: {
                double withdrawAmount;
                cout << "Enter amount to withdraw: ";
                cin >> withdrawAmount;
                account.withdraw(withdrawAmount);
                break;
            }
            case 3:
                account.displayAccountDetails();
                break;
            case 4:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 4);

    return 0;
}
// This code implements a simple banking system with a BankAccount class that allows users to deposit, withdraw, and view account details.
// The program uses a menu-driven approach to interact with the user, allowing them to perform various banking operations.