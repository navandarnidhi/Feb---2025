/*
Q4. You are tasked with creating an Employee Payroll Management System in C++. Your 
program should allow the user to perform the following tasks through a menu-driven 
interface: 
1. Add a new employee: - Create a class Employee with the following private data members: - int empID (Employee ID) - string empName (Employee Name) - double empSalary (Employee Salary) - Include appropriate getter and setter methods for these data members. - Ensure that the Employee ID is unique for each employee. 
2. Calculate the gross salary for an employee: - Create a member function calculateGrossSalary in the Employee class. - The gross salary should be calculated based on the following rules: - If the employee's salary is less than or equal to 5000, add a 10% bonus. - If the employee's salary is greater than 5000 but less than or equal to 10000, add a 
15% bonus. - If the employee's salary is greater than 10000, add a 20% bonus. - Display the gross salary for the chosen employee. 
3. Display the employee details: - Create a member function displayEmployeeDetails in the Employee class to display 
all the details of an employee (ID, Name, Salary, and Gross Salary). 
4. Update employee information: - Allow the user to update the employee's name and salary using setter methods. 
5. Exit the program.
*/

#include <iostream>
#include <string>
using namespace std;
class Employee {
private:
    int empID;
    string empName;
    double empSalary;
    double grossSalary;
public:
    // Constructor
    Employee(int id, string name, double salary) : empID(id), empName(name), empSalary(salary), grossSalary(0.0) {}

    // Setters
    void setEmpName(string name) {
        empName = name;
    }

    void setEmpSalary(double salary) {
        empSalary = salary;
        calculateGrossSalary(); // Recalculate gross salary when salary is updated
    }

    // Getters
    int getEmpID() const {
        return empID;
    }

    string getEmpName() const {
        return empName;
    }

    double getEmpSalary() const {
        return empSalary;
    }

    double getGrossSalary() const {
        return grossSalary;
    }

    // Calculate gross salary based on the rules provided
    void calculateGrossSalary() {
        if (empSalary <= 5000) {
            grossSalary = empSalary * 1.10; // 10% bonus
        } else if (empSalary <= 10000) {
            grossSalary = empSalary * 1.15; // 15% bonus
        } else {
            grossSalary = empSalary * 1.20; // 20% bonus
        }
    }

    // Display employee details
    void displayEmployeeDetails() const {
        cout << "Employee ID: " << empID << endl;
        cout << "Employee Name: " << empName << endl;
        cout << "Employee Salary: $" << empSalary << endl;
        cout << "Gross Salary: $" << grossSalary << endl;
    }
};
int main() {
    int empID;
    string empName;
    double empSalary;

    cout << "Enter Employee ID: ";
    cin >> empID;
    cin.ignore(); // To clear newline left in the buffer
    cout << "Enter Employee Name: ";
    getline(cin, empName);
    cout << "Enter Employee Salary: ";
    cin >> empSalary;

    Employee employee(empID, empName, empSalary);
    employee.calculateGrossSalary();

    int choice;
    do {
        cout << "\n===== Employee Payroll Management Menu =====\n";
        cout << "1. Display Employee Details\n";
        cout << "2. Update Employee Name\n";
        cout << "3. Update Employee Salary\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                employee.displayEmployeeDetails();
                break;
            case 2: {
                string newName;
                cout << "Enter new name: ";
                cin.ignore(); // To clear newline left in the buffer
                getline(cin, newName);
                employee.setEmpName(newName);
                break;
            }
            case 3: {
                double newSalary;
                cout << "Enter new salary: ";
                cin >> newSalary;
                employee.setEmpSalary(newSalary);
                break;
            }
            case 4:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 4);

    return 0;
}
