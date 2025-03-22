import java.util.*;

// Abstract Class: Person
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract String getRole();
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + getRole());
    }
}

// Interface: CourseStructure
interface CourseStructure {
    List<String> getSubjects();
}

// Implementing different courses
class JavaCourse implements CourseStructure {
    public List<String> getSubjects() {
        return Arrays.asList("Java", "JDBC", "Spring", "Hibernate");
    }
}

class PythonCourse implements CourseStructure {
    public List<String> getSubjects() {
        return Arrays.asList("Python", "Flask", "Django", "Data Science");
    }
}

class DataScienceCourse implements CourseStructure {
    public List<String> getSubjects() {
        return Arrays.asList("Machine Learning", "Deep Learning", "Big Data", "AI");
    }
}

// Class: Mentor
class Mentor extends Person {
    private String department;

    public Mentor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Mentor";
    }
    
    public String getDepartment() {
        return department;
    }
}

// Class: Student (Abstract)
abstract class Student extends Person {
    private static int counter = 1;
    protected String studentId;
    protected CourseStructure course;
    protected double baseFee;
    protected Mentor mentor;
    
    public Student(String name, int age, CourseStructure course, double baseFee, Mentor mentor) {
        super(name, age);
        this.studentId = "STU" + String.format("%03d", counter++);
        this.course = course;
        this.baseFee = baseFee;
        this.mentor = mentor;
    }
    
    public abstract double calculateTotalFee();
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    public void displayDetails() {
        System.out.println("--------------------------------------");
        System.out.println("ID: " + studentId);
        super.displayDetails();
        System.out.println("Course: " + course.getClass().getSimpleName());
        System.out.println("Subjects: " + course.getSubjects());
        System.out.println("Base Fee: ₹" + baseFee);
        System.out.println("Total Fee: ₹" + calculateTotalFee());
        System.out.println("Mentor: " + mentor.name + " (Dept: " + mentor.getDepartment() + ")");
        System.out.println("--------------------------------------");
    }
}

// Class: DayScholar
class DayScholar extends Student {
    private double transportFee;

    public DayScholar(String name, int age, CourseStructure course, double baseFee, Mentor mentor, double transportFee) {
        super(name, age, course, baseFee, mentor);
        this.transportFee = transportFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + transportFee;
    }
}

// Class: Hosteller
class Hosteller extends Student {
    private double hostelFee;

    public Hosteller(String name, int age, CourseStructure course, double baseFee, Mentor mentor, double hostelFee) {
        super(name, age, course, baseFee, mentor);
        this.hostelFee = hostelFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + hostelFee;
    }
}

// Main Class: Student Management System
public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static List<Mentor> mentors = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample mentors
        mentors.add(new Mentor("Prof. Shukla", 45, "CS"));
        mentors.add(new Mentor("Dr. Mehta", 50, "IT"));

        while (true) {
            System.out.println("1. Add Student\n2. Display All Students\n3. Show Course Subjects\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    showCourseSubjects(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        
        System.out.println("Choose Course: 1. Java 2. Python 3. Data Science");
        int courseChoice = scanner.nextInt();
        CourseStructure course = switch (courseChoice) {
            case 1 -> new JavaCourse();
            case 2 -> new PythonCourse();
            case 3 -> new DataScienceCourse();
            default -> throw new IllegalArgumentException("Invalid Course");
        };
        
        System.out.print("Enter Base Fee: ");
        double baseFee = scanner.nextDouble();
        
        System.out.println("Choose Mentor: ");
        for (int i = 0; i < mentors.size(); i++) {
            System.out.println((i + 1) + ". " + mentors.get(i).name + " (" + mentors.get(i).getDepartment() + ")");
        }
        int mentorChoice = scanner.nextInt();
        Mentor mentor = mentors.get(mentorChoice - 1);

        System.out.println("Choose Type: 1. DayScholar 2. Hosteller");
        int type = scanner.nextInt();
        
        if (type == 1) {
            System.out.print("Enter Transport Fee: ");
            double transportFee = scanner.nextDouble();
            students.add(new DayScholar(name, age, course, baseFee, mentor, transportFee));
        } else {
            System.out.print("Enter Hostel Fee: ");
            double hostelFee = scanner.nextDouble();
            students.add(new Hosteller(name, age, course, baseFee, mentor, hostelFee));
        }
    }

    private static void displayAllStudents() {
        for (Student s : students) {
            s.displayDetails();
        }
    }

    private static void showCourseSubjects(Scanner scanner) {
        System.out.println("Enter Course: 1. Java 2. Python 3. Data Science");
        int choice = scanner.nextInt();
        CourseStructure course = switch (choice) {
            case 1 -> new JavaCourse();
            case 2 -> new PythonCourse();
            case 3 -> new DataScienceCourse();
            default -> throw new IllegalArgumentException("Invalid Course");
        };
        System.out.println("Subjects: " + course.getSubjects());
    }
}
