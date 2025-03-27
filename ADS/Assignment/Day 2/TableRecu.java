import java.util.*;

public class TableRecu {
	public static void printTable(int n, int i){
		if(i > 10){
			return;
		}
		
		System.out.println(n + " * " + i + " = " + (n * 1));
		
		printTable(n, i + 1);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		
		System.out.println("Multiplication Table of " + num + ":");
        printTable(num, 1); 
        sc.close();
	}
}