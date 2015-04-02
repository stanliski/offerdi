package cn.stanliski.offer51.hashMap;

import java.util.HashMap;


/**
 * @author stanley_hwang
 *
 */
public class LongestConsecutiveSequence {

	 /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
    	if(num == null || num.length == 0)
    		return 0;
    	HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
    	for(int i = 0; i < num.length; i++){
    		hashMap.put(num[i], false);
    	}
    	int count = 1;
    	int maxCount = Integer.MIN_VALUE;
    	for(int i = 0; i < num.length; i++){
    		if(hashMap.containsKey(num[i]) && !hashMap.get(num[i])){
    			int small = num[i]-1;
    			int big = num[i]+1;
    			hashMap.put(num[i], true);
    			boolean smallCheck = true;
    			boolean bigCheck = true;
    			while(true){
    				if(smallCheck && hashMap.containsKey(small) && !hashMap.get(small)){
    					hashMap.put(small, true);
    					small--;
    					count++;
    				}else
    					smallCheck = false;
    				if(bigCheck && hashMap.containsKey(big) && !hashMap.get(big)){
    					hashMap.put(big, true);
    					big++;
    					count++;
    				}else
    					bigCheck = false;
    				if(!smallCheck && !bigCheck)
    					break;
    			}
    		}
    		if(maxCount < count){
    			maxCount = count;
    			count = 1;
    		}else 
    			count = 1;
    	}
    	return maxCount;
    }
    
    public static void main(String args[]){
    	int[] nums = new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7};
    	// -2 -1 1 2 3 4 
    	// 1,1,2,3,4,5,5,6,9 123456
    	LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
    	int len = lcs.longestConsecutive(nums);
    	System.out.println(len);
    }
	
}
