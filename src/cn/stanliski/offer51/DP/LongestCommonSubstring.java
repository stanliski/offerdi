package cn.stanliski.offer51.DP;

/**
 * Longest Common substring
 * @author stanley_hwang
 *
 */
public class LongestCommonSubstring {
	
	/**
	 * Longest common substring II.
	 * @param A
	 * @param B
	 * @return
	 */
	 public int longestCommonSubstringII(String A, String B) {
	        // write your code here
	        int maxlen = 0;
	        int xlen = A.length();
	        int ylen = B.length();
	        for(int i = 0; i < xlen; ++i)
		    {
			    for(int j = 0; j < ylen; ++j)
			    {
				    int len = 0;
	                while (i + len < xlen && j + len < ylen && 
	                    A.charAt(i + len) == B.charAt(j + len))
	                        len ++;
				    if(len > maxlen)
					    maxlen = len;
			    }
		    }
	        return maxlen;
	    }

	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	if(A == null || A.length() == 0 || B == null || B.length() == 0)
    		return 0;
        // write your code here
    	char[] word1 = A.toCharArray();
    	char[] word2 = B.toCharArray();
    	int m = word1.length;
    	int n = word2.length;
    	int x = 0, y = 0;
    	int[][] dp = new int[m+1][n+1];
    	for(int i = 1; i <= m; i++)
    		for(int j = 1; j <= n; j++){
    			if(word1[i-1] == word2[j-1]){
    				dp[i][j] = 1;
    				x = i;
    				y = i;
    			}else{
    				dp[i][j] = 0;
    			}
    		}
    	int count = 0;
    	while(dp[x][y] != 0){
    		x--;
    		y--;
    		count++;
    	}
    	return count;
    }
	
    public static void main(String args[]){
    	String A = "www.lintcode.com code";
    	String B = "www.ninechapter.com code";
    	LongestCommonSubstring lcs = new LongestCommonSubstring();
    	lcs.longestCommonSubstringII(A, B);
    }
    
}
