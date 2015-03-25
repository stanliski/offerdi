package cn.stanliski.offer51.array;

import java.util.ArrayList;

/**
 * 
 * Minimum subarray.
 * 
 * @author stanley_hwang
 *
 */
public class MinimumSubarray {
	
	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
	
	
    public int minSubArray(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int cursum = 0;
        for(int i = 0; i < nums.size(); i++){
        	cursum += nums.get(i);
        	if(cursum < min)
        		min = cursum;
        	if(cursum > 0)
        		cursum = 0;
        }
        return min;
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	//1, -1, -2, 1
    	nums.add(1);
    	nums.add(2);
    	nums.add(3);
    	nums.add(4);
    	MinimumSubarray sub = new MinimumSubarray();
    	System.out.println(sub.minSubArray(nums));
    }
	
}
