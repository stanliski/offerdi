package cn.stanliski.offer51.DP;


/**
 * 
 * 大体思路是，s1取一部分s2取一部分，最后是否能匹配s3。
 * 动态规划数组是dp[i][j]，表示： s1取前i位，s2取前j位，是否能组成s3的前i+j位。
 * @author stanley_hwang
 *
 */
public class InterleavingString {

	/**
	 * Determine whether s3 is formed by interleaving of s1 and s2.
	 * @param s1, s2, s3: As description.
	 * @return: true or false.
	 */
	public boolean isInterleave(String s1, String s2, String s3){
		if(s3.length()!=s1.length()+s2.length()) 
			return  false;
		char[] w1 = s1.toCharArray();
		char[] w2 = s2.toCharArray();
		char[] w3 = s3.toCharArray();
		int m = w1.length;
		int n = w2.length;
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for(int i = 1; i <= m; i++)
			if(w1[i-1] == w3[i-1])
				dp[i][0] = true;
		for(int j = 1; j <= n; j++)
			if(w2[j-1] == w3[j-1])
				dp[0][j] = true;
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(w3[i+j-1] == w1[i-1] && dp[i-1][j])
					dp[i][j] = true;
				if(w3[i+j-1] == w2[j-1] && dp[i][j-1])
					dp[i][j] = true;
			}
		}
		return dp[m][n];
	}


	public boolean isInterleaveII(String s1, String s2, String s3) {

		if(s3.length()!=s1.length()+s2.length()) 
			return  false;
		boolean  [][] dp =  new boolean[s1.length()+1][s2.length()+1];
		dp[0][0]=true;
		for(int i = 1; i<=s1.length() && s1.charAt(i-1)==s3.charAt(i-1); i++)
			dp[i][0] = true ;
		for(int i = 1; i<=s2.length() && s2.charAt(i-1)==s3.charAt(i-1); i++)
			dp[0][i]=true;
		for (int  i = 1; i <= s1.length(); i++){
			for ( int j = 1; j <= s2.length(); j++){
				char c = s3.charAt(i+j-1);
				if(c == s1.charAt(i-1) && dp[i-1][j])
					dp[i][j] = true;
				if(c == s2.charAt(j-1) && dp[i][j-1])
					dp[i][j] = true;
			}

		}
		return dp[s1.length()][s2.length()];
	}

}
