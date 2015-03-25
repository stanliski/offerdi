package cn.stanliski.offer51.tree;

/**
 * 
 * Symmetric Tree.
 * 
 * @author stanley_hwang
 *
 */
public class SymmetricTree {
	
    public boolean isSymmetricII(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;
        boolean isleft = false;
        boolean isright = false;
        if(leftNode.val == rightNode.val){  
            isleft = isSymmetric(leftNode.left, rightNode.right);
            isright = isSymmetric(leftNode.right,rightNode.left);
        }
        return isleft && isright;    
    }

	/**
	 * Is symmetric.
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	public boolean isSymmetricHelper(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		return left.val == right.val && isSymmetricHelper(left.left, right.right) 
				&& isSymmetricHelper(left.right, right.left);
	}

}
