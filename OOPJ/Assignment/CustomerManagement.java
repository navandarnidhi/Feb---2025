import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    int customerId;
    String name;
    String address;
    long phoneNumber;
    String email;

    // Constructor
    public Customer(int customerId, String name, String address, long phoneNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Display customer details
    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name       : " + name);
        System.out.println("Address    : " + address);
        System.out.println("Phone No.  : " + phoneNumber);
        System.out.println("Email      : " + email);
        System.out.println("---------------------------");
    }
}

public class CustomerManagement {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCustomer Management System Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Method to add a customer
    public static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        customers.add(new Customer(customerId, name, address, phoneNumber, email));
        System.out.println("Customer added successfully!");
    }

    // Method to view all customers
    public static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
        } else {
            System.out.println("\nCustomer List:");
            for (Customer customer : customers) {
                customer.displayCustomer();
            }
        }
    }

    // Method to update a customer
    public static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Customer customer : customers) {
            if (customer.customerId == id) {
                System.out.print("Enter new Name: ");
                customer.name = scanner.nextLine();

                System.out.print("Enter new Address: ");
                customer.address = scanner.nextLine();

                System.out.print("Enter new Phone Number: ");
                customer.phoneNumber = scanner.nextLong();
                scanner.nextLine();  // Consume newline

                System.out.print("Enter new Email: ");
                customer.email = scanner.nextLine();

                System.out.println("Customer updated successfully!");
                return;
            }
        }
        System.out.println("Customer ID not found!");
    }

    // Method to delete a customer
    public static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int id = scanner.nextInt();

        for (Customer customer : customers) {
            if (customer.customerId == id) {
                customers.remove(customer);
                System.out.println("Customer deleted successfully!");
                return;
            }
        }
        System.out.println("Customer ID not found!");
    }
}
