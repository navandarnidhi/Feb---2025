public class Q06{
	public static void main(String[] args){
		for(int i=97; i<123; i++){
			System.out.println(i + " " +(char)i + " ");
		}
		System.out.println();
		
		String s = "hello world";
		System.out.println(s);
		for(int i=0; i<s.length(); i++){
			System.out.print((int)(s.charAt(i)) + " ");
		}
	}
}