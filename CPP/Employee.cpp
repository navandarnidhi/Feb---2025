#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    double empSalary;
    double grossSalary;
public:
    Employee(int id, string name, double salary) : empID(id), empName(name), empSalary(salary), grossSalary(0.0) {
        calculateGrossSalary();
    }

    void setEmpName(string name) {
        empName = name;
    }

    void setEmpSalary(double salary) {
        empSalary = salary;
        calculateGrossSalary();
    }

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

    void calculateGrossSalary() {
        if (empSalary <= 5000) {
            grossSalary = empSalary * 1.10;
        } else if (empSalary <= 10000) {
            grossSalary = empSalary * 1.15;
        } else {
            grossSalary = empSalary * 1.20;
        }
    }

    void displayEmployeeDetails() const {
        cout << "Employee ID: " << empID << endl;
        cout << "Employee Name: " << empName << endl;
        cout << "Employee Salary: $" << empSalary << endl;
        cout << "Gross Salary: $" << grossSalary << endl;
        cout << "-----------------------------" << endl;
    }
};

int main() {
    vector<Employee> employees;
    int choice;

    do {
        cout << "\n===== Employee Payroll Management Menu =====\n";
        cout << "1. Add New Employee\n";
        cout << "2. Display All Employees\n";
        cout << "3. Update Employee Name\n";
        cout << "4. Update Employee Salary\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int empID;
                string empName;
                double empSalary;
                cout << "Enter Employee ID: ";
                cin >> empID;
                cin.ignore();
                cout << "Enter Employee Name: ";
                getline(cin, empName);
                cout << "Enter Employee Salary: ";
                cin >> empSalary;

                // Check for unique ID
                bool exists = false;
                for (const auto& emp : employees) {
                    if (emp.getEmpID() == empID) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    cout << "Employee ID already exists. Employee not added.\n";
                } else {
                    employees.emplace_back(empID, empName, empSalary);
                    cout << "Employee added successfully.\n";
                }
                break;
            }
            case 2: {
                if (employees.empty()) {
                    cout << "No employees to display.\n";
                } else {
                    cout << "\n--- All Employee Details ---\n";
                    for (const auto& emp : employees) {
                        emp.displayEmployeeDetails();
                    }
                }
                break;
            }
            case 3: {
                int id;
                cout << "Enter Employee ID to update name: ";
                cin >> id;
                cin.ignore();
                bool found = false;
                for (auto& emp : employees) {
                    if (emp.getEmpID() == id) {
                        string newName;
                        cout << "Enter new name: ";
                        getline(cin, newName);
                        emp.setEmpName(newName);
                        cout << "Name updated.\n";
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "Employee not found.\n";
                break;
            }
            case 4: {
                int id;
                cout << "Enter Employee ID to update salary: ";
                cin >> id;
                bool found = false;
                for (auto& emp : employees) {
                    if (emp.getEmpID() == id) {
                        double newSalary;
                        cout << "Enter new salary: ";
                        cin >> newSalary;
                        emp.setEmpSalary(newSalary);
                        cout << "Salary updated.\n";
                        found = true;
                        break;
                    }
                }
                if (!found) cout << "Employee not found.\n";
                break;
            }
            case 5:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 5);

    return 0;
}