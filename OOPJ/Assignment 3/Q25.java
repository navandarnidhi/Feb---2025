public class Q25{
	public static void main(String args[]){
		int diagonalsum=0;
		int[][] matrix = {{1,21,32},{42,2,61},{17,18,3}};	
		for(int i=0; i<matrix.length; i++){
			diagonalsum += matrix[i][i];
		}
		System.out.println("Diagonal Sum: " + diagonalsum);
	}
}