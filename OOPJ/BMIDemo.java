import java.util.*;

class BMICalculator {
	double height;
	double weight;
	
	public BMICalculator(double height, double weight) {
		if(height < 0 || weight < 0){
			throw new IllegalArgumentException(" height or weight  cannot be negative.");
		}
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight(){
		return height;
	}
	
	public void setHeight(double height){
		
		this.height = height;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void setWeight(double weight){
		
		this.weight = weight;
	}
	
	public double calculateBMI(){
		return weight / (height * height);
	}
	
	
}

public class BMIDemo {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Height: " );
			double height = sc.nextDouble();
			
			System.out.println("Enter Weight: " );
			double weight = sc.nextDouble();
			
			BMICalculator bmi = new BMICalculator(height, weight);
			
			double result = bmi.calculateBMI();
			
			System.out.printf("Your BMI: %.4f%n", result);
		}
		
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}


