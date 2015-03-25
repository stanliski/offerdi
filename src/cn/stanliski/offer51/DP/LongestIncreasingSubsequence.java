package cn.stanliski.offer51.DP;

/**
 * 
 * Longest Increasing Subsequence
 * @author stanley_hwang
 *
 */
public class LongestIncreasingSubsequence{

	public int longestIncreasingSubsequence(int[] nums) {
		int f[] = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
				}
			}
			if (f[i] > max) {
				max = f[i];
			}
		}
		return max;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{1,1,1,1,1,1};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int num = lis.longestIncreasingSubsequence(nums);
		System.out.println(num);
	}
	
}
