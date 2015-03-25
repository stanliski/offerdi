package cn.stanliski.offer51.matrix;

/**
 * 
 * Array Matrix relative manipulations.
 * @author stanley_hwang
 *
 */
public class ArrayMatrix {
	
	
	/**** Left Rotate Situation ****/
	
	/**
	 * rotate matrix space complexity O(1)
	 * @param matrix
	 */
	public void rotateMeII(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		for(int count = 0; count < n/2; count++){
			for(int i = count; i < n-count-1; i++){
				int top = matrix[count][i];
				matrix[count][i] = matrix[n-i-1][count];
				matrix[n-i-1][count] = matrix[n-count-1][n-i-1];
				matrix[n-count-1][n-i-1] = matrix[i][n-count-1];
				matrix[i][n-count-1] = top;
			}
		}
		printMatrix(matrix);
	}
	
	public void rotateMe(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] copy = new int[n][m];
		int count = 0;
		while(count*2 < m && count*2 < n){
			for(int i = count; i < n-count; i++){
				copy[i][m-count-1] = matrix[count][i];
			}
			for(int i = count; i < m-count; i++){
				copy[n-count-1][m-i-1] = matrix[i][n-count-1];
			}
			for(int i = n-count-1; i >= count; i--){
				copy[i][count] = matrix[m-count-1][i];
			}
			for(int i = m-count-1; i >= count; i--){
				copy[count][m-i-1] = matrix[i][count];
			}
			count++;
		}
		printMatrix(copy);
	}

	public void rotate(int[][] matrix){
		int n = matrix.length;
		for(int layer = 0; layer<n/2; layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i = first; i < last; i++){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		printMatrix(matrix);
	}
	
	public void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int[][] matrix = new int[][]{{1,2},{3,4}};
		ArrayMatrix arraymatrix = new ArrayMatrix();
		arraymatrix.rotateMeII(matrix);
	}
	
}
