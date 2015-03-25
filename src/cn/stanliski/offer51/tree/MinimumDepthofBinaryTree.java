package cn.stanliski.offer51.tree;

/**
 * 
 * Minimum Depth of Binary Tree
 * 
 * @author stanley_hwang
 *
 */
public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMin(root);
	}
	
	public int getMin(TreeNode root){
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.left == null || root.right == null)
			return 1;
		return Math.min(getMin(root.left), getMin(root.right)) + 1;
	}
	
}	
