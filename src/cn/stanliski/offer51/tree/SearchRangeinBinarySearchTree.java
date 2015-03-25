package cn.stanliski.offer51.tree;

import java.util.ArrayList;

/**
 * 
 * Search Range in Binary Search Tre
 * 
 * @author stanley_hwang
 *
 */
public class SearchRangeinBinarySearchTree {
	
	 /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	searchRangeHelper(root, results, k1, k2);
    	return results;
    }
    
    public void searchRangeHelper(TreeNode root, ArrayList<Integer> results, int k1, int k2){
    	if(root == null)
    		return;
    	if(root.val > k1)
    		searchRangeHelper(root.left, results, k1, k2);
    	if(root.val <= k2 && root.val >= k1){
    		results.add(root.val);
    	}
    	if(root.val < k2){
    		searchRangeHelper(root.right, results, k1, k2);
    	}
    }
	 
}
