package cn.stanliski.offer51.DP;

/**
 * 
 * Longest Common Subsequence
 * 
 * @author stanley_hwang
 *
 */
public class LongestCommonSubsequence {

	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
    	if(A == null || A.length() == 0 || B == null || B.length() == 0)
    		return 0;
        // write your code here
    	char[] word1 = A.toCharArray();
    	char[] word2 = B.toCharArray();
    	int m = word1.length, n = word2.length;
    	int[][] dp = new int[m+1][n+1];
    	for(int i = 1; i <= m; i++)
    		for(int j = 1; j <= n; j++){
    			if(word1[i-1] == word2[j-1]){
    				dp[i][j] = dp[i-1][j-1] + 1;
    			}else if(dp[i-1][j] >= dp[i][j-1])
    				dp[i][j] = dp[i-1][j];
    			else
    				dp[i][j] = dp[i][j-1];
    		}
    	return dp[m][n];
    }
	
}
