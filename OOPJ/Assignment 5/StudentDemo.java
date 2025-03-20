import java.util.Scanner;
import java.util.InputMismatchException;

// Student class definition
class Student {
    private String name;
    private int rollNo;
    private double[] marks;
    private double average;
    private char grade;

    // Parameterized constructor
    public Student(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = new double[5];
        
        for (int i = 0; i < 5; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new IllegalArgumentException("Marks should be between 0 and 100.");
            }
            this.marks[i] = marks[i];
        }
    }

    // Method to calculate the average marks
    public void calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        average = sum / marks.length;
    }

    // Method to calculate the grade
    public void calculateGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.print("Marks: ");
        for (double mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}

// Main class
public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            // Taking user input
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter roll number: ");
            int rollNo = sc.nextInt();
            
            double[] marks = new double[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int i = 0; i < 5; i++) {
                marks[i] = sc.nextDouble();
            }
            
            // Creating an instance of Student
            Student student = new Student(name, rollNo, marks);
            
            // Calculating and displaying the results
            student.calculateAverage();
            student.calculateGrade();
            student.displayStudentInfo();
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid numeric values for roll number and marks.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
