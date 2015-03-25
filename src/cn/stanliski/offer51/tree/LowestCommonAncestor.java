package cn.stanliski.offer51.tree;

/**
 * 
 * Lowest common parents.
 * 
 * @author stanley_hwang
 *
 */
public class LowestCommonAncestor {
	
	/**
	 * Check if node p is the child of the root.
	 * @param root
	 * @param p
	 * @return
	 */
	public boolean covers(TreeNode root, TreeNode p){
		if(root == null)
			return false;
		if(root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	/**
	 * Common Ancestor Helper.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		if(is_p_on_left != is_q_on_left)
			return root;
		TreeNode child_side = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	
	
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root.left, p) || !covers(root.right, q))
			return null;
		return commonAncestorHelper(root, p, q);
	}
	
}
