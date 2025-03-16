import java.io.Scanner;
public class Q11{
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		int x =  sc.nextInt();
		
		if(x>0 && x%2==0){
			System.out.println(x + " is even and positive");
	}
}