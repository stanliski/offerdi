package cn.stanliski.offer51.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * three sum.
 * @author stanley_hwang
 *
 */
public class Threesum {

	/**
	 * 3 sum.
	 * @param numbers
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(numbers == null || numbers.length < 3)
			return results;
		Arrays.sort(numbers);
		for(int k = 0; k < numbers.length; k++){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i = k+1; i < numbers.length; i++){
				if(!map.containsKey(numbers[i])){
					map.put(-(numbers[k]+numbers[i]), i);
				}else{
					int index1 = k;
					int index2 = map.get(numbers[i]);
					int index3 = i;
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(numbers[index1]);
					solution.add(numbers[index2]);
					solution.add(numbers[index3]);
					Collections.sort(solution);
					if(!results.contains(solution))
						results.add(solution);
				}
			}
		}
		return results;
	}
	
	public Comparator compare = new Comparator(){

		public int compare(Object o1, Object o2) {
			ArrayList<Integer> arr1 = (ArrayList<Integer>)o1;
			ArrayList<Integer> arr2 = (ArrayList<Integer>)o2;
			int i = 0;
			while(i < 3){
				if(arr1.get(i) < arr2.get(i))
					return 1;
				else if(arr1.get(i) == arr2.get(i))
					i++;
				else
					return -1;
			}
			return 0;
		}
		
	};
	
	
	public static void main(String args[]){
		int[] numbers = new int[]{-1,0,1,2,-1,-4};
		Threesum sum = new Threesum();
		ArrayList<ArrayList<Integer>> result = sum.threeSum(numbers);
		for(ArrayList<Integer> list : result){
			for(Integer eles : list){
				System.out.print(eles + " ");
			} 
			System.out.println();
		}
	}

}
