package cn.stanliski.offer51.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subset
 * @author stanley_hwang
 *
 */
public class Subset {

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public ArrayList<ArrayList<Integer>> subsetsII(int[] num){
		ArrayList<Integer> set = new ArrayList<Integer>(num.length);
 		for(int i = 0; i < num.length; i++){
			set.add(num[i]);
		}
		return subsetsIIHelper(set, 0);
	}
	
	public ArrayList<ArrayList<Integer>> subsetsIIHelper(ArrayList<Integer> set, int index){
		
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = subsetsIIHelper(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	
	public ArrayList<ArrayList<Integer>> subsets(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);  
		subsetsHelper(result, list, num, 0);

		return result;
	}


	private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] num, int pos) {

		result.add(new ArrayList<Integer>(list));

		for (int i = pos; i < num.length; i++) {

			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String args[]){
		int num[] = new int[]{3,4,2,1};
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(4);
		test.add(2);
		test.add(3);
		Subset set = new Subset();
		ArrayList<ArrayList<Integer>> result = set.subsetsII(num);
		for(int i = 0; i < result.size(); i++){
			ArrayList subList = result.get(i);
			for(int j = 0; j < subList.size(); j++){
				System.out.print(subList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
