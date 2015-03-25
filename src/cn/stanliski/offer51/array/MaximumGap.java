package cn.stanliski.offer51.array;

import java.util.Arrays;

/**
 * Maximum Gap.
 * 
 * @author stanley_hwang
 *
 */
public class MaximumGap {
	
	/**
	 * Consider use the bucket sort, we can make the time complexity down to O(n).
	 */
	
	/**
	 * Return Maximum Gap.
	 * @param num
	 * @return
	 */
	public int maximumGap(int[] num) {
		if(num.length < 2)
			return 0;
		int maxGap = 0;
		Arrays.sort(num);
		for(int i = 0; i < num.length-1; i++){
			if(num[i+1] - num[i] > maxGap){
				maxGap = num[i+1] - num[i];
			}
		}
		return maxGap;
	}

}
