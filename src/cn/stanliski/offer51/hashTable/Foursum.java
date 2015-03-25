package cn.stanliski.offer51.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 4 sum
 * @author stanley_hwang
 *
 */
public class Foursum {

	/**
	 * Four sum.
	 * @param numbers
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(numbers == null || numbers.length < 4)
			return results;
		Arrays.sort(numbers);
		for(int k = 0; k <= numbers.length-4; k++){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i = k+1; i <= numbers.length-3; i++){
				for(int j = i+1; j <= numbers.length-2; j++)
				if(!map.containsKey(numbers[j])){
					map.put(target-(numbers[k]+numbers[i]+numbers[j]), j);
				}else{
					int index1 = k;
					int index2 = i;
					int index3 = map.get(numbers[j]);
					int index4 = j;
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(numbers[index1]);
					solution.add(numbers[index2]);
					solution.add(numbers[index3]);
					solution.add(numbers[index4]);
					Collections.sort(solution);
					if(!results.contains(solution))
						results.add(solution);
				}
			}
		}
		return results;
	}

}
