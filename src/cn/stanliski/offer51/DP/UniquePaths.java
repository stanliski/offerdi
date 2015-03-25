package cn.stanliski.offer51.DP;


/**
 * 
 * Unique Paths.
 * 
 * @author stanley_hwang
 *
 */
public class UniquePaths {

	/**
	 * Unique paths.
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0)
			return 0;
		int result[][] = new int[m][n];
		for(int i = 0; i < m; i++){
			result[i][0] = 1;
		}
		for(int j = 0; j < n; j++){
			result[0][j] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}
		return result[m-1][n-1];
	}

	/**
	 * Unique paths II.
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length;

		int n = obstacleGrid[0].length;
		
		int[][] check = new int[m][n];
		
		if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
			return 0;
		
		if(obstacleGrid[0][0] == 0 && m == 1 && n == 1)
			return 1;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				check[i][j] = obstacleGrid[i][j];
			}
		}

		for(int i = 1; i < m; i++){
			if(check[i][0] != 1)
				obstacleGrid[i][0] = 1;
			else{
				if(m == 1 || n == 1)
					return 0;
				break;
			}
		}

		for(int i = 1; i < n; i++){
			if(check[0][i] != 1)
				obstacleGrid[0][i] = 1;
			else{
				if(m == 1 || n == 1)
					return 0;
				break;
			}
		}

		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(check[i][j] != 1){
					if(check[i-1][j] == 1 && check[i][j-1] == 1)
						obstacleGrid[i][j] = 0;
					if(check[i-1][j] != 1 || check[i][j-1] != 1){
						if(check[i-1][j] != 1 && check[i][j-1] != 1)
							obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
						else
							obstacleGrid[i][j] = (check[i-1][j] == 1) ? obstacleGrid[i][j-1] : obstacleGrid[i-1][j]; 
					}
				}
			}
		}
		return obstacleGrid[m-1][n-1];
	}

	public static void main(String args[]){
		int m = 3; 
		int n = 3;
		UniquePaths path = new UniquePaths();
		int count = path.uniquePaths(m, n);
		System.out.println(count);
		int[][] matrix = new int[][]{{0,0},{0,0}};
		int count2 = path.uniquePathsWithObstacles(matrix);
		System.out.println(count2);
	}

}
