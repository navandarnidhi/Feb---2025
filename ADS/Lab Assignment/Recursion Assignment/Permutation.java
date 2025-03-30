//Time Complexity = O(n!)

import java.util.Scanner;
import java.util.*;

class Permutation{
	static void display(String str, String result){
		if (str.length() == 0){
			System.out.println(result+"");
			return;
		}
		
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			String left =str.substring(0,i)+str.substring(i+1);
			display(left, result+ch);
		}
	}
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String s = sc.nextLine();
		
		System.out.println("The Sub Strings are: ");
		display (s,"");
	}
}