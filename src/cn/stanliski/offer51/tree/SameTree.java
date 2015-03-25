package cn.stanliski.offer51.tree;

/**
 * Same Tree.
 * 
 * @author Stanley
 *
 */
public class SameTree {
	
	public boolean isSameTreeMe(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
		
	/**
	 * is Same Tree.
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	/**
	 * is Symmetric tree
	 * @param root
	 * @return
	 */
	public boolean isSymmetricTree(TreeNode root){
		if(root == null)
			return true;
		return dfsTree(root.left, root.right);
	}
	
	public boolean dfsTree(TreeNode l1, TreeNode l2){
		if(l1 == null && l2 == null)
			return true;
		if(l1 == null || l2 == null)
			return false;
		if(l1.val != l2.val)
			return false;
		return dfsTree(l1.left, l2.right) && dfsTree(l1.right, l2.left);
	}
	
	
}
