package cn.stanliski.offer51.array;

import java.util.ArrayList;

/**
 * 
 * Partition Array
 * 
 * @author stanley_hwang
 *
 */
public class PartitionArray {

	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
        if(nums == null || nums.size() == 0)
        	return 0;
    	int[] array = new int[nums.size()];
    	for(int i = 0; i < nums.size(); i++){
    		array[i] = nums.get(i);
    	}
    	int i = 0;
    	for(i = 0; i < array.length; i++){
    		if(array[i] >= k)
    			break;
    	}
    	if(i == array.length)
    		return array.length;
    	int j = array.length-1;
    	int temp = array[i];
    	while(i != j){
    		while(i < j && array[j] >= k){
    			j--;
    		}
    		if(i < j){
    			array[i] = array[j];
    			i++;
    		}
    		while(i < j && array[i] < k){
    			i++;
    		}
    		if(i < j){
    			array[j] = array[i];
    			j--;
    		}
    	}
    	array[i] = temp;
    	nums.clear();
    	for(int t = 0; t < array.length; t++){
    		nums.add(array[t]);
    	}
    	return i;
    	
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	//9, 9, 9, 8, 9, 8, 7, 9, 8, 8, 8, 9, 8, 9, 8, 8, 6, 9
    	nums.add(9);
    	nums.add(9);
    	nums.add(9);
    	nums.add(8);
    	nums.add(9);
    	nums.add(8);
    	nums.add(7);
    	nums.add(9);
    	nums.add(8);
    	nums.add(8);
    	nums.add(8);
    	nums.add(9);
    	nums.add(8);
    	nums.add(9);
    	nums.add(8);
    	nums.add(8);
    	nums.add(6);
    	nums.add(9);
    	PartitionArray pa = new PartitionArray();
    	int index = pa.partitionArray(nums, 9);
    	System.out.println("index=" + index);
    }
	
}
