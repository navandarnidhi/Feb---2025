import java.util.Scanner;

public class Employee {
    int emp_id;
    String emp_name;
    String emp_address;
    long phone_number;
    double salary;

    Employee(int emp_id, String emp_name, String emp_address, long emp_phone_number, double emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.phone_number = emp_phone_number;
        this.salary = emp_salary;

        System.out.println("\nEmployee Details:");
        System.out.println("Emp_id: " + emp_id);
        System.out.println("Emp_name: " + emp_name);
        System.out.println("Emp_address: " + emp_address);
        System.out.println("Emp_phone_number: " + emp_phone_number);
        System.out.println("Emp_salary: " + salary);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        
        for (int i = 1; i <= numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + i + ":");
            
            System.out.print("Enter Employee ID: ");
            int emp_id = scanner.nextInt();
            
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter Employee Name: ");
            String emp_name = scanner.nextLine();
            
            System.out.print("Enter Employee Address: ");
            String emp_address = scanner.nextLine();
            
            System.out.print("Enter Employee Phone Number: ");
            long emp_phone_number = scanner.nextLong();
            
            System.out.print("Enter Employee Salary: ");
            double emp_salary = scanner.nextDouble();
            
            new Employee(emp_id, emp_name, emp_address, emp_phone_number, emp_salary);
        }
        
        scanner.close();
    }
}
