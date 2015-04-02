package cn.stanliski.offer51.DFS;

import java.util.ArrayList;


/**
 * 
 * 给定n个不同的正整数，整数k（1<= k <= n）以及一个目标数字。　　　　
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案。
 * 样例
 * 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
 * 
 * @author stanley_hwang
 *
 */
public class KSum {
		
	 /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if(A == null || A.length == 0)
    		return rst;
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	kSumHelper(rst, solution, A, k, target, 0);
    	return rst;
    }
	
    public void kSumHelper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> solution, 
    																	int A[], int k, int target, int start){
    	if(solution.size() == k){
    		if(target == 0){
    			rst.add(new ArrayList<Integer>(solution));
    		}
    		return;
    	}
    	for(int i = start; i < A.length; i++){
    		solution.add(A[i]);
    		kSumHelper(rst, solution, A, k, target-A[i], i+1);
    		solution.remove(solution.size()-1);
    	}
    }
    
    public static void main(String args[]){
    	//给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
    	int[] A = new int[]{1,2,3,4};
    	KSum ksum = new KSum();
    	ArrayList<ArrayList<Integer>> rst = ksum.kSumII(A, 2, 5);
    	for(ArrayList<Integer> list : rst){
    		for(Integer index : list){
    			System.out.print(index + " ");
    		}
    		System.out.println();
    	}
    }
    
}
