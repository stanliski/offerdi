package cn.stanliski.offer51.DP;

/**
 * 
 * Shortest edit distance.
 * 
 * @author stanley_hwang
 *
 */
public class ShortestEditDistance {

	public int minDistance(String word1, String word2) {
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		int m = w1.length, n = w2.length;
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i <= m; i++)
			dp[i][0] = i;
		for(int i = 0; i <= n; i++)
			dp[0][i] = i;
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++){
				if(w1[i-1] == w2[j-1]){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
				}
			}
		return dp[m][n];
	}
	
	public static void main(String args[]){
		String word1 = "a";
		String word2 = "a";
		ShortestEditDistance sd = new ShortestEditDistance();
		int num = sd.minDistance(word1, word2);
		System.out.println("num = " + num);
	}

}
