package cn.stanliski.offer51.DP;

import java.util.ArrayList;

/**
 * 
 * Triangle
 * 
 * @author stanley_hwang
 *
 */
public class Triangle {
	
	
	/**
	 * 
	 * 动态规划:到第i层的第k个顶点的最小路径长度表示为f(i,k)，则f(i, k) = min{f(i-1,k),  f(i-1,k-1)} + d(i, k); 
	 * 其中d(i, k)表示原来三角形数组里的第i行第k列的元素。
	 * 则可以求得从第一行到最终到第length-1行第k个元素的最小路径长度，
	 * 最后再比较第length-1行中所有元素的路径长度大小，求得最小值。
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			sum[n - 1][i] = triangle.get(n - 1).get(i);
		}

		for (int i = n - 2; i >= 0; i--) { 
			for (int j = 0; j <= i; j++) {
				sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		return sum[0][0];
	}
	
	public int minimumTotalMe(ArrayList<ArrayList<Integer>> triangle){
		if(triangle == null || triangle.size() == 0){
			return 0;
		}
		int n = triangle.size();
		int[][] sum = new int[n][n];
		for(int i = 0; i < n; i++)
			sum[n-1][i] = triangle.get(n-1).get(i);
		for(int i = n-2; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
			}
		}
		return sum[0][0];
	} 
	
	
}
