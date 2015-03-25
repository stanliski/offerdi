package cn.stanliski.offer51.array;

/**
 * 
 * Set Matrix Zeroes.
 * 
 * @author stanley_hwang
 *
 */
public class SetMatrixZeroes {
	
	
	public void setZeros(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return;
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for(int i = 0; i < rows.length; i++){
			for(int j = 0; j < cols.length; j++){
				if(rows[i] || cols[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	
	/**
	 * Set Zeroes.
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean empty_row0 = false;
        boolean empty_col0 = false;
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		if(matrix[i][j] == 0){
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		if(matrix[0][j] == 0 || matrix[i][0] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        if(empty_row0){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }           
        }
        
        if(empty_col0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }           
        }
    }
	
}
