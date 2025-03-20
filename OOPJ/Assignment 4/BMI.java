import java.util.Scanner;

// BMICalculator class definition
class BMICalculator {
    private double height;
    private double weight;

    // Parameterized constructor
    public BMICalculator(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    // Getter and Setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getter and Setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return weight / (height * height);
    }
}

// Main class
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompting user for height and weight
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        
        // Creating an instance of BMICalculator
        BMICalculator bmiCalculator = new BMICalculator(height, weight);
        
        // Calculating and displaying BMI
        double bmi = bmiCalculator.calculateBMI();
        System.out.printf("Your BMI is: %.2f", bmi);
        
        scanner.close();
    }
}
