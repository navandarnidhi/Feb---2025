
class Student {
	String name;
	int marks1, marks2, marks3;
	public Student(String name, int marks1, int marks2, int marks3) {
		super();
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	public String getName() {
		return name;
	}
	public int getMarks1() {
		return marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	
	public int getTotalMarks() {
		return marks1 + marks2 + marks3;
	}
	
	public double getAverageMarks() {
		return getTotalMarks() /3.0;
	}
	
	public void display() {
		System.out.println("Student Name: " + name);
		System.out.println("Total MArks: " + getTotalMarks());
		System.out.println("Average Marks: " + getAverageMarks());
	}
}
public class StudentDemo {
	public static void main(String args[]) {
		Student s1 = new Student("John deo", 67,45, 67);
		
		s1.display();

	}
}
