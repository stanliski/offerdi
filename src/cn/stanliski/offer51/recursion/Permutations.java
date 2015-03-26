package cn.stanliski.offer51.recursion;

import java.util.ArrayList;

/**
 * 
 * Permutations.
 * 
 * @author stanley_hwang
 *
 */
public class Permutations {

	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if(nums == null || nums.size() == 0)
    		return rst;
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	permuteHelper(rst, solution, nums);
    	return rst;
    }
    
    /**
     * Permutations helper.
     * @param rst
     * @param solution
     * @param num
     * @return
     */
    public void permuteHelper(ArrayList<ArrayList<Integer>> rst, 
    		ArrayList<Integer> solution, ArrayList<Integer> nums){
    	if(solution.size() == nums.size()){
    		rst.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	for(int i = 0; i < nums.size(); i++){
    		if(solution.contains(nums.get(i))){
    			continue;
    		}
    		solution.add(nums.get(i));
    		permuteHelper(rst, solution, nums);
    		solution.remove(solution.size()-1);
    	}
    }	
    
    public static void main(String args[]){
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list1 = new ArrayList<Integer>();
    	Permutations up = new Permutations();
    	list1.add(1);
    	list1.add(2);
    	list1.add(3);
    	list1.add(4);
    	rst = up.permute(list1);
    	for(ArrayList<Integer> list : rst){
    		for(Integer num : list){
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
    
}
