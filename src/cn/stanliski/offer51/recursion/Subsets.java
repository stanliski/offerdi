package cn.stanliski.offer51.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Time Complexity = O(2^n)
 * Sub sets
 * Given a set of distinct integers, return all possible subsets.
 * 
 * Note
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * @author stanley_hwang
 *
 */
public class Subsets {

	 /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if(S == null || S.size() == 0)
    		return rst;
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	Collections.sort(S); // make it non-descending
    	subsets(rst, solution, S, 0);
     	return rst;
    }
    
    public void subsets(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> solution,
    		ArrayList<Integer> s, int index){
    	rst.add(new ArrayList<Integer>(solution));
    	for(int i = index; i < s.size(); i++){
    		solution.add(s.get(i));
    		subsets(rst, solution, s, i+1);
    		solution.remove(solution.size()-1);
    	}
    }
    
	
}
