import java.util.InputMismatchException;
import java.util.Scanner;

// ElectricityBill class definition
class ElectricityBill {
    private String customerName;
    private double unitsConsumed;
    private double billAmount;

    // Parameterized constructor
    public ElectricityBill(String customerName, double unitsConsumed) {
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = 0;
    }

    // Method to calculate the electricity bill amount
    public void calculateBillAmount() {
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 5;
        } else if (unitsConsumed <= 300) {
            billAmount = (100 * 5) + ((unitsConsumed - 100) * 7);
        } else {
            billAmount = (100 * 5) + (200 * 7) + ((unitsConsumed - 300) * 10);
        }
    }

    // Method to display the bill details
    public void displayBill() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill Amount: Rs. " + billAmount);
    }
}

// Main class
public class ElectricityBillExcept {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String customerName;
        double unitsConsumed;

        try {
            // Taking user input
            System.out.print("Enter customer name: ");
            customerName = sc.nextLine();
            
            System.out.print("Enter units consumed: ");
            unitsConsumed = sc.nextDouble();
            
            // Validate input
            if (unitsConsumed < 0) {
                throw new IllegalArgumentException("Units consumed cannot be negative.");
            }
            
            // Creating an instance of ElectricityBill
            ElectricityBill bill = new ElectricityBill(customerName, unitsConsumed);
            
            // Calculating and displaying the bill
            bill.calculateBillAmount();
            bill.displayBill();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value for units consumed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
