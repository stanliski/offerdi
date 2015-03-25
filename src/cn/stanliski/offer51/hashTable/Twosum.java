package cn.stanliski.offer51.hashTable;

import java.util.HashMap;

/**
 * 
 * Two sum
 * @author stanley_hwang
 *
 */
public class Twosum {
	
	 public int[] twoSum(int[] numbers, int target) {
		 int[] result = new int[2];
		 if(numbers == null || numbers.length < 2){
			 return result;
		 }
		 HashMap<Integer, Integer> contains = new HashMap<Integer, Integer>();
		 for(int i = 0; i < numbers.length; i++){
			 if(!contains.containsKey(numbers[i])){
				 contains.put(target-numbers[i], i);
			 }else{
				 int one = contains.get(numbers[i]) + 1;
				 int two = i + 1; 
				 return new int[]{one, two};
			 }
		 }
		 return result;
	 }
	 
	 public static void main(String args[]){
		 int[] array = new int[]{2, 7, 11, 15};
		 int target = 9;
		 Twosum ts = new Twosum();
		 int[] index = ts.twoSum(array, target);
		 System.out.println(index[0] + "," + index[1]);
	 }
	 
	
}
