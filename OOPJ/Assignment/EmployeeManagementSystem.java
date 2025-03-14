import java.util.Scanner;

// Employee Management System
class EmployeeManagementSystem {
    private Employee[] employees = new Employee[100];
    private int count = 0;

    private static class Employee {
        private int id;
        private String name;
        private double salary;
        private String phoneNumber;
        private String address;

        public Employee(int id, String name, double salary, String phoneNumber, String address) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public int getId() { return id; }
        public String getEmployeeDetails() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary +
                    ", Phone: " + phoneNumber + ", Address: " + address;
        }
    }

    public void addEmployee(int id, String name, double salary, String phoneNumber, String address) {
        if (count < employees.length) {
            employees[count++] = new Employee(id, name, salary, phoneNumber, address);
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Employee list is full!");
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void printEmployees() {
        if (count == 0) {
            System.out.println("No employees found!");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i].getEmployeeDetails());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        
        while (true) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Print Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    ems.addEmployee(id, name, salary, phone, address);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    ems.deleteEmployee(deleteId);
                    break;
                case 3:
                    ems.printEmployees();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
