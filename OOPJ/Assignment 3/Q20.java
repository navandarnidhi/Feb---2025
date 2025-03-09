public class Q20{
	public static void main(String args[]){
		int[][] matrix1 = {{11,2,30},{4,5,16},{7,9,9}};
		int[][] matrix2 = {{11,2,31},{41,15,16},{3,28,92}};
		int result[][] = new int[matrix1.length][matrix2[0].length];	
		for(int i=0; i<matrix1.length; i++){
			for(int j=0; j<matrix2[i].length; j++){
				result[i][j] = 	matrix1[i][j] + matrix2[i][j];
			}
		}
		
		System.out.println();
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[i].length; j++){
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
	}
}