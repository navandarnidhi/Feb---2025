#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Student {
private:
    string name;
    int rollNumber;
    float marks;
    char grade;

public:
    // Setters
    void setName(string n) {
        name = n;
    }

    void setRollNumber(int r) {
        rollNumber = r;
    }

    void setMarks(float m) {
        marks = m;
    }

    void setGrade(char g) {
        grade = g;
    }

    // Getters
    string getName() {
        return name;
    }

    int getRollNumber() {
        return rollNumber;
    }

    float getMarks() {
        return marks;
    }

    char getGrade() {
        return grade;
    }

    // Calculate grade based on marks
    void calculateGrade() {
        if (marks >= 90 && marks <= 100)
            grade = 'A';
        else if (marks >= 80 && marks < 90)
            grade = 'B';
        else if (marks >= 70 && marks < 80)
            grade = 'C';
        else if (marks >= 60 && marks < 70)
            grade = 'D';
        else
            grade = 'F';

        cout << "Grade calculated successfully.\n";
    }

    // Display student details
    void displayInfo() const {
        cout << "\n--- Student Information ---\n";
        cout << "Name       : " << name << endl;
        cout << "Roll Number: " << rollNumber << endl;
        cout << "Marks      : " << marks << endl;
        cout << "Grade      : " << grade << endl;
    }
};

int main() {
    vector<Student> students;
    int choice;

    do {
        cout << "\n===== Student Menu =====\n";
        cout << "1. Accept Information\n";
        cout << "2. Display Information\n";
        cout << "3. Calculate Grade\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore(); // To clear newline left in the buffer

        switch (choice) {
        case 1: {
            Student s;
            string name;
            int roll;
            float marks;

            cout << "Enter name: ";
            getline(cin, name);
            cout << "Enter roll number: ";
            cin >> roll;
            cout << "Enter marks: ";
            cin >> marks;
            cin.ignore();

            s.setName(name);
            s.setRollNumber(roll);
            s.setMarks(marks);
            s.setGrade('-'); // Placeholder before calculation

            students.push_back(s);
            cout << "Student added successfully.\n";
            break;
        }
        case 2:
            if (students.empty()) {
                cout << "No students to display.\n";
            } else {
                for (const auto& stu : students) {
                    stu.displayInfo();
                }
            }
            break;
        case 3: {
            if (students.empty()) {
                cout << "No students to calculate grade for.\n";
            } else {
                int roll;
                cout << "Enter roll number to calculate grade: ";
                cin >> roll;
                bool found = false;
                for (auto& stu : students) {
                    if (stu.getRollNumber() == roll) {
                        stu.calculateGrade();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    cout << "Student with roll number " << roll << " not found.\n";
                }
            }
            cin.ignore();
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