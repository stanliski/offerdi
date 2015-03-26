package cn.stanliski.offer51.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Unique Permutations
 * @author stanley_hwang
 *
 */
public class UniquePermutations {

	/**
	 * @param nums: A list of integers.
	 * @return: A list of unique permutations.
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		// write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(nums == null || nums.size() == 0)
			return result;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] visited = new int[nums.size()];

		Collections.sort(nums);
		helper(result, list, visited, nums);
		return result;
	}

	public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
			int[] visited, ArrayList<Integer> num) {
		if(list.size() == num.size()) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for(int i = 0; i < num.size(); i++) {
			if (visited[i] == 1 || (i != 0 && num.get(i) == num.get(i-1) && visited[i - 1] == 0)){
				continue;
			}
			visited[i] = 1;
			list.add(num.get(i));
			helper(result, list, visited, num);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
	} 

	public static void main(String args[]){
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		UniquePermutations up = new UniquePermutations();
		list1.add(1);
		list1.add(2);
		list1.add(2);
		rst = up.permuteUnique(list1);
		for(ArrayList<Integer> list : rst){
			for(Integer num : list){
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}


}
