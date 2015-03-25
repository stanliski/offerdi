package cn.stanliski.offer51.DP;

import java.util.ArrayList;

/**
 * 
 * Greatest sum of array.
 * @author stanley_hwang
 *
 */
public class GreatestSumOfArray {

	public int maxSubArray(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int cursum = 0;
		for(int i = 0; i < nums.size(); i++){
			if(cursum <= 0)
				cursum = nums.get(i);
			else
				cursum += nums.get(i);
			if(cursum > max)
				max = cursum;
		}
		return max;
	}

	public int greatestSum(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int max = 0;
		int cursum = 0;
		for(int i = 0; i < nums.length; i++){
			if(cursum <= 0){
				cursum = nums[i];
			}else{
				cursum += nums[i];
			}
			if(cursum > max)
				max = cursum;
		}
		return max;
	}

	public static void main(String args[]){

	}

}
