public class Q18{
	public static void main(String args[]){
		int[][] matrix = {{1,5,8},{4,0,6},{17,2,9}};
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
}