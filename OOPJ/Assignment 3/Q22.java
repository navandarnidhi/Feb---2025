public class Q22{
	public static void main(String args[]){
		int max= Integer.MIN_VALUE;
		int[][] matrix = {{4,21,32},{45,53,61},{17,12,28}};	
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				max = (matrix[i][j]>max)? matrix[i][j] : max;
			}
		}
		System.out.println("Largest element: " + max);
	}
}