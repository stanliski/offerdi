package cn.stanliski.offer51.tree;

import java.util.ArrayList;

/**
 * 
 * Path sum II.
 * @author stanley_hwang
 *
 */
public class PathsumII {
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		pathsumHelper(result, solution, root, sum);
		return result;
	}
	
	/**
	 * Path sum helper.
	 * @param root
	 * @param sum
	 */
	public void pathsumHelper(ArrayList<ArrayList<Integer>> result, ArrayList solution, TreeNode root, int sum){
		if(root == null)
			return;
		sum = sum - root.val;
		if(root.left == null && root.right == null){
			if(sum == 0){
				solution.add(root.val);
				result.add(new ArrayList<Integer>(solution));
				solution.remove(solution.size()-1);
			}
			return;
		}
		solution.add(root.val);
		pathsumHelper(result, solution, root.left, sum);
		pathsumHelper(result, solution, root.right, sum);
		solution.remove(solution.size()-1);
	}
	
}
