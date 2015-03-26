package cn.stanliski.offer51.recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * @author stanley_hwang
 *
 */
public class Combinations {

	public ArrayList<ArrayList<Integer>> combineII(int n, int k) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		helper(rst, solution, n, k, 1);
		return rst;
	}

	private void helper(
			ArrayList<ArrayList<Integer>> rst, 
			ArrayList<Integer> solution, 
			int n, 
			int k, 
			int start) {

		if (solution.size() == k){
			rst.add(new ArrayList(solution));
			return;
		}

		for(int i = start; i<= n; i++){
			solution.add(i);

			// the new start should be after the next number after i
			helper(rst, solution, n, k, i+1); 
			solution.remove(solution.size() - 1);
		}
	}
	
	public static void main(String args[]){
		int n = 4;
		int k = 2;
		Combinations combinations = new Combinations();
		ArrayList<ArrayList<Integer>> rst = combinations.combine(n, k);
		for(ArrayList<Integer> list : rst){
			System.out.print("[");
			for(Integer data : list){
				System.out.print(data + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	 /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		helper(rst, solution, n, k, 1);
		return rst;
    }
    
    public void combineHelper(ArrayList<ArrayList<Integer>> rst, 
    		ArrayList<Integer> solutions, 
    		int k, int n, int start){
    	if(solutions.size() == k){
    		rst.add(new ArrayList<Integer>(solutions));
    		return;
    	}
    	for(int i = 1; i <= n; i++){
    		solutions.add(i);
    		combineHelper(rst, solutions, k, n, i+1);
    		solutions.remove(solutions.size()-1);
    	}
    	return;
    }
	

}
