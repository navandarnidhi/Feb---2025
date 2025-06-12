/*
Q3. Imagine you are tasked with creating a program to simulate a toll booth. The toll booth 
keeps 
track of the number of vehicles that have passed through it and the total amount of money 
collected. You need to implement a class TollBooth with appropriate data members and 
member functions to accomplish this. 
Here are the details for the TollBooth class: 
1. Data Members: - totalVehicles: An integer to keep track of the total number of vehicles that have 
passed through the toll booth. - totalRevenue: A double to store the total revenue collected from tolls. 
2. Member Functions: 
1. void reset(): Resets both the totalVehicles and totalRevenue to zero. 
2. void vehiclePayingToll(int vehicleType, double tollAmount): Accepts an integer 
vehicleType and a double tollAmount. The vehicleType represents the type of car (1 
for standard car, 2 for truck, 3 for bus). The function should increment totalVehicles 
by 1 and add tollAmount to totalRevenue based on the car type. 
3. int getTotalVehicles() : A getter method that returns the total number of vehicles 
passed through the booth. 
4. double getTotalRevenue() : A getter method that returns the total revenue collected. 
3. Menu-Driven Program: 
Write a menu-driven program in main() that allows the user to interact with the TollBooth 
class: - Display a menu with the following options: 
1. Add a standard car and collect toll 
2. Add a truck and collect toll 
3. Add a bus and collect toll 
4. Display total cars passed 
5. Display total revenue collected 
6. Reset booth statistics 
7. Exit - Implement the logic for each menu option using appropriate member functions of the 
TollBooth class. - Continue displaying the menu until the user chooses to exit. - Define a fixed toll amount for each type of car (e.g., $2 for standard cars, $5 for trucks, $10 
for buses). 
*/


#include <iostream>
#include <vector>
using namespace std;

struct Transaction {
    int vehicleType;
    int count;
    double tollAmount;
};

class TollBooth {
private:
    int totalVehicles;
    double totalRevenue;
    vector<Transaction> transactions; // Store all transactions

public:
    TollBooth() {
        totalVehicles = 0;
        totalRevenue = 0.0;
    }

    void reset() {
        totalVehicles = 0;
        totalRevenue = 0.0;
        transactions.clear();
        cout << "Booth statistics have been reset.\n";
    }

    void vehiclePayingToll(int vehicleType, int count, double tollAmount) {
        totalVehicles += count;
        totalRevenue += tollAmount * count;
        transactions.push_back({vehicleType, count, tollAmount});

        string typeName;
        switch(vehicleType) {
            case 1: typeName = "Standard Car"; break;
            case 2: typeName = "Truck"; break;
            case 3: typeName = "Bus"; break;
            default: typeName = "Unknown Vehicle"; break;
        }

        cout << count << " " << typeName << "(s) processed. Total Toll: $" << tollAmount * count << "\n";
    }

    int getTotalVehicles() const {
        return totalVehicles;
    }

    double getTotalRevenue() const {
        return totalRevenue;
    }

    void printAllTransactions() const {
        if (transactions.empty()) {
            cout << "No transactions to display.\n";
            return;
        }
        cout << "\n--- All TollBooth Transactions ---\n";
        for (const auto& t : transactions) {
            string typeName;
            switch(t.vehicleType) {
                case 1: typeName = "Standard Car"; break;
                case 2: typeName = "Truck"; break;
                case 3: typeName = "Bus"; break;
                default: typeName = "Unknown Vehicle"; break;
            }
            cout << "Vehicle: " << typeName
                 << ", Count: " << t.count
                 << ", Toll per Vehicle: $" << t.tollAmount
                 << ", Total Toll: $" << t.tollAmount * t.count << endl;
        }
    }
};

int main() {
    TollBooth booth;
    int choice;

    const double CAR_TOLL = 2.0;
    const double TRUCK_TOLL = 5.0;
    const double BUS_TOLL = 10.0;

    do {
        cout << "\n=== Toll Booth Menu ===\n";
        cout << "1. Add standard car(s) and collect toll ($2 each)\n";
        cout << "2. Add truck(s) and collect toll ($5 each)\n";
        cout << "3. Add bus(es) and collect toll ($10 each)\n";
        cout << "4. Display total vehicles passed\n";
        cout << "5. Display total revenue collected\n";
        cout << "6. Reset booth statistics\n";
        cout << "7. Print all transactions\n";
        cout << "8. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        int count;
        switch(choice) {
            case 1:
                cout << "Enter number of standard cars: ";
                cin >> count;
                booth.vehiclePayingToll(1, count, CAR_TOLL);
                break;
            case 2:
                cout << "Enter number of trucks: ";
                cin >> count;
                booth.vehiclePayingToll(2, count, TRUCK_TOLL);
                break;
            case 3:
                cout << "Enter number of buses: ";
                cin >> count;
                booth.vehiclePayingToll(3, count, BUS_TOLL);
                break;
            case 4:
                cout << "Total Vehicles Passed: " << booth.getTotalVehicles() << endl;
                break;
            case 5:
                cout << "Total Revenue Collected: $" << booth.getTotalRevenue() << endl;
                break;
            case 6:
                booth.reset();
                break;
            case 7:
                booth.printAllTransactions();
                break;
            case 8:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 8);

    return 0;
}