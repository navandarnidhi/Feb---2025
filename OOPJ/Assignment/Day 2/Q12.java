import java.util.Scanner;
public class Q12{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a = sc.nextInt();
		System.out.print("Enter second number: ");
		int b = sc.nextInt();
		System.out.print("Enter your choice \n1.+ \n2.- \n3.* \n4./ \n5.% \n6.++ \n7.--");
		sc.nextLine();
		int c = sc.nextInt();
		if(c==1){
			a += b; 
			System.out.println("Addition: " + a);
		} else if(c==2){
			a -= b;
			System.out.println("Difference: " + a);
		} else if(c==3){
			a *= b;
			System.out.println("Multplication: " + a);
		} else if(c==4){
			a /= b;
			System.out.println("Division: " + a);
		} else if(c==5){
			a %= b;
			System.out.println("Remainder: " + a);
		} else if(c==6){
			a++;
			++b;
			System.out.println("Increment Assigment: " + a + " " + b);
		}  else if(c==7){
			a--;
			--b;
			System.out.println("Decrement Assigment: " + a + " " + b);
		} else {
			System.out.println("INVALID OPTION");
		}
	}
}