public class Q07{
	public static void main(String[] args){
		boolean check = true;
		if(check){
			System.out.println("in if block");
		}else {
			System.out.println("in another if block");
		}	
		check = false;
		
		do{
			System.out.println("Executes once");
		}while(check);
	}
}