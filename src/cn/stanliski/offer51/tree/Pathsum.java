package cn.stanliski.offer51.tree;

public class Pathsum {
	
	  public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null)
	            return false;
	        return hasPathSumHelper(root, sum);
	  }
	  
	  public boolean hasPathSumHelper(TreeNode root, int sum){
		  if(root == null)
			  return false;
		  if(root.left == null && root.right == null){
			  return sum == root.val;
		  }
		  return hasPathSumHelper(root.left, sum-root.val) 
				  || hasPathSumHelper(root.right, sum-root.val);
	  }

}
