package cn.stanliski.offer51.Backpack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Combination sum II
 * 
 * @author stanley_hwang
 *
 */
public class CombinationSumII {

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int sum){
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0)
			return rst;
		Arrays.sort(num);
		combinationHelper(rst, new ArrayList<Integer>(), num, sum, 0);
		return rst;
	}
	
	public void combinationHelper(ArrayList<ArrayList<Integer>> result
			, ArrayList<Integer> solution, int[] num, int sum, int index){
		if(sum == 0){
			if(!result.contains(solution))
				result.add(new ArrayList<Integer>(solution));
			return;
		}
		if(index >= num.length || sum < 0)
			return;
		solution.add(num[index]);
		combinationHelper(result, solution, num, sum-num[index], index+1);
		solution.remove(solution.size()-1);
		combinationHelper(result, solution, num, sum, index+1);
	}
	
	public static void main(String args[]){
		int num[] = new int[]{6,7};
		int sum = 7;
		CombinationSumII sumII = new CombinationSumII();
		ArrayList<ArrayList<Integer>> rst = sumII.combinationSum2(num, sum);
		for(ArrayList<Integer> list : rst){
			for(Integer n : list){
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
}
