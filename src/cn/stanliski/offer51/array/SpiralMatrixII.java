package cn.stanliski.offer51.array;

/**
 * 
 * Spiral Matrix II.
 * 
 * @author stanley_hwang
 *
 */
public class SpiralMatrixII {
	
	
	public int[][] generateMatrix(int n){

		int[][] result = new int[n][n];
		int i = 1;
		int count = 0;
		int rows = n;
		int columns = n;
		while(i <= n*n && count * 2 < rows && count * 2 < columns){
			for(int k = count; k < columns - count; k++){
				result[count][k] = i;
				i++;
			}
			for(int k = count + 1; k < rows - count; k++){
				result[k][rows-count-1] = i;
				i++;
			}
			if(rows - 2 * count == 1 || columns - 2 * count == 1){
				if(i > n * n)
					return result;
			}
			for(int k = columns-count-2; k >= count; k--){
				result[rows-count-1][k] = i;
				i++;
			}
			for(int k = rows-count-2; k >= count+1; k--){
				result[k][count] = i;
				i++;
			}
			if(i > n * n)
				return result;
			count++;
		}

		return result;
	}
	
	public static void main(String args[]){
		int n = 3;
		SpiralMatrixII ii = new SpiralMatrixII();
		int[][] result = ii.generateMatrix(5);
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[0].length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
