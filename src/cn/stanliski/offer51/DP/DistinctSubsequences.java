package cn.stanliski.offer51.DP;

/**
 * Distinct Subsequences
 * @author stanley_hwang
 *
 */
public class DistinctSubsequences{
	
	 /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
    	if(S == null || S.length() == 0 || T == null || T.length() == 0)
    		return 0;
        // write your code here
    	char[] s = S.toCharArray();
    	char[] t = T.toCharArray();
    	int m = s.length, n = t.length;
    	int[][] dp = new int[m+1][n+1];
    	for(int i = 0; i <= m; i++)
    		dp[i][0] = 1;
    	for(int i = 1; i <= m; i++)
    		for(int j = 1; j <= n; j++){
    			dp[i][j] = dp[i-1][j] + ((s[i-1] == t[j-1]) ? dp[i-1][j-1] : 0); 
    		}
    	return dp[m][n];
    }
	
}
