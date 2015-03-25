/**
 * 
 */
package cn.stanliski.offer51.crackingthecoding;

import java.util.ArrayList;


/**
 * 
 * Get all subsets
 *
 */
public class Subsets {

	/**
	 * Get all subsets.
	 * @param set
	 * @param index
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> 
						getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubsets = new ArrayList<Integer>();
				newsubsets.addAll(subset);
				newsubsets.add(item);
				moresubsets.add(newsubsets);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
}
