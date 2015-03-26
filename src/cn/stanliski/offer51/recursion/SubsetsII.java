package cn.stanliski.offer51.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
	
	 /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if(S == null || S.size() == 0)
    		return rst;
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	Collections.sort(S); // make it non-descending
    	subsets(rst, solution, S, 0);
     	return rst;
    }
    
    
    public void subsets(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> solution, 
    		ArrayList<Integer> s, int pos){
    	rst.add(new ArrayList(solution));
    	for(int i = pos; i < s.size(); i++){
    		if(i != pos && solution.get(i-1) == solution.get(i))
    			continue;
    		solution.add(s.get(i));
    		subsets(rst, solution, s, i+1);
    		solution.remove(solution.size()-1);
    	}
    }
    
	
}
